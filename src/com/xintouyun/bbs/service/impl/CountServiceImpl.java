package com.xintouyun.bbs.service.impl;

import java.util.List;

import com.xintouyun.bbs.dao.impl.TopicDaoImpl;
import com.xintouyun.bbs.entity.User;
import com.xintouyun.bbs.service.CountService;
public class CountServiceImpl implements CountService {
	TopicDaoImpl tdi=new TopicDaoImpl();
	@Override
	//查询某个版块中的主贴数
	public int countAllTopicNum(int bid) {
		int i=tdi.countByBid(bid);
		return i;
	}
	//查询最近三个月最活跃用户前三名
	public List<User> countActiveUser(){	
		return null;
		
	}
}
