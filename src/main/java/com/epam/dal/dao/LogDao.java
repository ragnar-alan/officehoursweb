package com.epam.dal.dao;

import com.epam.dal.domain.Log;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */
public interface LogDao {

    void update(Log log);
    void delete(Long logId);

}
