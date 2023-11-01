package br.com.ero.runnerregister.controller;

import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.service.RunnerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.transform.OutputKeys;
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
    public ResponseEntity<Runner> runnerGetById(@PathVariable(value = "id") UUID tb_runnerId){
        Runner runner = runnerService.findById(tb_runnerId);
        return ResponseEntity.status(HttpStatus.OK).body(runner);
    }
    @GetMapping("runners")
    public ResponseEntity<List<Runner>> runnersGetAll() {
        List<Runner> runners = runnerService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(runners);
    }

    @DeleteMapping("runners/{id}")
    public ResponseEntity<Runner> runnerDelete(@PathVariable(value = "id") UUID tb_runnerId){
        Runner runner = runnerService.delete(tb_runnerId);
        return ResponseEntity.status(HttpStatus.OK).body(runner);
    }

    @PatchMapping("runners/{id}")
    public ResponseEntity<Runner>  updateRunnerName(@PathVariable("id") UUID tb_runnerId, @RequestBody Runner runner){
        Runner run = runnerService.updateRunnerNameS(tb_runnerId, runner.getTb_runner_name());
        return ResponseEntity.status(HttpStatus.OK).body(run);
    }



}




