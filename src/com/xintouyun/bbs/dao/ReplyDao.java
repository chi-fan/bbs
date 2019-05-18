package com.xintouyun.bbs.dao;

import java.util.List;

import com.xintouyun.bbs.entity.Reply;

public interface ReplyDao {
	/**
	 * ��ӻ�������
	 * @param reply
	 * @return ������Ӱ������
	 */
	int saveReply(Reply reply);
	/**
	 * �����������г������л���
	 * @param tid
	 * @return
	 */
	List <Reply> queryReplyByTid(int tid);
	/**
	 * ����������ɾ������
	 * @param tid
	 * @return ������Ӱ������
	 */
	int deleteByTid(int tid);
}
