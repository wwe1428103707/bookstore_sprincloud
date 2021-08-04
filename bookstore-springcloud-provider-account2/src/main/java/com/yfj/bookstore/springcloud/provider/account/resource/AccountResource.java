package com.yfj.bookstore.springcloud.provider.account.resource;

import com.bookstore.domain.account.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
@Component
@CacheConfig(cacheNames = "resource.account.cache")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Value("${server.port}")
    private String serverPort;

    @GET
    @Path("/{username}")
    @Cacheable(key = "#username")
    @PreAuthorize("#oauth2.hasAnyScope('SERVICE','BROWSER')")
    public Account getUser(@PathParam("username") String username){
        return null;
    }
}
