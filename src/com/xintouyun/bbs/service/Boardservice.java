package com.xintouyun.bbs.service;

import java.util.List;

import com.xintouyun.bbs.entity.Board;

public interface Boardservice {
	/**
	 * ��ѯ���
	 * @return ���ذ����󼯺�
	 */
	List<Board> showAllBoard();
	/**
	 * ��Ӱ��
	 * @param board
	 * @return ��ӳɹ�����true�����ʧ�ܷ���false
	 */
	boolean addBoard(Board board);  
}
