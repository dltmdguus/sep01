package com.zoe.web.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.zoe.web.entity.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jBoard);

	List<JBoard> findAll();

	JBoard findByBno(int bno);

}
