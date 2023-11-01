package br.com.ero.runnerregister.controller;

import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.service.RunnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("crazy-race")
public class RunnerController {
    final RunnerService runnerService;

    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @PostMapping
    public ResponseEntity<Runner> saveRunner(@RequestBody Runner runner) {
        return ResponseEntity.status(HttpStatus.CREATED).body(runnerService.save(runner));
    }

    @GetMapping("runners/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID tb_runnerId) {
        Optional<Runner> runnerOptional = Optional.ofNullable(runnerService.findById(tb_runnerId));
            return ResponseEntity.status(HttpStatus.OK).body(runnerOptional.get());
    }
}




