package pl.kelog.eurekademo.worker;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Profile("worker")
@RestController
public class WorkerController {
    
    private final Logger log = Logger.getLogger(WorkerController.class.getName());
    
    @GetMapping("/sleep/{millis}")
    @ResponseBody
    public ResponseEntity<String> isPrime(@PathVariable("millis") long millis) {
        doSleep(millis);
        
        return new ResponseEntity<>("Slept " + millis + " ms.", HttpStatus.OK);
    }
    
    private void doSleep(@PathVariable("millis") long millis) {
        log.info("Sleeping " + millis + " ms...");
        
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        log.info("Sleeping " + millis + " done.");
    }
}
