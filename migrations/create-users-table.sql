CREATE TABLE IF NOT EXISTS tb_users (
	user_id BINARY(16) default (UUID_TO_BIN(UUID())),
	name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	password VARCHAR(60) NOT NULL,
	address VARCHAR(100) NOT NULL,
	active TINYINT(1) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP NOT NULL,
	UNIQUE (email, cpf)
	PRIMARY KEY (user_id)
);