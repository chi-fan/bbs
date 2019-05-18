package com.xintouyun.bbs.service;

import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.entity.User;

public interface BaseService {
	/**
	 * ��¼
	 * @param uname �û���
	 * @param upass ����
	 * @return �ɹ�����User��ʧ�ܷ���null
	 */
	User checkLogin(String uname,String upass) ;
	/**
	 * ע���û�
	 * @param user �û�����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	boolean register(User user);
	/**
	 * ����
	 * @param topic
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	boolean post(Topic topic);
	/**
	 * �؏�����
	 * @param reply
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	boolean rePost(Reply reply,int tid);
}
