package com.ssafy.homework.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homework.model.dto.Book;
import com.ssafy.homework.model.repository.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;
	
	@Override
	public int insert(Book book) throws SQLException {
		return mapper.insert(book);
	}

	@Override
	public List<Book> select() throws SQLException {
		return mapper.select();
	}

	@Override
	public Book getDetail(String isbn) throws SQLException {
		return mapper.getDetail(isbn);
	}

	@Override
	public void delete(String isbn) throws SQLException {
		mapper.delete(isbn);
	}

	@Override
	public void deleteAll() throws SQLException {
		mapper.deleteAll();
	}

	@Override
	public void update(Book book) throws SQLException {
		mapper.update(book);
	}

}
