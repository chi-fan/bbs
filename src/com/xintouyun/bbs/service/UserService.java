package com.xintouyun.bbs.service;

import java.util.List;

import com.xintouyun.bbs.entity.User;

public interface UserService {
	/**
	 * 查询禁用用户
	 * @return 用户列表
	 */
	List<User> showDisabledUsers(int state);
	
	/**
	 * 查询正常用户
	 * @return 用户列表
	 */
	List<User> showEnabledUsers(int state);
	/**
	 * 禁用指定用户
	 * @param uid 用户编号
	 * @return true成功，false失败
	 */
	boolean disableUser(int uid);
}
