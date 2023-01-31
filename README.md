# API RESTful CLIENT
# Descrição

Projeto segue arquitetura hexagonal, possuí padrão de monitoramento Health Check, utiliza padrão RESTful para a API,
a aplicação possuí integração com o VIACEP, para a busca de dados do endereço baseado no CEP.

A aplicação utiliza PostgreSQL como base de dados.

# Requisitos

- JAVA 17
- MAVEN
- DOCKER


## Instalação

Para Instalação do projeto, siga os seguintes passos.


```bash
  cd cliente

  mvn clean install

  docker build -t rompi-client-api-docker.jar .

  cd docker

  docker-compose up -d
```
    
## Documentação da API


| URL   | Metodo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `http://localhost:8080/rompi-api/swagger-ui/index.html#/` | `GET` | URL para Documentação da API |
| `http://localhost:8080/rompi-api/actuator/health`      | `GET` | URL para monitoramento do status da API |

