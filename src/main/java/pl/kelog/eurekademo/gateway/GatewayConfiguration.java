package pl.kelog.eurekademo.gateway;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("gateway")
@EnableEurekaClient
public class GatewayConfiguration {
}
