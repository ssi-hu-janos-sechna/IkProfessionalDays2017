package com.surveysampling;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableMicroservicesDashboardServer
public class MicroserviceDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDashboardApplication.class, args);
    }
}
