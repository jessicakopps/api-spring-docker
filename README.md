# Projeto 2 Java <br>

Projeto desenvolvido na aula da professora Marianne Salomão, no curso da Gama Academy em parceria com o Banco Pan. <br>

---
### Tecnologias utilizadas

- Spring Boot (Maven e JDK 11)
- Banco de Dados Relacional MySQL
- Docker

---
### Utilizando a aplicação

- Requisitos:
  - Maven
  - JDK 11
  - MySQL

- Gere o <b>.jar</b> da aplicação executando o comando no terminal:
  ```
  mvn clean install -Dskiptests
  ```
- Caso o código acima não funcione, execute:
  ```
  ./mvnw clean install -DskipTests
  ```

- Para rodar a aplicação, vá até a pasta target do projeto, onde está o arquivo .jar, e rode o comando:
  ```
  java -jar -Dspring.profiles.active=localdebug blue-bank-0.0.1-SNAPSHOT.jar  ```

