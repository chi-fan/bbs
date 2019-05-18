package com.xintouyun.bbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xintouyun.bbs.dao.TopicDao;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.entity.Topic;
import com.xintouyun.bbs.util.JdbcUtil;

public class TopicDaoImpl implements TopicDao{

	@Override
	public List<Topic> listTopic() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List <Topic> list=new ArrayList<Topic>();
		Topic topic=null;
		try {
			conn = JdbcUtil.getConnection();
			//st = conn.prepareStatement("select * from topic");
			st=conn.prepareStatement("select b.bid,b.bname,t.tid,t.title,t.context,t.ptime,u.uid,u.uname from board b,topic t,user u where u.uid=t.uid and b.bid=t.bid");
			rs=st.executeQuery();
			while(rs.next()) {
				topic=new Topic();
				topic.setBid(rs.getInt("bid"));
				topic.setTitle(rs.getString("title"));
				topic.setContext(rs.getString("context"));
				topic.setPtime(rs.getString("ptime"));
				topic.setUid(rs.getInt("uid"));
				topic.setTid(rs.getInt("tid"));
				topic.setBname(rs.getString("bname"));
				topic.setUname(rs.getString("uname"));
				list.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}	
		return list;
	}

	@Override
	public List<Topic> listTopic(int bid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List <Topic> list=new ArrayList<Topic>();
		Topic topic=null;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select b.bid,b.bname,t.tid,t.title,t.context,t.ptime,u.uid,u.uname from board b,topic t,user u where u.uid=t.uid and b.bid=t.bid group by b.bid having b.bid=?" );
			st.setInt(1, bid);
			rs=st.executeQuery();
			while(rs.next()) {
				topic=new Topic();
				topic.setBid(rs.getInt("bid"));
				topic.setTitle(rs.getString("title"));
				topic.setContext(rs.getString("context"));
				topic.setPtime(rs.getString("ptime"));
				topic.setUid(rs.getInt("uid"));
				topic.setTid(rs.getInt("tid"));
				topic.setBname(rs.getString("bname"));
				topic.setUname(rs.getString("uname"));
				list.add(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}	
		return list;
	}

	@Override
	public int saveTopic(Topic topic) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("insert into topic(title,context,ptime,uid,bid) values(?,?,now(),?,?)");
			st.setString(1, topic.getTitle());
			st.setString(2, topic.getContext());
			st.setInt(3, topic.getUid());
			st.setInt(4, topic.getBid());
			affectedRow=st.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

	@SuppressWarnings("resource")
	public int deleteTopic(int tid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Reply reply=null;
		List <Reply> list=new ArrayList<Reply>();
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			st = conn.prepareStatement("select * from reply where tid=?");
			st.setInt(1, tid);
			rs=st.executeQuery();
			while(rs.next()) {
				reply=new Reply();
				reply.setTitle(rs.getString("title"));
				reply.setContext(rs.getString("context"));
				reply.setPtime(rs.getString("ptime"));
				reply.setUid(rs.getInt("uid"));
				reply.setTid(rs.getInt("tid"));				
				list.add(reply);
			}	
			st = conn.prepareStatement("delete from reply where tid=?");
			st.setInt(1, tid);	
			st.executeUpdate();
			//int i=5/0;*/
			st = conn.prepareStatement("delete from topic where tid=?");
			st.setInt(1, tid);	
			affectedRow=st.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

	@Override
	public int countByBid(int bid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select count(*) from topic where bid=?");
			st.setInt(1, bid);
		rs=st.executeQuery();
		while(rs.next()) {
			affectedRow=rs.getInt("count(*)");
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

	@Override
	public List<String> listActiveUsers() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List <String> list=new ArrayList<String>();
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select uid from topic");
			rs=st.executeQuery();
			while(rs.next()) {
				String uid=rs.getString("uid");
				list.add(uid);
			}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.closeAll(rs, st, conn);
	}	
	return list;
	}

	@Override
	public boolean findTopicByTid(int tid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean flag=false;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select * from topic where tid=?");
			st.setInt(1, tid);
			rs=st.executeQuery();
			while(rs.next()) {
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}	
		return flag;
	}
	
}
