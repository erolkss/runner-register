package br.com.ero.runnerregister.controller;

import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.service.RunnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

@RestController
@RequestMapping("crazy-race")
public class RunnerController
{
    final RunnerService runnerService;

    public RunnerController(RunnerService runnerService){
        this.runnerService = runnerService;
    }

    @PostMapping
    public ResponseEntity<Runner> saveRunner(@RequestBody Runner runner){
            return ResponseEntity.status(HttpStatus.CREATED).body(runnerService.save(runner));
        }
    }
