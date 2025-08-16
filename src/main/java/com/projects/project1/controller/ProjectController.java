package com.projects.project1.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.projects.project1.codeFlowImageGenerationCode.TraceFlow;
import com.projects.project1.dtos.documents.Student;
import com.projects.project1.dtos.query.StudentQuery;
import com.projects.project1.dtos.sqldb.dto.performanceDTO;
import com.projects.project1.handler.PerformanceDTOSerializer;
import com.projects.project1.repository.StudentRepository;
import com.projects.project1.service.PerformanceService;

import io.micrometer.common.util.StringUtils; 

@Controller
public class ProjectController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PerformanceService performanceService;
    
     
    @PostMapping(value = "/fetchInformation",produces = "application/json")
    public ResponseEntity<List<Student>> fetchInformation(@RequestBody StudentQuery studentQuery) 
    {  
     List<Student> students = new ArrayList<>();
    
     if(!StringUtils.isEmpty(studentQuery.getName()))
       students= studentRepository.findByName(studentQuery.getName());
   
     else if (!StringUtils.isEmpty(studentQuery.getRollNumber()))
        students= studentRepository.findByRollNumber(studentQuery.getRollNumber());
     
     return ResponseEntity.ok().body(students); 
          
    } 


    @PostMapping(value = "/addStudent",produces = "application/json")
    public ResponseEntity addStudent(@RequestBody Student student) 
    {    studentRepository.save(student);
         return ResponseEntity.ok().build(); 
    } 


    @GetMapping(value = "/findAllStudents",produces = "application/json")
    public ResponseEntity<List<Student>> findAll() 
    {    List<Student> students= studentRepository.findAll();
         return ResponseEntity.ok().body(students); 
    } 


    @GetMapping(value = "/insertBulkData",produces = "application/json")
    public ResponseEntity insertDataIntoSqlDb() 
    {    
          //Uncomment the method to bulk insert the data
         //performanceService.insertBulkData();
         return ResponseEntity.ok().build(); 
    } 



    @GetMapping(value = "/fetchData",produces = "application/json")
    @ResponseBody
    @JsonSerialize(using = PerformanceDTOSerializer.class)
    @TraceFlow
    public List<performanceDTO> fetchDataFromDb() 
    {    
       return performanceService.fetchDataFromDb1(); 
    } 



}
