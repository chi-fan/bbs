package com.xintouyun.bbs.service;

import java.util.List;

import com.xintouyun.bbs.entity.User;

public interface UserService {
	/**
	 * ��ѯ�����û�
	 * @return �û��б�
	 */
	List<User> showDisabledUsers(int state);
	
	/**
	 * ��ѯ�����û�
	 * @return �û��б�
	 */
	List<User> showEnabledUsers(int state);
	/**
	 * ����ָ���û�
	 * @param uid �û����
	 * @return true�ɹ���falseʧ��
	 */
	boolean disableUser(int uid);
}
