package com.epam.dal.domain;

import lombok.Data;

import java.sql.Date;
import java.time.ZonedDateTime;


/**
 * Created by Tamas_Boros on 5/24/2017.
 */
@Data
public class User {

    private Long userId;
    private String userEmail;
    private String userPassword;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;

}
