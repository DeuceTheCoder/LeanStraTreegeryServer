package com.thoughtworks.leanvaluetree.main.db;

import com.thoughtworks.leanvaluetree.main.ValueTree;

public class DumbRepo implements Repository {

    private final ValueTree valueTree;

    public DumbRepo() {
        valueTree = new ValueTree();
    }

    @Override
    public ValueTree getTree() {
        return valueTree;
    }
}
