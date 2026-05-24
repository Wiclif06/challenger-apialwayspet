# AlwaysPet API - Java Spring Boot

Grupo: AlwaysPet

Participante: Felipe Wiclif Leal da Silva - RM 563901
Outro aluno saiu da FIAP no mês 03.

## Objetivo da disciplina

API REST para controlar responsáveis, pets, vacinas, medicações, alertas e acompanhamentos de saúde. A API foi organizada para demonstrar CRUD, regras de negócio, validações, DTOs, paginação, ordenação, busca com parâmetros, cache, tratamento de erros e documentação Swagger.

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

4. Acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

## Rotas principais

```text
GET    /api/pets
GET    /api/pets/{id}
GET    /api/pets/busca?nome=Luna&especie=CANINO
POST   /api/pets
PUT    /api/pets/{id}
DELETE /api/pets/{id}
GET    /api/alertas/status?status=PENDENTE
POST   /api/alertas
PUT    /api/alertas/{id}/resolver
```

## GITHUB

```text
https://github.com/Wiclif06/challenger-apialwayspet
```