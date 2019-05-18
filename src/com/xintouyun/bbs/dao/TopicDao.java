package com.xintouyun.bbs.dao;

import java.util.List;

//import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;

public interface TopicDao {
	/**
	 * �鿴��������
	 * @return ���󼯺�
	 */
	List <Topic> listTopic();
	/**
	 * �鿴ָ���������������
	 * @param bid
	 * @return ���󼯺�
	 */
	List <Topic> listTopic(int bid);
	/**
	 * ���һ������
	 * @param topic
	 * @return ������Ӱ������
	 */
	int saveTopic(Topic topic);
	/**
	 * ��������idɾ��
	 * @param tid
	 * @return ������Ӱ������
	 */
	int deleteTopic(int tid);
	
	/**
	 * ���ݰ����ͳ����������
	 * @param bid �����
	 * @return ��������
	 */
	int countByBid(int bid);
	/**
	 * ��ʾ���������Ծ���û�
	 * @return
	 */
	List<String> listActiveUsers();
	/**
	 * ���ݻ����鿴�����Ƿ����
	 * @param reply
	 * @return
	 */
	boolean findTopicByTid(int tid);
}
