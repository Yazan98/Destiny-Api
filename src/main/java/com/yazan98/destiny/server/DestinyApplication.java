package com.yazan98.destiny.server;

import io.vortex.spring.boot.base.config.VortexApplicationStarter;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EntityScan("com.yazan98.destiny.server.data.entity")
public class DestinyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DestinyApplication.class);
        Environment env = app.run(args).getEnvironment();

        VortexApplicationStarter starter = new VortexApplicationStarter(env);
        starter.build(false);
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncryption() {
        return new BCryptPasswordEncoder();
    }

}
