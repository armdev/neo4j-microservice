package com.project.application;

import com.project.dao.UserDAO;
import com.project.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.neo4j.graphdb.GraphDatabaseService;

public class ServerApplication extends Application<ServerConfiguration> {
    //java -jar target/neo4j-micro.jar server src/main/resources/config.yml

    public static void main(String[] args) throws Exception {
        new ServerApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {

        bootstrap.addBundle(new SwaggerBundle<ServerConfiguration>() {
            @Override
            public SwaggerBundleConfiguration getSwaggerBundleConfiguration(ServerConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) throws Exception {
        final GraphDatabaseService graphDb = configuration.getDatabaseService();
        
        final UserDAO userDAO = new UserDAO(graphDb);

        final UserResource msgs = new UserResource(userDAO);
        environment.jersey().register(msgs);
    }
}
