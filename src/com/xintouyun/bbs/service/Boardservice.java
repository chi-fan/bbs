package com.xintouyun.bbs.service;

import java.util.List;

import com.xintouyun.bbs.entity.Board;

public interface Boardservice {
	/**
	 * 查询版块
	 * @return 返回版块对象集合
	 */
	List<Board> showAllBoard();
	/**
	 * 添加版块
	 * @param board
	 * @return 添加成功返回true，添加失败返回false
	 */
	boolean addBoard(Board board);  
}
