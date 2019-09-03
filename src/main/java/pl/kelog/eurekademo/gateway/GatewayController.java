package pl.kelog.eurekademo.gateway;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Profile("gateway")
public class GatewayController {
    
    private final RestTemplate restTemplate;
    
    public GatewayController(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @GetMapping("/sleep/{millis}")
    public ResponseEntity<String> sleep(@PathVariable("millis") long millis) {
        ResponseEntity<String> response = restTemplate.getForEntity("http://WORKER/sleep/" + millis, String.class);
        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
