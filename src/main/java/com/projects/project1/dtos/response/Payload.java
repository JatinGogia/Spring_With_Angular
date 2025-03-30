package com.projects.project1.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payload {
     String name;
     int age;
}
