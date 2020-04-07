CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50),
	ativo BIT(1) NOT NULL,
	logradouro VARCHAR(50) DEFAULT NULL,
	numero VARCHAR(50) DEFAULT NULL,
	complemento VARCHAR(50) DEFAULT NULL,
	bairro VARCHAR(50) DEFAULT NULL,
	cep VARCHAR(50) DEFAULT NULL,
	cidade VARCHAR(50) DEFAULT NULL,
	estado VARCHAR(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa(nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values("Shoiti",true,"test","10","test","Novo Osasco","0000-100","Osasco","São Paulo");