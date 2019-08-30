package pl.kelog.eurekademo.worker;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kelog.eurekademo.shared.IsPrimeResponse;

import java.util.logging.Logger;
import java.util.stream.IntStream;

@Profile("worker")
@RestController
public class WorkerController {
    
    private final Logger log = Logger.getLogger(WorkerController.class.getName());
    
    @GetMapping("/isPrime/{number}")
    @ResponseBody
    public ResponseEntity<IsPrimeResponse> isPrime(@PathVariable("number") int number) {
        boolean isPrime = number > 1 && IntStream.range(2, number).noneMatch(i -> number % i == 0);
        log.info("isPrime(" + number + ") = " + isPrime);
        
        return new ResponseEntity<>(new IsPrimeResponse(isPrime), HttpStatus.OK);
    }
    
}
