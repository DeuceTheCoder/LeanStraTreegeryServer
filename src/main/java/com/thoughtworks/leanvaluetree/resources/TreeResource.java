package com.thoughtworks.leanvaluetree.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.leanvaluetree.main.Node;
import com.thoughtworks.leanvaluetree.main.ValueTree;
import com.thoughtworks.leanvaluetree.main.db.DumbRepo;
import com.thoughtworks.leanvaluetree.main.db.Repository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/tree")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TreeResource {
    private Repository repository;

    public TreeResource(Repository repository) {
        this.repository = repository;
    }

    @POST
    @Timed
    public ValueTree createTree(String requestBody) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode requestData = mapper.readTree(requestBody);
            String vision = requestData.get("vision").asText();
            repository.getTree().setVisionStatement(vision);
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

        return repository.getTree();
    }

    @GET
    @Timed
    public ValueTree getTree() {
        return repository.getTree();
    }

    @POST
    @Path("/add")
    public Node addNode(Node newNode) {
        repository.getTree().addNode(newNode);
        return newNode;
    }
}
