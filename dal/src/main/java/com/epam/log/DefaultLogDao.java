package com.epam.log;


import com.epam.log.domain.Log;
import com.epam.log.repository.LogRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Component
public class DefaultLogDao implements LogDao{

    private LogRepository logRepository;


    @Override
    public void update(Log log) {
        //TODO
    }

    @Override
    public void delete(Long logId) {
        //TODO
    }
}
