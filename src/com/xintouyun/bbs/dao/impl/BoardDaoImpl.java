package com.xintouyun.bbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xintouyun.bbs.dao.BoardDao;
import com.xintouyun.bbs.entity.Board;
import com.xintouyun.bbs.util.JdbcUtil;

public class BoardDaoImpl implements BoardDao{

	@Override
	public List<Board> listBoard() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List <Board> list=new ArrayList<Board>();
		Board board=null;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select * from board");
			rs=st.executeQuery();
			while(rs.next()) {
				board=new Board();
				board.setBid(rs.getInt("bid"));
				board.setBname(rs.getString("bname"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}	
		return list;
	}

	@Override
	public int saveBoard(Board board) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int affectedRow = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("insert into board(bname) values(?)");
			st.setString(1, board.getBname());
			affectedRow=st.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, st, conn);
		}
		return affectedRow;
	}

}
