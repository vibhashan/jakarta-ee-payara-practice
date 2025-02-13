package org.vibhashana.jakarta.hello.controller;

import java.util.Collections;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/response")
public class ResponseResource {
	@GET
	@Path("/{value}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response testValue(@PathParam("value") Integer value) {
		if (value % 2 == 0) {
			return Response.ok("Value is even").build();
		} else {
			return Response.notAcceptable(Collections.emptyList()).build();
		}
	}
}
