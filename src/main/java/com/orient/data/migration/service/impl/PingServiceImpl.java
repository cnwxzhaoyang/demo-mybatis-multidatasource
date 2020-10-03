package com.orient.data.migration.service.impl;

import com.orient.data.migration.dao._new.NewUserMapper;
import com.orient.data.migration.dao.old.OldUserMapper;
import com.orient.data.migration.entity._new.NewUser;
import com.orient.data.migration.entity.old.OldUser;
import com.orient.data.migration.service.IPingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @see
 * @since JDK1.8
 * date 2020/10/3 17:04
 */
@Service
public class PingServiceImpl implements IPingService {

    @Autowired
    NewUserMapper newUserMapper;

    @Autowired
    OldUserMapper oldUserMapper;


    public NewUser findNewUserById(String id) {
        return newUserMapper.selectByPrimaryKey(id);
    }

    public OldUser findOldUserById(int id) {
        return oldUserMapper.selectByPrimaryKey(id);
    }
}
