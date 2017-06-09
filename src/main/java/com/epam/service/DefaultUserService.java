package com.epam.service;

import com.epam.dal.dao.UserDao;
import com.epam.dal.dao.UserProfileDao;
import com.epam.dal.dao.UserRoleDao;
import com.epam.dal.domain.*;
import com.epam.dal.transformer.UserEntityTransformer;
import com.epam.dal.transformer.UserRoleTransformer;
import com.epam.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserProfileDao userProfileDao;

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    @Autowired
    private UserRoleTransformer userRoleTransformer;

    @Override
    @Transactional
    public User save(User user) {
        UserEntity userEntity = userDao.save(user);
        UserProfileEntity userProfileEntity = userProfileDao.save(createNewUserProfile(userEntity));
        UserRoleEntity userRoleEntity = userRoleDao.save(createNewUserRoleRecord(userEntity));
        return userEntityTransformer.transformUserEntityToUser(userEntity);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(Long uid) {
        return userDao.getOneUserById(uid);
    }

    @Override
    public User getUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }

    private List<GrantedAuthority> buildUserAuthority(UserRole userRole) {
        Set<GrantedAuthority> setAuths = new HashSet<>();
        setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        List<GrantedAuthority> authorities = new ArrayList<>(setAuths);

        return authorities;
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(),
                true, true, true, true, authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = getUserByEmail(email);
        UserRole role = userRoleDao.findByUser(user.getUserId());
        List<GrantedAuthority> userRole = buildUserAuthority(role);
        return buildUserForAuthentication(user, userRole);
    }

    private UserRole createNewUserRoleRecord(UserEntity userEntity) {
        UserRole userRole = new UserRole();
        userRole.setRole("ADMIN");
        userRole.setUser(userEntityTransformer.transformUserEntityToUser(userEntity));
        return userRole;
    }

    private UserProfile createNewUserProfile(UserEntity userEntity) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(userEntityTransformer.transformUserEntityToUser(userEntity));
        userProfile.setCreatedAt(userEntity.getCreatedAt());
        userProfile.setUpdatedAt(userEntity.getUpdatedAt());
        return userProfile;
    }
}
