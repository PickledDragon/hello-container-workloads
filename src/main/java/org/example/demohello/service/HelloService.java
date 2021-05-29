package org.example.demohello.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.InetAddress;

@Service
@Path("/hello")
public class HelloService {
    private static String hostName;
    private static String ipAddress;

    HelloService() {
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
            hostName = "Unknown";
            ipAddress = "0.0.0.0";
        }
    }

    @GET
    @Produces("text/plain")
    public String getHello() {
        return String.format("Hello from %s (%s)", hostName, ipAddress);
    }
}
