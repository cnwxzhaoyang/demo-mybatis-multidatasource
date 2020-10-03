package com.orient.data.migration.service;

import com.orient.data.migration.entity._new.NewUser;
import com.orient.data.migration.entity.old.OldUser;

import java.util.List;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @see
 * @since JDK1.8
 * date 2020/10/3 17:02
 */
public interface IPingService {

    NewUser findNewUserById(String id);


    OldUser findOldUserById(int id);
}
