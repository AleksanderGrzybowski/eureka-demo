package pl.kelog.eurekademo.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kelog.eurekademo.shared.IsPrimeResponse;

@RestController
@Profile("gateway")
public class GatewayController {
    
    private final RestTemplate restTemplate;
    
    @Autowired
    DiscoveryClient discoveryClient;
    public GatewayController(@LoadBalanced  RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @GetMapping("/isPrime/{number}")
    public ResponseEntity<IsPrimeResponse> isPrime(@PathVariable("number") int number) {
        ResponseEntity<IsPrimeResponse> response = restTemplate.getForEntity("http://WORKER/isPrime/" + number, IsPrimeResponse.class);
        System.out.println(response);
        
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
    
}
