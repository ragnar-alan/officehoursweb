package com.epam.user.repository;

import com.epam.dal.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(Long userId);

    List<UserEntity> findAll();

    UserEntity save(UserEntity userEntity);

    void delete(Long id);

    UserEntity findByUserEmail(String userEmail);

}
