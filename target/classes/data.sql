INSERT INTO tb_responsavel (id, nome, email, telefone) VALUES (1, 'Mariana Alves', 'mariana@email.com', '11911112222');
INSERT INTO tb_responsavel (id, nome, email, telefone) VALUES (2, 'Rafael Costa', 'rafael@email.com', '11933334444');
INSERT INTO tb_pet (id, nome, especie, raca, data_nascimento, responsavel_id) VALUES (1, 'Luna', 'CANINO', 'Golden Retriever', '2021-03-12', 1);
INSERT INTO tb_pet (id, nome, especie, raca, data_nascimento, responsavel_id) VALUES (2, 'Mingau', 'FELINO', 'SRD', '2020-08-02', 2);
INSERT INTO tb_alerta (id, titulo, descricao, data_prevista, status, pet_id) VALUES (1, 'Vacina anual', 'Reforço de vacina polivalente', '2026-06-15', 'PENDENTE', 1);
INSERT INTO tb_alerta (id, titulo, descricao, data_prevista, status, pet_id) VALUES (2, 'Retorno clínico', 'Revisão após tratamento dermatológico', '2026-06-20', 'PENDENTE', 2);
