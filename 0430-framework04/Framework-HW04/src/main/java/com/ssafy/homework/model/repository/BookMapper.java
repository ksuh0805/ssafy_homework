package com.ssafy.homework.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.homework.model.dto.Book;

public interface BookMapper {
	
	/**
	 * Book 정보를 DB에 저장
	 * @param book 저장할 Book 정보
	 * @return 저장된 책 개수
	 * @throws SQLException
	 */
	int insert(Book book) throws SQLException;
	
	/**
	 * 전체 Book 정보 List 반환
	 * @return Book List
	 * @throws SQLException
	 */
	List<Book> select() throws SQLException;

	Book getDetail(String isbn) throws SQLException;

	void delete(String isbn) throws SQLException;

	void deleteAll() throws SQLException;

	void update(Book book) throws SQLException;
}
