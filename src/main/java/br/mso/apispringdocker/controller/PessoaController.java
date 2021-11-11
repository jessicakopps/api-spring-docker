package br.mso.apispringdocker.controller;

import br.mso.apispringdocker.controller.dto.PessoaResponse;
import br.mso.apispringdocker.controller.dto.PessoaRq;
import br.mso.apispringdocker.model.Pessoa;
import br.mso.apispringdocker.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
  
  // Agora precisa ir na JPA buscar essas informações, para fazer acesso à JPA crie um Repository
  
  // Normalmente eu criaria uma camada de serviço, mas aqui é um exemplo tranquilo. Mas o ideal
  // é criar mais uma classe Serviço pra gente não inflingir nenhuma camada dessa arquitetura.
  
  // Agora eu vou injetar o repositório no controller e criar um construtor:
  private final PessoaRepository pessoaRepository;
  
  // No Spring toda classe que tem um construtor e recebe parâmetro no construtor,
  // o próprio spring vai injetar a classe PessoaRepository pra gente,
  // Então vc não precisa anotar @Autowired, que ele já faz automaticamente
  
  // Pra fazer testes (JUnit por exemplo) fica mais fácil o seu controle
  // É boa prática vc facilitar os testes da sua aplicação, vc criar sempre os itens de injeção no construtor
  // Tudo que a classe precisa, recebe no construtor.
  public PessoaController(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/")
  public List<PessoaResponse> findAll(){ // Agora é fazer essa classe de responsabilidade única
    var pessoas = pessoaRepository.findAll();
    
    // Agora vc precisa converter a sua entidade para PessoaResponse
    // Poderia fazer um loop com foreach e converter um por um, mas vou fazer pela API de stream do java:
    return pessoas.stream().map(PessoaResponse::converter).collect(Collectors.toList());
    // Estou mapeando a minha entidade para o objeto PessoaResponse
    // Recupera ele com collectors.tolist()
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public PessoaResponse findById(@PathVariable("id") Long id) {
    var pessoa = pessoaRepository.getById(id);
    
    return PessoaResponse.converter(pessoa);
  }
  
  @RequestMapping(method = RequestMethod.POST, value = "/")
  public void savePerson(@RequestBody PessoaRq pessoaRq) {
    var p = new Pessoa();
    
    p.setNome(pessoaRq.getNome());
    p.setSobrenome(pessoaRq.getSobrenome());
    pessoaRepository.save(p);
  }
  
  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public void updatePerson(@PathVariable("id") Long id, @RequestBody PessoaRq pessoaRq) throws Exception {
    var p = pessoaRepository.findById(id);
  
    if (p.isPresent()) {
      var pessoaSave = p.get();
      pessoaSave.setNome(pessoaRq.getNome());
      pessoaSave.setSobrenome(pessoaRq.getSobrenome());
      pessoaRepository.save(pessoaSave);
    } else {
      throw new Exception("Pessoa Não encontrada");
    }
  }
}
