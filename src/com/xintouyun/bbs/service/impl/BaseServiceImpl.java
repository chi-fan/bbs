package com.xintouyun.bbs.service.impl;

import com.xintouyun.bbs.dao.impl.ReplyDaoImpl;
import com.xintouyun.bbs.dao.impl.TopicDaoImpl;
import com.xintouyun.bbs.dao.impl.UserDaoImpl;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.entity.User;
import com.xintouyun.bbs.service.BaseService;

public class BaseServiceImpl implements BaseService {
	 
	 TopicDaoImpl tdi=new TopicDaoImpl();
	 UserDaoImpl udi=new UserDaoImpl();
	 ReplyDaoImpl rdi=new ReplyDaoImpl();
	@Override
	public User checkLogin(String uname, String upass) 
	{
		User user=udi.queryByUnameAndUpass(uname, upass);
		return user;
	}

	@Override
	public boolean register(User user) {
		return udi.saveUser(user) > 0;
	}

	@Override
	public boolean post(Topic topic) {
		return tdi.saveTopic(topic) > 0;
	}

	@Override
	public boolean rePost(Reply reply,int tid) {
		boolean i=false;
		if(!tdi.findTopicByTid(tid)) {
		i=false;
		}else {
			rdi.saveReply(reply);
			i=true;
		}
		return i;
	}

}
