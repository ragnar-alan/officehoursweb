package com.epam.user.service;

import com.epam.user.dao.UserDAO;
import com.epam.user.dao.UserProfileDAO;
import com.epam.user.dao.UserRoleDAO;
import com.epam.user.domain.*;
import com.epam.user.exception.UserAlreadyExistException;
import com.epam.user.transformer.UserEntityTransformer;
import com.epam.user.transformer.UserRoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Service
public class DefaultUserService implements UserService {

    private static final String USER_ALREADY_EXIST = "This account is already exist. Please choose another email address or login";

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private UserProfileDAO userProfileDAO;

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    @Autowired
    private UserRoleTransformer userRoleTransformer;

    @Override
    @Transactional
    public User save(User user) {
        if (isUserAlreadyExist(user.getUserEmail())) {
            throw new UserAlreadyExistException(USER_ALREADY_EXIST);
        }

        UserEntity userEntity = userDAO.save(user);
        UserProfileEntity userProfileEntity = userProfileDAO.save(createNewUserProfile(userEntity));
        UserRoleEntity userRoleEntity = userRoleDAO.save(createNewUserRoleRecord(userEntity));

        return userEntityTransformer.transformUserEntityToUser(userEntity);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(Long uid) {
        return userDAO.getOneUserById(uid);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
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
        UserRole role = userRoleDAO.findByUser(user.getUserId());
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

    private boolean isUserAlreadyExist(String email) {
        return userDAO.existsByEmail(email);
    }
}
