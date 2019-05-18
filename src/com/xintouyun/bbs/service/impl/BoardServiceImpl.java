package com.xintouyun.bbs.service.impl;
import java.util.List;

import com.xintouyun.bbs.dao.impl.BoardDaoImpl;
import com.xintouyun.bbs.entity.Board;
import com.xintouyun.bbs.service.Boardservice;

public class BoardServiceImpl implements Boardservice {
	BoardDaoImpl bdi=new BoardDaoImpl();
	@Override
	public List<Board> showAllBoard() {
		List<Board> list=bdi.listBoard();
		return list;
	}
	@Override
	public boolean addBoard(Board board) {
		return bdi.saveBoard(board)>0;
	}

}
