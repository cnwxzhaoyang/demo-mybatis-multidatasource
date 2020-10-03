package com.orient.data.migration.dao._new;

import com.orient.data.migration.entity._new.NewUser;

public interface NewUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(NewUser record);

    int insertSelective(NewUser record);

    NewUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NewUser record);

    int updateByPrimaryKey(NewUser record);
}