package com.epam.log.repository;


import com.epam.log.domain.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {

}
