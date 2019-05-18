package com.xintouyun.bbs.dao;

import java.util.List;

//import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;

public interface TopicDao {
	/**
	 * 查看所有主贴
	 * @return 对象集合
	 */
	List <Topic> listTopic();
	/**
	 * 查看指定板块下所有主贴
	 * @param bid
	 * @return 对象集合
	 */
	List <Topic> listTopic(int bid);
	/**
	 * 添加一个主贴
	 * @param topic
	 * @return 返回受影响行数
	 */
	int saveTopic(Topic topic);
	/**
	 * 根据主贴id删除
	 * @param tid
	 * @return 返回受影响行数
	 */
	int deleteTopic(int tid);
	
	/**
	 * 根据板块编号统计主贴条数
	 * @param bid 板块编号
	 * @return 主贴条数
	 */
	int countByBid(int bid);
	/**
	 * 显示最近发帖活跃的用户
	 * @return
	 */
	List<String> listActiveUsers();
	/**
	 * 根据回帖查看主贴是否存在
	 * @param reply
	 * @return
	 */
	boolean findTopicByTid(int tid);
}
