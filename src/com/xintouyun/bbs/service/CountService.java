package com.xintouyun.bbs.service;

public interface CountService {
	/**
	 * 统计某个版块帖子总数
	 * @param bid 版块号
	 * @return 帖子总数
	 */
	int countAllTopicNum(int bid);
}
