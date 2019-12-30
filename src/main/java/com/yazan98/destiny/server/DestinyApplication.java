package com.yazan98.destiny.server;

import io.vortex.spring.boot.base.config.VortexApplicationStarter;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;

@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
@EnableJSONDoc
@EntityScan("com.yazan98.destiny.server.data.entity")
public class DestinyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DestinyApplication.class);
        Environment env = app.run(args).getEnvironment();

        VortexApplicationStarter starter = new VortexApplicationStarter(env);
        starter.build(false);
    }

}
