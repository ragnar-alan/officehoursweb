package com.epam.dal.domain;

import javax.persistence.*;

/**
 * Created by Tamas_Boros on 5/24/2017.
 */

@Entity
@Table(name="token")
public class UserTokenEntity {
    @Id
    @GeneratedValue
    @Column
    private Long tokenId;
}
