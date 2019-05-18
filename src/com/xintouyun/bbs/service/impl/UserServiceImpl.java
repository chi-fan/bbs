package com.xintouyun.bbs.service.impl;
import java.util.List;

import com.xintouyun.bbs.dao.impl.UserDaoImpl;
import com.xintouyun.bbs.entity.User;
import com.xintouyun.bbs.service.UserService;

public class UserServiceImpl implements UserService{
	UserDaoImpl udi=new UserDaoImpl();
	@Override
	public List<User> showDisabledUsers(int state) {
		List<User> list=udi.listByState(1);
		return list;
	}
	@Override
	public List<User> showEnabledUsers(int state) {
		List<User> list=udi.listByState(0);
		return list;
	}
	@Override
	public boolean disableUser(int uid) {
		return udi.DisableUser(uid)>0;
	}
}
