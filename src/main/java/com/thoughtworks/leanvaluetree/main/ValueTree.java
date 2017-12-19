package com.thoughtworks.leanvaluetree.main;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ValueTree {
    private String visionStatement;

    private List<Node> nodes;

    public ValueTree() {
        nodes = new ArrayList<>();
    }

    @JsonProperty
    public String getVisionStatement() {
        return visionStatement;
    }

    public void setVisionStatement(String visionStatement) {
        this.visionStatement = visionStatement;
    }

    @JsonProperty
    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node newNode) {
        nodes.add(newNode);
    }
}
