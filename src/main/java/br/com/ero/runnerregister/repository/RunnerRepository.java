package br.com.ero.runnerregister.repository;

import br.com.ero.runnerregister.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RunnerRepository extends JpaRepository<Runner, UUID> {
}
