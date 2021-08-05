package com.yfj.bookstore.payment.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentResource {



//    @GET
//    @Path("/hystrixTest")
//    public String hystrixTest(){
//        return "yes!!";
//    }

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String test(@PathVariable String id) throws Exception{
        int x = Integer.parseInt(id);
        if(x < 0){
            throw new Exception("illegal");
        }
        return "yes!";
    }

    public String paymentInfo_TimeOutHandler(String id){
        return "fail!!";
    }
}
