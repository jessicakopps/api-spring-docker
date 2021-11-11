package br.mso.apispringdocker.model;

import javax.persistence.*;

@Entity
@Table(name = "pessoa") // Vc pode configurar pro intelliJ validar com base vc já tem no banco
public class Pessoa {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pessoa")
  private Long id;
  
  @Column(name = "nome")
  private String nome;
  
  @Column(name = "sobrenome")
  private String sobrenome;
  
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
