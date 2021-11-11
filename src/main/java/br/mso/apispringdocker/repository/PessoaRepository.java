package br.mso.apispringdocker.repository;

import br.mso.apispringdocker.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Para um CRUD simples, vc não precisa implementar nada, ele já trás quase todos os métodos

// T é a entidade que vc tá trabalhando, o segundo parâmetro é o tipo

// Ai não precisa fazer mais nada, só utilizar
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
