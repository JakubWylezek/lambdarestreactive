package com.example.resource;

import io.quarkus.amazon.lambda.http.model.AwsProxyRequest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import software.amazon.awssdk.services.s3.S3Client;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/s3")
public class S3Resource {

    private final Logger log = Logger.getLogger(S3Resource.class);

    @ConfigProperty(name = "bucket.name.suffix")
    String bucketNameSuffix;

    @Inject
    S3Client s3;

    @GET
    @Path("/hello2")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        log.info("hello from S3Resource");
        return "HELLO!";
    }

    @GET
    @Path("/hello3")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello2(@Context AwsProxyRequest awsProxyRequest) {
        log.info("hello from S3Resource");
        log.info("REQ CONTEXT : " + awsProxyRequest.getRequestContext());
        return "HELLO2!";
    }
}
