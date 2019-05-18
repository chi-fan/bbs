package com.xintouyun.bbs.dao;

import java.util.List;

import com.xintouyun.bbs.entity.Board;

public interface BoardDao {
	/**
	 * 列出所有版块
	 * @return 对象集合
	 */
	List <Board> listBoard();
	/**
	 * 保存一个版块对象
	 * @param board
	 * @return 返回受影响行数
	 */
	int saveBoard(Board board);
}
