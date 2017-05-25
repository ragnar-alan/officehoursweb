package com.epam.dal.repository;

import com.epam.dal.domain.LogEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
@Qualifier("logRepository")
public interface LogRepository extends JpaRepository<LogEntity, Long> {

}
