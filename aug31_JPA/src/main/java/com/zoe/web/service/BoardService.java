package com.zoe.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoe.web.entity.JBoard;
import com.zoe.web.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public List<JBoard> findAll() {
		return boardRepository.findAll();
	}

	public void save(JBoard jBoard) {
		boardRepository.save(jBoard);
	}

	public JBoard findByBno(int bno) {
		return boardRepository.findByBno(bno);
	}
}
