package com.xintouyun.bbs.dao;

import java.util.List;

import com.xintouyun.bbs.entity.Reply;

public interface ReplyDao {
	/**
	 * 添加回帖对象
	 * @param reply
	 * @return 返回受影响行数
	 */
	int saveReply(Reply reply);
	/**
	 * 根据主贴号列出其所有回帖
	 * @param tid
	 * @return
	 */
	List <Reply> queryReplyByTid(int tid);
	/**
	 * 根据主贴号删除回帖
	 * @param tid
	 * @return 返回受影响行数
	 */
	int deleteByTid(int tid);
}
