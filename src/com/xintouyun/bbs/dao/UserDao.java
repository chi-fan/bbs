package com.xintouyun.bbs.dao;

import java.util.List;

import com.xintouyun.bbs.entity.User;

public interface UserDao {
	/**
	 * �����û����������ѯ
	 * @param uname
	 * @param upass
	 * @return ���ݱ�����һ����¼����һ��user���󣬷��򷵻�null
	 */
	User queryByUnameAndUpass(String uname,String upass);
	/**
	 * ����һ���û�����
	 * @param user
	 * @return ������Ӱ������
	 */
	int saveUser(User user);
	/**
	 * �����û�״̬ɸѡ
	 * @param state
	 * @return ���ط��������Ķ��󼯺�
	 */
	List <User> listByState(int state);
	/**
	 * �޸��û�״̬�������û�
	 * @param uid
	 * @return ������Ӱ������
	 */
	int DisableUser(int uid);
}
