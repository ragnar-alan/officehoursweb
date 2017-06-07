package com.epam.dal.domain;

import lombok.Data;

/**
 * Created by Tamas_Boros on 6/1/2017.
 */
@Data
public class UserRole {

    private Long id;
    private String role;
    private User user;

}
