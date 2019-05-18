package com.xintouyun.bbs.util;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.service.impl.BaseServiceImpl;

public class UserUtil extends MenuFactoryNew{
	static BaseServiceImpl bsi=new BaseServiceImpl();	
	//发帖
		public static boolean Post() {
			System.out.println("请输入主贴标题");
			String title=sc.next();
			System.out.println("请输入內容");
			String context=sc.next();
			int uid=user.getUid();
			System.out.println("请输入主贴所在的版块号");
			int bid=sc.nextInt();
			Topic topic=new Topic();
			topic.setTitle(title);
			topic.setContext(context);
			topic.setUid(uid);
			topic.setBid(bid);
			boolean result=bsi.post(topic);
			return result;
			
		}
		//回帖
		public static boolean RePost() {
			System.out.println("请输入标题");
			String title=sc.next();
			System.out.println("请输入內容");
			String context=sc.next();
			int uid=user.getUid();
			System.out.println("請輸入所在主貼號");
			int tid=sc.nextInt();
			Reply reply=new Reply();
			reply.setTitle(title);
			reply.setContext(context);
			reply.setUid(uid);
			reply.setTid(tid);
			boolean result=bsi.rePost(reply,tid);
			return result;
			
		}
}
