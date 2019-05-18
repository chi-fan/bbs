package com.xintouyun.bbs.dao;

import java.util.List;

import com.xintouyun.bbs.entity.User;

public interface UserDao {
	/**
	 * 根据用户名和密码查询
	 * @param uname
	 * @param upass
	 * @return 数据表中有一条记录返回一个user对象，否则返回null
	 */
	User queryByUnameAndUpass(String uname,String upass);
	/**
	 * 保存一个用户对象
	 * @param user
	 * @return 返回受影响行数
	 */
	int saveUser(User user);
	/**
	 * 根据用户状态筛选
	 * @param state
	 * @return 返回符合条件的对象集合
	 */
	List <User> listByState(int state);
	/**
	 * 修改用户状态，禁用用户
	 * @param uid
	 * @return 返回受影响行数
	 */
	int DisableUser(int uid);
}
