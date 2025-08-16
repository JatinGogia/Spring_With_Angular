package com.projects.project1.codeFlowImageGenerationCode;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@XmlRootElement // Marks this class as an XML root element
@XmlAccessorType(XmlAccessType.FIELD) // Use FIELD-based XML mapping
public class CallNode {
    private String id; // Unique ID for draw.io
    private String className;
    private String methodName;
    private List<CallNode> children = new ArrayList<>();

    public CallNode(String id, String className, String methodName) {
        this.id = id;
        this.className = className;
        this.methodName = methodName;
    }

    public void addChild(CallNode child) { children.add(child); }
}