package com.xintouyun.bbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xintouyun.bbs.dao.ReplyDao;
import com.xintouyun.bbs.entity.Reply;
import com.xintouyun.bbs.util.JdbcUtil;

public class ReplyDaoImpl implements ReplyDao {

	@Override
	public int saveReply(Reply reply) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("insert into reply(title,context,ptime,uid,tid) values(?,?,now(),?,?) ");
			st.setString(1, reply.getTitle());
			st.setString(2, reply.getContext());
			st.setInt(3, reply.getUid());
			st.setInt(4, reply.getTid());
			affectedRow=st.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

	@Override
	public List<Reply> queryReplyByTid(int tid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List <Reply> list=new ArrayList<Reply>();
		Reply reply=null;
		try {
			conn = JdbcUtil.getConnection();
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}	
		return list;
	}

	@Override
	public int deleteByTid(int tid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("delete from reply where tid=?");
			st.setInt(1, tid);	
			affectedRow=st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

}
