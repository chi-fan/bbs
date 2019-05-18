package com.xintouyun.bbs.service.impl;
import java.util.List;

import com.xintouyun.bbs.dao.impl.ReplyDaoImpl;
import com.xintouyun.bbs.dao.impl.TopicDaoImpl;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.service.TopicService;

public class TopicServiceImpl implements TopicService {
	TopicDaoImpl tdi=new TopicDaoImpl();
	ReplyDaoImpl rdi=new ReplyDaoImpl();
	@Override
	public List<Topic> showAllTopic() {
		List<Topic> list=tdi.listTopic();
		return list;
	}

	@Override
	public List<Topic> showAllTopic(int bid) {
		List<Topic> list=tdi.listTopic(bid);
		return list;
	}

	@Override
	public boolean deleteTopic(int tid) {
		return tdi.deleteTopic(tid)>0;
	}

	@Override
	public boolean deleteReplyByTid(int tid) {
		return rdi.deleteByTid(tid)>0;
	}

	@Override
	public List<Reply> queryReplyByTid(int tid) {
		List<Reply> list=rdi.queryReplyByTid(tid);
		return list;
	}

	@Override
	public int countByBid(int bid) {
		int count=tdi.countByBid(bid);
		return count;
	}

	@Override
	public List<String> countActiveUser() {
		List<String> list=tdi.listActiveUsers();
		return list;
	}

}
