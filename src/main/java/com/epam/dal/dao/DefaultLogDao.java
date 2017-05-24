package com.epam.dal.dao;

import com.epam.dal.domain.Log;
import com.epam.dal.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Component
public class DefaultLogDao implements LogDao{

    private LogRepository logRepository;

    @Override
    public void save(Log log) {
        //TODO logEntitiyTransformer
        logRepository.save();
    }

    @Override
    public void update(Log log) {
        //TODO
    }

    @Override
    public void delete(Long logId) {
        //TODO
    }
}
