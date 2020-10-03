package com.orient.data.migration.dao.old;

import com.orient.data.migration.entity.old.OldUser;

public interface OldUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(OldUser record);

    int insertSelective(OldUser record);

    OldUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(OldUser record);

    int updateByPrimaryKey(OldUser record);
}