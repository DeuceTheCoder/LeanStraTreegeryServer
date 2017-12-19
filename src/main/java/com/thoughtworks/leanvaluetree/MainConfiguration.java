package com.thoughtworks.leanvaluetree;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class MainConfiguration extends Configuration {
    @NotEmpty
    private String postgresConnection;

    @JsonProperty
    public String getPostgresConnection() {
        return postgresConnection;
    }

    @JsonProperty
    public void setPostgresConnection(String postgresConnection) {
        this.postgresConnection = postgresConnection;
    }
}
