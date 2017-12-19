package com.thoughtworks.leanvaluetree.resources;

import com.thoughtworks.leanvaluetree.main.Node;
import com.thoughtworks.leanvaluetree.main.ValueTree;
import com.thoughtworks.leanvaluetree.main.db.DumbRepo;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeResourceTest {

    @Test
    public void shouldSetTreeVisionStatement() {
        TreeResource treeResource = new TreeResource(new DumbRepo());

        String requestBody = "{ \"vision\": \"A vision statement\" }";
        ValueTree tree = treeResource.createTree(requestBody);

        assertThat(tree.getVisionStatement(), is("A vision statement"));
    }

    @Test
    public void shouldAddNodeToTree() {
        TreeResource treeResource = new TreeResource(new DumbRepo());

        Node node = new Node();
        node.setId(5L);
        treeResource.addNode(node);

        List<Node> treeNodes = treeResource.getTree().getNodes();
        assertThat(treeNodes.size(), is(1));
        assertThat(treeNodes.get(0), is(node));
    }
}