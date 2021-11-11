package br.mso.apispringdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// Configurar dois atributos, pra escanear todo o meu projeto, pra que se eu mudar algo, ele já perceber
@SpringBootApplication(scanBasePackages = "br.mso.apispringdocker") // É pra escanear todos os meus pacotes
@EntityScan(basePackages = "br.mso.apispringdocker.model") // Configurar o JPA, escaneia todo o pacote onde fica minhas entidades
public class ApiSpringDockerApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(ApiSpringDockerApplication.class, args);
  }
  
}
