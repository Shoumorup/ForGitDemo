package com.visa.training.bookproject.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.bookproject.domain.Chapter;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter,Integer>{
	

}
