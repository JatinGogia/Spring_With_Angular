package com.projects.project1.codeFlowImageGenerationCode;

import java.io.FileWriter;
import java.util.UUID;

public class FlowVisualizer {
    private static final int NODE_WIDTH = 160;
    private static final int NODE_HEIGHT = 60;
    private static final int HORIZONTAL_SPACING = 250;
    private static final int VERTICAL_SPACING = 150;

    public static void generateDrawIOXml(CallNode root) {
        try (FileWriter writer = new FileWriter("call-hierarchy.drawio.xml")) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<mxfile host=\"app.diagrams.net\">\n");
            writer.write("  <diagram name=\"Method Flow\" id=\"diagram_1\">\n");
            writer.write("    <mxGraphModel dx=\"1200\" dy=\"800\" grid=\"1\" gridSize=\"10\">\n");
            writer.write("      <root>\n");
            writer.write("        <mxCell id=\"0\" />\n");
            writer.write("        <mxCell id=\"1\" parent=\"0\" />\n");

            // Start traversal from the root node at (100, 100)
            traverseAndWriteNodes(root, writer, 100, 100);

            writer.write("      </root>\n");
            writer.write("    </mxGraphModel>\n");
            writer.write("  </diagram>\n");
            writer.write("</mxfile>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void traverseAndWriteNodes(CallNode node, FileWriter writer, int x, int y) throws Exception {
        // Write the current node
        writer.write(String.format(
            "        <mxCell id=\"%s\" value=\"%s.%s\" style=\"rounded=1;whiteSpace=wrap;html=1;fillColor=#fff2cc;strokeColor=#d6b656;\" " +
            "vertex=\"1\" parent=\"1\">\n" +
            "          <mxGeometry x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" as=\"geometry\" />\n" +
            "        </mxCell>\n",
            node.getId(), node.getClassName(), node.getMethodName(), 
            x, y, NODE_WIDTH, NODE_HEIGHT
        ));

        // Position children vertically below and spaced horizontally
        int childX = x;
        int childY = y + VERTICAL_SPACING;

        for (CallNode child : node.getChildren()) {
            // Write edge from parent to child
            String edgeId = UUID.randomUUID().toString();
            writer.write(String.format(
                "        <mxCell id=\"%s\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;html=1;jettySize=auto;orthogonalLoop=1;\" " +
                "edge=\"1\" parent=\"1\" source=\"%s\" target=\"%s\">\n" +
                "          <mxGeometry relative=\"1\" as=\"geometry\" />\n" +
                "        </mxCell>\n",
                edgeId, node.getId(), child.getId()
            ));

            // Recursively write child node and its children
            traverseAndWriteNodes(child, writer, childX, childY);
            
            // Move next child horizontally
            childX += HORIZONTAL_SPACING;
        }
    }
}