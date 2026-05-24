# AlwaysPet API - Java Spring Boot

Grupo: AlwaysPet

Participante: Felipe Wiclif Leal da Silva - RM 563901
Outro aluno saiu da FIAP no mês 03.

## Objetivo da disciplina

API REST para controlar responsáveis, pets, vacinas, medicações, alertas e acompanhamentos de saúde. A API foi organizada para demonstrar CRUD, regras de negócio, validações, DTOs, paginação, ordenação, busca com parâmetros, cache, tratamento de erros e documentação Swagger.

## Requisitos atendidos

- Entidades relacionadas com JPA.
- Camadas separadas: controller, service, repository, dto, exception e config.
- CRUD completo.
- Busca parametrizada por nome, espécie e status.
- Paginação e ordenação.
- Bean Validation.
- DTOs de entrada e saída.
- Tratamento de erros padronizado.
- Cache em consultas frequentes.
- Swagger disponível em `/swagger-ui/index.html`.
- H2 para execução rápida e perfil preparado para Oracle.
- Collection do Postman na pasta `docs`.

## Como executar

1. Instale Java 17 ou superior.
2. Entre na pasta da API.
3. Execute:

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

## Testes para demonstrar no vídeo

1. Abrir Swagger.
2. Criar responsável.
3. Criar pet vinculado ao responsável.
4. Criar alerta de vacina.
5. Consultar lista paginada.
6. Buscar pet por parâmetro.
7. Atualizar pet.
8. Resolver alerta.
9. Excluir registro criado para teste.

## Checklist para buscar nota máxima

- Subir no GitHub público.
- Manter commits em sequência lógica.
- Rodar a aplicação antes de gravar.
- Exportar collection do Postman ou Insomnia.
- Mostrar Swagger funcionando.
- Mostrar persistência no H2 Console ou Oracle.
- Não entregar apenas CRUD: explique a regra de acompanhamento preventivo do pet.
