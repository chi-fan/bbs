package com.xintouyun.bbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xintouyun.bbs.dao.UserDao;
import com.xintouyun.bbs.entity.User;
import com.xintouyun.bbs.entity.UserState;
import com.xintouyun.bbs.util.JdbcUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User queryByUnameAndUpass(String uname, String upass) 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		User user=null;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select * from user where uname=? and upass=? and state=0;" );	
			st.setString(1, uname);
			st.setString(2, upass);
			rs=st.executeQuery();
			System.out.println(rs);
			while(rs.next())
			 {
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpass(rs.getString("upass"));
				user.setState(rs.getInt("state"));
				user.setFlag(rs.getInt("flag"));
			}
		} catch (Exception e)
		 {
			e.printStackTrace();
		} finally 
		{
			JdbcUtil.closeAll(rs, st, conn);
		}
		return user;
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("insert into user(uname,upass,state,flag) values(?,?,0,1)");
			st.setString(1, user.getUname());
			st.setString(2, user.getUpass());
			/*st.setInt(3, user.getState());
			st.setInt(4, user.getFlag());*/
			affectedRow = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

	@Override
	public List<User> listByState(int state) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<User> list=new ArrayList<User>();
		User user=null;
		//UserState userstate=null;
		try {
			conn = JdbcUtil.getConnection();
			st=conn.prepareStatement("select * from user u,userstate us where u.state=us.id and u.state=?");
			//st = conn.prepareStatement("select * from user where state=?");
			st.setInt(1, state);
			rs=st.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpass(rs.getString("upass"));
				user.setState(rs.getInt("state"));
				user.setFlag(rs.getInt("flag"));
				//
				UserState userState = new UserState();
				userState.setName(rs.getString("name"));
				userState.setId(rs.getInt("id"));
				user.setUserState(userState);

			list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return list;
	}

	@Override
	public int DisableUser(int uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("update user set state=1 where uid=?");
			st.setInt(1, uid);
			st.executeUpdate();		
			affectedRow = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

}
