package com.xintouyun.bbs.service;

import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.entity.User;

public interface BaseService {
	/**
	 * 登录
	 * @param uname 用户名
	 * @param upass 密码
	 * @return 成功返回User，失败返回null
	 */
	User checkLogin(String uname,String upass) ;
	/**
	 * 注册用户
	 * @param user 用户对象
	 * @return 成功返回true，失败返回false
	 */
	boolean register(User user);
	/**
	 * 发帖
	 * @param topic
	 * @return 成功返回true，失败返回false
	 */
	boolean post(Topic topic);
	/**
	 * 回復帖子
	 * @param reply
	 * @return 成功返回true，失败返回false
	 */
	boolean rePost(Reply reply,int tid);
}
