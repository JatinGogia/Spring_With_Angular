package com.projects.project1.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.projects.project1.dtos.sqldb.dto.performanceDTO;
import java.util.List;
import java.io.IOException;

public class PerformanceDTOSerializer extends JsonSerializer<List<performanceDTO>> {

    @Override
    public void serialize(List<performanceDTO> dtos, JsonGenerator gen, SerializerProvider provider) 
            throws IOException {
        
        gen.writeStartObject();
        gen.writeArrayFieldStart("schema");
        gen.writeString("id");   // id
        gen.writeString("c1");  // col1
        gen.writeString("c2");  // col2
        gen.writeString("c3");  // col3
        gen.writeString("c4");  // col4
        gen.writeString("c5");  // col5
        gen.writeString("c6");  // col6
        gen.writeString("c7");  // col7
        gen.writeString("c8");  // col8
        gen.writeString("c9");  // col9
        gen.writeString("c10"); // col10
        gen.writeString("c11"); // col11
        gen.writeString("c12"); // col12
        gen.writeString("c13"); // col13
        gen.writeString("c14"); // col14
        gen.writeString("c15"); // col15
        gen.writeString("c16"); // col16
        gen.writeString("c17"); // col17
        gen.writeString("c18"); // col18
        gen.writeString("c19"); // col19
        gen.writeString("c20"); // col20
        gen.writeString("c21"); // col21
        gen.writeString("c22"); // col22
        gen.writeString("c23"); // col23
        gen.writeString("c24"); // col24
        gen.writeString("c25"); // col25
        gen.writeString("c26"); // col26
        gen.writeString("c27"); // col27
        gen.writeString("c28"); // col28
        gen.writeString("c29"); // col29
        gen.writeString("c30"); // col30
        gen.writeString("c31"); // col31
        gen.writeString("c32"); // col32
        gen.writeString("c33"); // col33
        gen.writeString("c34"); // col34
        gen.writeString("c35"); // col35
        gen.writeString("c36"); // col36
        gen.writeString("c37"); // col37
        gen.writeString("c38"); // col38
        gen.writeString("c39"); // col39
        gen.writeString("c40"); // col40
        gen.writeString("c41"); // col41
        gen.writeString("c42"); // col42
        gen.writeString("c43"); // col43
        gen.writeString("c44"); // col44
        gen.writeString("c45"); // col45
        gen.writeEndArray(); // End schema

        // 2. Write data arrays
        gen.writeArrayFieldStart("data");
        for (performanceDTO dto : dtos) {
            gen.writeStartArray();
            gen.writeString(dto.getId());     // id
            gen.writeString(dto.getCol1());   // col1
            gen.writeString(dto.getCol2());    // col2
            gen.writeString(dto.getCol3());    // col3
            gen.writeString(dto.getCol4());    // col4
            gen.writeString(dto.getCol5());    // col5
            gen.writeString(dto.getCol6());    // col6
            gen.writeString(dto.getCol7());    // col7
            gen.writeString(dto.getCol8());    // col8
            gen.writeString(dto.getCol9());    // col9
            gen.writeString(dto.getCol10());   // col10
            gen.writeString(dto.getCol11());   // col11
            gen.writeString(dto.getCol12());   // col12
            gen.writeString(dto.getCol13());   // col13
            gen.writeString(dto.getCol14());   // col14
            gen.writeString(dto.getCol15());   // col15
            gen.writeString(dto.getCol16());   // col16
            gen.writeString(dto.getCol17());   // col17
            gen.writeString(dto.getCol18());   // col18
            gen.writeString(dto.getCol19());   // col19
            gen.writeString(dto.getCol20());   // col20
            gen.writeString(dto.getCol21());   // col21
            gen.writeString(dto.getCol22());   // col22
            gen.writeString(dto.getCol23());   // col23
            gen.writeString(dto.getCol24());   // col24
            gen.writeString(dto.getCol25());   // col25
            gen.writeString(dto.getCol26());   // col26
            gen.writeString(dto.getCol27());   // col27
            gen.writeString(dto.getCol28());   // col28
            gen.writeString(dto.getCol29());   // col29
            gen.writeString(dto.getCol30());   // col30
            gen.writeString(dto.getCol31());   // col31
            gen.writeString(dto.getCol32());   // col32
            gen.writeString(dto.getCol33());   // col33
            gen.writeString(dto.getCol34());   // col34
            gen.writeString(dto.getCol35());   // col35
            gen.writeString(dto.getCol36());   // col36
            gen.writeString(dto.getCol37());   // col37
            gen.writeString(dto.getCol38());   // col38
            gen.writeString(dto.getCol39());   // col39
            gen.writeString(dto.getCol40());   // col40
            gen.writeString(dto.getCol41());   // col41
            gen.writeString(dto.getCol42());   // col42
            gen.writeString(dto.getCol43());   // col43
            gen.writeString(dto.getCol44());   // col44
            gen.writeString(dto.getCol45());   // col45
            gen.writeEndArray(); // End record
        }
        gen.writeEndArray(); // End data
        
        gen.writeEndObject();
    }
}