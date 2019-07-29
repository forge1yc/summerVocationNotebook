package com.test.ssm.dao;

import java.util.List;

import com.test.ssm.domain.po.Book;

public interface BookDao {
	Book findById(Integer id);
	List<Book> findAll();
}
