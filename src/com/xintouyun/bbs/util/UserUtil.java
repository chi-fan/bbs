package com.xintouyun.bbs.util;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.service.impl.BaseServiceImpl;

public class UserUtil extends MenuFactoryNew{
	static BaseServiceImpl bsi=new BaseServiceImpl();	
	//����
		public static boolean Post() {
			System.out.println("��������������");
			String title=sc.next();
			System.out.println("���������");
			String context=sc.next();
			int uid=user.getUid();
			System.out.println("�������������ڵİ���");
			int bid=sc.nextInt();
			Topic topic=new Topic();
			topic.setTitle(title);
			topic.setContext(context);
			topic.setUid(uid);
			topic.setBid(bid);
			boolean result=bsi.post(topic);
			return result;
			
		}
		//����
		public static boolean RePost() {
			System.out.println("���������");
			String title=sc.next();
			System.out.println("���������");
			String context=sc.next();
			int uid=user.getUid();
			System.out.println("Ոݔ���������N̖");
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
