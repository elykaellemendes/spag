-- Por default, o arquivo import.sql quando localizado em src/main/resource é
-- executado após a criação do banco de dados pelo Hibernate
INSERT INTO Profissional (codigo, cpf, especializacao, nome, registroMedico, login, senha) VALUES (1, '11122233344', 'FISIOTERAPIA', 'Jose da Silva', '12345', 'jose', md5('jose'))
