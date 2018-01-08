package com.thoughtworks.leanvaluetree;

import com.thoughtworks.leanvaluetree.main.db.DumbRepo;
import com.thoughtworks.leanvaluetree.main.db.Repository;
import com.thoughtworks.leanvaluetree.api.resources.TreeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApplication extends Application<MainConfiguration> {

    private Repository repository;

    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void run(MainConfiguration configuration, Environment environment) {
        repository = new DumbRepo();
//        repository = new PostgresRepo(configuration.getPostgresConnection());
        environment.jersey().register(new TreeResource(repository));
    }
}
