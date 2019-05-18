package com.xintouyun.bbs.service;

import java.util.List;

import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;

public interface TopicService {
	/**
	 * 查看所有主贴
	 * @return 主贴集合
	 */
	List<Topic> showAllTopic();
	/**
	 * 查看指定板块下主贴
	 * @param bid
	 * @return 主贴集合
	 */
	List<Topic> showAllTopic(int bid);
	/**
	 * 根据主贴号删除主贴
	 * @param tid
	 * @return 成功返回true,否则返回false
	 */
	boolean deleteTopic(int tid);
	/**
	 * 查询主贴的所有回帖
	 * @param tid
	 * @return 主贴的所有回帖的集合
	 */
	List<Reply> queryReplyByTid(int tid);
	/**
	 * 根据主贴删除所有回帖
	 * @param tid 主贴号
	 * @return 删除成功返回true，否则返回false
	 */
	boolean deleteReplyByTid(int tid);
	/**
	 * 根据版块统计主贴数目
	 * @param bid
	 * @return
	 */
	int countByBid(int bid);
	/**
	 * 获取所有主贴的uid
	 * @return 
	 */
	List<String> countActiveUser();
	
}
