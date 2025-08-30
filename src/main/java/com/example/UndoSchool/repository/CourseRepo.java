package com.example.UndoSchool.repository;

import com.example.UndoSchool.document.CourseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends ElasticsearchRepository<CourseDocument, String> {

}
