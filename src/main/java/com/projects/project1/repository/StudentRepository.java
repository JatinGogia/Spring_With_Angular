package com.projects.project1.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.projects.project1.dtos.documents.Student;

import io.micrometer.core.annotation.Timed;

import java.util.List;


public interface StudentRepository extends MongoRepository<Student,String>{

    @Timed(value = "findByName.execution.time", description = "Time taken by findByName method")
    List<Student> findByName(String name);

    @Timed(value = "findByRollNumber.execution.time", description = "Time taken by findByRollNumber method")
    List<Student> findByRollNumber(String rollNumber);

}
