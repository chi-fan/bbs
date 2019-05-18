package com.xintouyun.bbs.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.xintouyun.bbs.entity.Board;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.entity.User;
import com.xintouyun.bbs.service.BaseService;
import com.xintouyun.bbs.service.Boardservice;
import com.xintouyun.bbs.service.CountService;
import com.xintouyun.bbs.service.TopicService;
import com.xintouyun.bbs.service.UserService;
import com.xintouyun.bbs.service.impl.BaseServiceImpl;
import com.xintouyun.bbs.service.impl.BoardServiceImpl;
import com.xintouyun.bbs.service.impl.CountServiceImpl;
import com.xintouyun.bbs.service.impl.TopicServiceImpl;
import com.xintouyun.bbs.service.impl.UserServiceImpl;

public class MenuFactoryNew {
	static Scanner sc = new Scanner(System.in, "GBK");   //设置为gbk编码 控制台为gbk编码
	static int cursor = 0;
	static User user = null;
	// 程序主菜单
	public static void showBBSMenu()
	 {
		System.out.println("------------欢迎来到校园论坛-------------");
		System.out.println("1.管理员登录2.普通用户登录3.注册");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请输入正确选择：1：管理员登录2：普通房用户登录3：注册");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			user = showcheckLogMenu();
			if (user.getFlag() == 0) { // 验证管理员登陆
				showAdminMenu();// 验证通过进入管理员菜单
			} else {
				System.out.println("登录失败请重新输入");
				showBBSMenu();// 验证失败返回主菜单
			}
			break;
		case 2:
			user = showcheckLogMenu();
			if (user.getFlag() == 1) {// 验证普通用户登陆
				showUserMenu();// 验证通过进入普通用户菜单
			} else {
				System.out.println("登录失败请重新输入");
				showBBSMenu();// 验证失败返回主菜单
			}
			break;
		case 3:
			boolean i = RegMenu();
			if (i) {
				System.out.println("注册成功");
				showBBSMenu();// 注册结束返回主菜单
			} else {
				System.out.println("注册失败");// 注册失败返回主菜单
				showBBSMenu();
			}
			break;
		default:
			System.out.println("输入错误，请重新输入");
			showBBSMenu();
			break;
		}
	}

	// 管理员主菜单
	public static void showAdminMenu() {
		System.out.println("1.用户管理2.版块管理3.主贴管理4.统计汇总5.退出登录");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请重新输入正确选项：1.用户管理2.版块管理3.主贴管理4.统计汇总5.退出登录");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			showuserManager();// 用户管理
			break;
		case 2:
			showBoardManager();// 版块管理
			break;
		case 3:
			showTopicManager();// 主题管理
			break;
		case 4:
			showCountManager();// 统计汇总
			break;
		case 5:
			showBBSMenu();// 退出登录
			break;
		default:
			System.out.println("输入无效，提示输入值为1-5之间的整数，请重新输入");
			showAdminMenu();
			break;
		}
	}

	// 普通用户主菜单
	public static void showUserMenu() {
		TopicService tsi = new TopicServiceImpl();
		System.out.println("1.发帖2.回帖3.查看主贴4.查看回帖5.退出登录");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请重新输入正确选项：1.发帖2.回帖3.查看主贴4.查看回帖5.退出登录");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			boolean i = UserUtil.Post();
			if (i) {
				System.out.println("发帖成功");
				showUserMenu();
			} else {
				System.out.println("发帖失败");
				showUserMenu();
			}
			break;
		case 2:			
			boolean j= UserUtil.RePost();	//用户回帖			
			if (j) {
				System.out.println("回帖成功");
				showUserMenu();
			} else {
				System.out.println("回帖失败");
				showUserMenu();
			}
			break;
		case 3:
			List <Topic> lists= tsi.showAllTopic();
			System.out.println("所在版块号\t"+"主贴号\t"+"主贴标题\t"+"主贴内容\t"+"创建时间\t"+"发帖人id");
			for (Topic topic:lists) {
				System.out.println(topic.getBid()+"\t"+topic.getTid()+"\t"+topic.getTitle()+"\t"+topic.getContext()+"\t"+topic.getPtime()+"\t"+topic.getUid());
			}
			showUserMenu();
		case 4:
			System.out.println("请输入要查看的主贴号");
			int tid = sc.nextInt();
			List <Reply> lists1=tsi.queryReplyByTid(tid);
			System.out.println("回帖编号\t"+" 回帖标题\t"+" 回帖内容\t"+" 回帖时间 \t"+"回帖人编号\t"+" 主贴编号");
			for(Reply reply:lists1) {
				System.out.println(reply.getRid()+"\t"+reply.getTitle()+"\t"+reply.getContext()+"\t"+reply.getPtime()+"\t"+reply.getUid()+"\t"+reply.getTid());
			}
			showUserMenu();
		case 5:
			showBBSMenu();// 退出登录
			break;
		default:
			System.out.println("输入无效，提示1-5，请重新输入");
			showUserMenu();
			break;
		}
	}

	// 用户登录
	public static User showcheckLogMenu() 
	{
		BaseService bsi = new BaseServiceImpl();
		User user = null;
		System.out.println("请输入账号名字");
		String uname = sc.next();
		System.out.println(uname);
		System.out.println("请输入密码");
		String upass = sc.next();
		while (true) {
			try {
				user = bsi.checkLogin(uname, upass);
				if (user == null) {
					System.out.println("您输入的账号不存在");
					showBBSMenu();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
	}

	// 用户注册
	public static boolean RegMenu() {
		BaseService bsi = new BaseServiceImpl();
		System.out.println("请输入账号名字");
		String uname = sc.next();
		System.out.println("请输入密码");
		String upass = sc.next();
		User user = new User();
		user.setUname(uname);
		user.setUpass(upass);
		boolean result = bsi.register(user);
		return result;
	}

	// 用户管理菜单
	public static void showuserManager() {
		UserService usi = new UserServiceImpl();
		System.out.println("1.查询禁用用戶2.查询正常用戶3.禁用用戶4.返回管理员菜单");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请重新输入正确选项：1.查询禁用用戶2.查询正常用戶3.禁用用戶4.返回管理员菜单");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			List <User> list=usi.showDisabledUsers(1);
			Iterator<User> it=list.iterator();
			System.out.println("用户号\t"+"用户名字\t"+"用户状态");
			while(it.hasNext()) {
				User user=it.next();
				//String state=UserUtil.userStateChange(user.getState());
				System.out.println(user.getUid()+"\t"+user.getUname()+"\t"+user.getUserState().getName());
			}
			showuserManager();
			break;
		case 2:
			List <User> list1=new ArrayList<User>();
			list1.addAll(usi.showEnabledUsers(0));
			list =usi.showEnabledUsers(0);
			Iterator<User> it1=list.iterator();
			System.out.println("用户号\t"+"用户名字\t"+"用户状态");
			while(it1.hasNext()) {
				User user=it1.next();
				//String state=UserUtil.userStateChange(user.getState());
				System.out.println(user.getUid()+"\t"+user.getUname()+"\t"+user.getUserState().getName());
			}
			showuserManager();
			break;
		case 3:
			System.out.println("请输入要禁用的用户id");
			int uid = sc.nextInt();
			boolean j = usi.disableUser(uid);
			if (j) {
				System.out.println("禁用成功");
				showuserManager();
			} else {
				System.out.println("禁用失败");
				showuserManager();
			}
			break;
		case 4:
			showAdminMenu();
			break;
		default:
			System.out.println("输入无效，提示1/2/3/4");
			showuserManager();
			break;
		}
	}

	// 版块管理菜单
	public static void showBoardManager() {
	Boardservice bosi = new BoardServiceImpl();
		System.out.println("1.查詢所有版块2.添加版块3.返回管理员菜单");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请重新输入正确选项：1.查詢所有版块2.添加版块3.返回管理员菜单");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			List <Board> lists= bosi.showAllBoard();
				System.out.println("版块号\t"+"板块名");
			for (Board board:lists) {
				System.out.println(board.getBid()+"\t"+board.getBname());
			}
			showBoardManager();
		case 2:
			Board board = new Board();
			System.out.println("请输入要添加的版块名字");
			board.setBname(sc.next());
			boolean i=bosi.addBoard(board);
			if (i) {
				System.out.println("添加成功");
				showBoardManager();
			} else {
				System.out.println("添加失败");
				showBoardManager();
			}
		case 3:
			showAdminMenu();
			break;
		default:
			System.out.println("输入无效，提示1/2");
			showBoardManager();
			break;
		}
	}

	// 主贴管理菜单
	public static void showTopicManager() {
		TopicService tsi = new TopicServiceImpl();
		System.out.println("1.显示所有主贴2.显示指定版块主贴3.刪除主贴4.返回管理员菜单");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请重新输入正确选项：1.显示所有主贴2.显示指定版块主贴3.刪除主贴4.返回管理员菜单");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			List <Topic> lists= tsi.showAllTopic();
			System.out.println("所在版块号\t"+"所在版块\t"+"主贴号\t"+"主贴标题\t"+"主贴内容\t"+"创建时间\t"+"发帖人id\t"+"发帖人名字");
			for (Topic topic:lists) {
				System.out.println(topic.getBid()+"\t"+topic.getBname()+"\t"+topic.getTid()+"\t"+topic.getTitle()+"\t"+topic.getContext()+"\t"+topic.getPtime()+"\t"+topic.getUid()+"\t"+topic.getUname());
			}
			showTopicManager();
		case 2:
			System.out.println("请输入要显示版块的id");
			int bid = sc.nextInt();
			List <Topic> lists1= tsi.showAllTopic(bid);
			System.out.println("所在版块号\t"+"所在版块\t"+"主贴号\t"+"主贴标题\t"+"主贴内容\t"+"创建时间\t"+"发帖人id\t"+"发帖人名字");
			for (Topic topic:lists1) {
				System.out.println(topic.getBid()+"\t"+topic.getBname()+"\t"+topic.getTid()+"\t"+topic.getTitle()+"\t"+topic.getContext()+"\t"+topic.getPtime()+"\t"+topic.getUid()+"\t"+topic.getUname());
			}
			showTopicManager();
		case 3:
			System.out.println("请输入要删除主贴的id");
			int tid = sc.nextInt();
			boolean i=tsi.deleteTopic(tid);
			if (i) {
				System.out.println("删除成功");
				showTopicManager();
			} else {
				System.out.println("删除失败");
				showTopicManager();
			}
		case 4:
			showAdminMenu();
			break;
		default:
			System.out.println("输入无效，提示1/2/3");
			showTopicManager();
			break;
		}
	}

	// 统计汇总菜单
	public static void showCountManager() {
		CountService csi = new CountServiceImpl();
		TopicService tsi = new TopicServiceImpl();
		System.out.println("1.查询某个版块所有主贴数2.查询最近活跃用戶id 3.返回管理员菜单");
		while (true) {
			try {
				cursor = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("请重新输入正确选项：1.查询某个版块所有主贴数2.查询最近活跃用戶id 3.返回管理员菜单");
				sc = new Scanner(System.in);
			}
		}
		switch (cursor) {
		case 1:
			System.out.println("请输入你要查询的版块号");
			int bid = sc.nextInt();
			int count=csi.countAllTopicNum(bid);
			System.out.println("板块中主贴数为:" + count);
			showCountManager();
			break;
		case 2:
			System.out.println("最近活跃用户为:");
			List <String > list=tsi.countActiveUser();
			System.out.println("发帖人id");
			for(String uid:list) {
				System.out.println(uid);
			}
			showCountManager();
			break;
		case 3:
			showAdminMenu();
			break;
		default:
			System.out.println("输入无效，提示1/2");
			showCountManager();
			break;
		}
	}
}
