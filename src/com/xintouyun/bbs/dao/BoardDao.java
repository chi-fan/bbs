package com.xintouyun.bbs.dao;

import java.util.List;

import com.xintouyun.bbs.entity.Board;

public interface BoardDao {
	/**
	 * �г����а��
	 * @return ���󼯺�
	 */
	List <Board> listBoard();
	/**
	 * ����һ��������
	 * @param board
	 * @return ������Ӱ������
	 */
	int saveBoard(Board board);
}
