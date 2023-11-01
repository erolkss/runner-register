package br.com.ero.runnerregister.controller;

import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.service.RunnerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Object> runnersGetById(@PathVariable(value = "id") UUID tb_runnerId) {
        Optional<Runner> runnerOptional = Optional.ofNullable(runnerService.findById(tb_runnerId));
            return ResponseEntity.status(HttpStatus.OK).body(runnerOptional.get());
    }
    @GetMapping("runners")
    public ResponseEntity<List<Runner>> runnersGetAll() {
        List<Runner> runners = runnerService.getAll();
        return ResponseEntity.ok(runners);
    }
}




