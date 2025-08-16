package com.projects.project1.codeFlowImageGenerationCode;

import java.util.UUID;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FlowTracingAspect {
    private static final ThreadLocal<CallNode> currentCall = new ThreadLocal<>();

    @Around("@annotation(TraceFlow)")
    public Object traceMethodFlow(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String nodeId = UUID.randomUUID().toString(); // Unique ID for draw.io

        CallNode node = new CallNode(nodeId, className, methodName);
        CallNode parent = currentCall.get();
        if (parent != null) {
            parent.addChild(node);
        }
        currentCall.set(node);

        try {
            return joinPoint.proceed();
        } finally {
            currentCall.set(parent);
            if (parent == null) {
                FlowVisualizer.generateDrawIOXml(node); // Generate draw.io XML
            }
        }
    }
}