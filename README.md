# SistemaBiblioteca

![CI](https://github.com/Menezesvm/SistemaBiblioteca/actions/workflows/ci.yml/badge.svg)

Sistema de gerenciamento de biblioteca desenvolvido em Java com Spring Boot.

> 🚧 **Em desenvolvimento.** As funcionalidades serão listadas aqui conforme forem implementadas.

## Tecnologias

- Java 25
- Spring Boot 4 (Spring Web MVC e Spring Data JPA)
- MySQL
- Maven
- GitHub Actions (CI/CD)
- Docker

## Pré-requisitos

- JDK 25
- MySQL em execução, com um banco criado para a aplicação
- Git

O Maven não precisa estar instalado: o projeto inclui o Maven Wrapper (`mvnw`).

## Configuração

A aplicação lê os dados de conexão com o banco por variáveis de ambiente. Nenhuma senha fica no repositório.

| Variável      | Descrição                          |
|---------------|------------------------------------|
| `DB_URL`      | URL JDBC do MySQL                  |
| `DB_USER`     | Usuário do banco                   |
| `DB_PASSWORD` | Senha do banco (obrigatória)       |

Exemplo de `DB_URL`:

```
jdbc:mysql://localhost:3306/biblioteca
```

## Como executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/Menezesvm/SistemaBiblioteca.git
   cd SistemaBiblioteca
   ```

2. Defina as variáveis de ambiente.

   Linux/macOS:

   ```bash
   export DB_PASSWORD=sua_senha
   ```

   Windows (PowerShell):

   ```powershell
   $env:DB_PASSWORD = "sua_senha"
   ```

3. Inicie a aplicação:

   ```bash
   ./mvnw spring-boot:run
   ```

   No Windows, use `mvnw.cmd spring-boot:run`.

A aplicação fica disponível em `http://localhost:8080`.

## Testes

```bash
./mvnw verify
```

Os testes precisam de um MySQL acessível, configurado pelas mesmas variáveis de ambiente.

## CI/CD

O workflow em [`.github/workflows/ci.yml`](.github/workflows/ci.yml) roda a cada push e pull request na `main`:

1. **Build e testes:** sobe um MySQL temporário, compila o projeto e executa os testes.
2. **Docker:** em push na `main`, depois que o build passa, publica a imagem no GitHub Container Registry.

## Docker

```bash
docker run -p 8080:8080 \
  -e DB_URL=jdbc:mysql://host.docker.internal:3306/biblioteca \
  -e DB_USER=root \
  -e DB_PASSWORD=sua_senha \
  ghcr.io/menezesvm/sistema-biblioteca:latest
```

O contêiner não inclui banco de dados. Ele precisa alcançar um MySQL, que no exemplo acima roda na própria máquina.

## Autor

**Vinicius Menezes**
[LinkedIn](https://linkedin.com/in/viniciusmenezes2)
