package com.epam.dal.repository;

import com.epam.dal.domain.UserEntity;
import com.epam.dal.domain.UserProfile;
import com.epam.dal.domain.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Long> {
    UserProfileEntity save(UserProfileEntity userProfileEntity);
}
