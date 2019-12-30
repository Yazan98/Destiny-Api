package com.yazan98.destiny.server;

import com.yazan98.destiny.server.data.repository.ProfileRepository;
import io.vortex.spring.boot.base.config.VortexApplicationStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ProfileRepository.class)
public class DestinyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DestinyApplication.class);
        Environment env = app.run(args).getEnvironment();

        VortexApplicationStarter starter = new VortexApplicationStarter(env);
        starter.build(false);
    }

}
