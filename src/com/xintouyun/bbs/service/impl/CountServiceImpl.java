package com.xintouyun.bbs.service.impl;

import java.util.List;

import com.xintouyun.bbs.dao.impl.TopicDaoImpl;
import com.xintouyun.bbs.entity.User;
import com.xintouyun.bbs.service.CountService;
public class CountServiceImpl implements CountService {
	TopicDaoImpl tdi=new TopicDaoImpl();
	@Override
	//��ѯĳ������е�������
	public int countAllTopicNum(int bid) {
		int i=tdi.countByBid(bid);
		return i;
	}
	//��ѯ������������Ծ�û�ǰ����
	public List<User> countActiveUser(){	
		return null;
		
	}
}
