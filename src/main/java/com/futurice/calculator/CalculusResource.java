/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futurice.calculator;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author oghomwen.aigbedion
 */
@Path("calculus")
public class CalculusResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculusResource
     */
    public CalculusResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.futurice.calculator.CalculusResource
     *
     * @param expression
     * @return an instance of com.futurice.calculator.Response
     * @throws java.io.UnsupportedEncodingException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("query") String expression) throws UnsupportedEncodingException {
        //TODO return proper representation object
        String decodedExpression = new String(Base64.getDecoder().decode(expression.getBytes()), "UTF-8");
        System.out.println(decodedExpression);
        return Evaluator.evaluate(decodedExpression);
    }

    /**
     * PUT method for updating or creating an instance of CalculusResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
