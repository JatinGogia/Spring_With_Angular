package com.projects.project1.dtos.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentQuery {
    private String name;
    private String rollNumber;
}
