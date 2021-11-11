package br.mso.apispringdocker.controller.dto;

// Isso aqui é a minha representação da minha entidade. Eu não exponho minha entidade pro mundo externo
// Isso é trabalhar com objetos de única responsabilidade

// Essa classe tem a única responsabilidade de responder para o meu frontend
// ou para quem está acessando o meu serviço

import br.mso.apispringdocker.model.Pessoa;

// Isso aqui só repassa dados dentro de um JSON
public class PessoaResponse {
  
  private Long id;
  private String nome;
  private String sobrenome;
  
  // Não vou usar nenhuma lib como ModelMap pra me ajudar nisso
  // Vou converter na mão, fazendo get de uma classe e setando em outra
  public static PessoaResponse converter(Pessoa p) {
    var pessoa = new PessoaResponse();
    pessoa.setId(p.getId());
    pessoa.setNome(p.getNome());
    pessoa.setSobrenome(p.getSobrenome());
    
    return pessoa;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getSobrenome() {
    return sobrenome;
  }
  
  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }
}
