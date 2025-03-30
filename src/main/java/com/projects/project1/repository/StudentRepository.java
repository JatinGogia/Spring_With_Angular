package com.projects.project1.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projects.project1.customAnnotation.LogExecutionTime;
import com.projects.project1.dtos.documents.Student;
import java.util.List;


public interface StudentRepository extends MongoRepository<Student,String>{

    @LogExecutionTime
    List<Student> findByName(String name);

    @LogExecutionTime
    List<Student> findByRollNumber(String rollNumber);

}
