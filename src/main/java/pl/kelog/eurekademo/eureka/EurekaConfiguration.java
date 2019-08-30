package pl.kelog.eurekademo.eureka;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableEurekaServer
@Profile("eureka")
public class EurekaConfiguration {
}
