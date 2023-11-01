package br.com.ero.runnerregister.service;

import br.com.ero.runnerregister.exception.EntityNotFoundException;
import br.com.ero.runnerregister.model.Runner;
import br.com.ero.runnerregister.repository.RunnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return  runnerRepository.findById(id).orElseThrow(() ->new EntityNotFoundException(String.format("Runner Not Found", id)));
    }
}
