package com.md.readinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.md.readinglist.model.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}