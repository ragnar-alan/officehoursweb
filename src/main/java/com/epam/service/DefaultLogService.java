package com.epam.service;

import com.epam.dal.dao.LogDao;
import com.epam.dal.domain.Log;
import com.epam.dal.repository.LogRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Component("LogService")
public class DefaultLogService implements LogService {

    private LogDao logDao;

    @Override
    public void save(Log log) {
        logDao.save(log);
    }
}
