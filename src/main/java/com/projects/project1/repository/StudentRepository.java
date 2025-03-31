package com.projects.project1.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.project1.customAnnotation.LogExecutionTime;
import com.projects.project1.dtos.documents.Student;

import io.micrometer.core.annotation.Timed;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String>{
    
    @Timed(value = "com.projects.project1.repository.StudentRepository.findByName", description = "Execution time of findByName")
    @LogExecutionTime
    List<Student> findByName(String name);
    
    @Timed(value = "findByRollNumber", description = "Execution time of findByRollNumber")
    @LogExecutionTime
    List<Student> findByRollNumber(String rollNumber);

}
