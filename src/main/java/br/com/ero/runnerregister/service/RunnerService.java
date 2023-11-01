package br.com.ero.runnerregister.service;

import br.com.ero.runnerregister.exception.EntityNotFoundException;
import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.repository.RunnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RunnerService {

    final RunnerRepository runnerRepository;

    @Transactional
    public Runner save(Runner runner) {
       return runnerRepository.save(runner);
    }

    @Transactional
    public Runner findById(UUID id) {
        return runnerRepository.findById(id).orElseThrow(() ->new RuntimeException(String.format("Runner Not Found", id)));
    }

    @Transactional
    public List<Runner> getAll() {
        return runnerRepository.findAll();
    }

    @Transactional
    public Runner delete(UUID id) {
        runnerRepository.deleteById(id);
        return null;
    }

    public Runner updateRunnerNameS(UUID tbRunnerId, String tbRunnerName) {
        Runner runner = findById(tbRunnerId);
        runner.setTb_runner_name(tbRunnerName);
        return runner;
    }
}

