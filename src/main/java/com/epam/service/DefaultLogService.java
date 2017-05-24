package com.epam.service;

import com.epam.dal.dao.LogDao;
import com.epam.dal.domain.Log;
import org.springframework.stereotype.Service;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Service
public class DefaultLogService implements LogService {

    private LogDao logDao;

    @Override
    public void save(Log log) {
        logDao.save(log);
    }
}
