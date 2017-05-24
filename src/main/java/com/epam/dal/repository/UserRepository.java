package com.epam.dal.repository;

import com.epam.dal.dao.UserDao;
import com.epam.dal.domain.User;
import com.epam.dal.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity save(UserEntity userEntity);
    void delete(Long id);
}
