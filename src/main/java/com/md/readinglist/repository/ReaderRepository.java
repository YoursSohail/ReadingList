package com.md.readinglist.repository;

import com.md.readinglist.model.Reader;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReaderRepository extends JpaRepository<Reader, String> {

}