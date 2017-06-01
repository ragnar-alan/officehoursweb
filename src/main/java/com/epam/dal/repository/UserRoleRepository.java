package com.epam.dal.repository;

import com.epam.dal.domain.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Repository
public interface UserRoleRepository  extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findByUser(Long userId);
}
