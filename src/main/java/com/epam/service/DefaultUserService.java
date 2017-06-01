package com.epam.service;

import com.epam.dal.dao.UserDao;
import com.epam.dal.dao.UserRoleDao;
import com.epam.dal.domain.User;
import com.epam.dal.domain.UserRole;
import com.epam.dal.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public void save(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        userDao.save(user);
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
}
