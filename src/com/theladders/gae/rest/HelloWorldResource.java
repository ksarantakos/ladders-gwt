package com.theladders.gae.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {

  @Get
  public String represemt() {
    return "hello world, from GAE";
  }
}
