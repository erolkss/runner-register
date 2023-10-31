package br.com.ero.runnerregister.service;

import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.repository.RunnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RunnerService {

    final RunnerRepository runnerRepository;

    public RunnerService(RunnerRepository runnerRepository){
        this.runnerRepository = runnerRepository;
    }


    @Transactional
    public Runner save(Runner runner) {
       return runnerRepository.save(runner);
    }

}
