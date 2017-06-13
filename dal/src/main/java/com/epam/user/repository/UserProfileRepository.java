package com.epam.user.repository;


import com.epam.user.domain.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    UserProfileEntity save(UserProfileEntity userProfileEntity);
}
