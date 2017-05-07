package com.project.application;

import io.dropwizard.lifecycle.Managed;
import org.neo4j.graphdb.GraphDatabaseService;

public class Neo4jManager implements Managed {

    private final GraphDatabaseService graphDb;

    public Neo4jManager(GraphDatabaseService graphDb) {
        this.graphDb = graphDb;
    }

    @Override
    public void start() throws Exception {        
        System.out.println("******** Neo4J database already up ***********");
    }

    @Override
    public void stop() throws Exception {
        graphDb.shutdown();
        System.out.println("******** Neo4J database shut down ***********");
    }
}
