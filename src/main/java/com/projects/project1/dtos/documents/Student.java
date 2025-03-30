package com.projects.project1.dtos.documents;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Document
@Data
@Builder
public class Student {

    @Id
    private String userId;
    
    private String name;
    
    private String rollNumber;

    private Integer age;

}
