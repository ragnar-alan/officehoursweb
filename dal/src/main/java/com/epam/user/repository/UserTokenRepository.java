package com.epam.user.repository;

import com.epam.user.domain.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tamas_Boros on 6/20/2017.
 */
public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Long> {

}
