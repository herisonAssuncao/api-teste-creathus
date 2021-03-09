package br.com.herison.testecreathus.repository;

import br.com.herison.testecreathus.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
