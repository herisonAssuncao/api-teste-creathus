# Api RESTful Spring Boot

Api de crud de contatos.

## Tecnologias utilizadas 

- Spring Boot
- Postgres
- Docker

## Instruções para Build

### Opção 1

- Clone o repositório
- Inicie o servidor utilizando as IDES: IntelliJ ou Eclipse 
- Caso queira alterar as configurações do banco acesse o arquivo ``application.properties``

### Opção 2 via Docker|Linux

- Clone o repositório e verifique se sua máquina possue as tecnologias Docker e Docker Compose
- Empacote o aplicativo com o comando: ``./mvnw clean package -DskipTests=true`` dentro do diretório do projeto
- Extraia as bibliotecas: ``mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)``
- Excute: sudo docker-compose build && sudo docker-compose up para buildar e subir os containers
- Acesse a aplicação http://localhost:9000


## Deploy 

Aplicação foi hospedada em uma máquina virtualizada com UBUNTU da AWS EC2.
Foi utilizando um ambiente docker para integração e funcionamento da aplicação.
Tanto o Frontend como o App já estão utilizando a api dessa aplicação da AWS.

