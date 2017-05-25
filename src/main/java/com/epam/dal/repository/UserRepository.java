package com.epam.dal.repository;

import com.epam.dal.domain.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity save(UserEntity userEntity);
    void delete(Long id);
}
