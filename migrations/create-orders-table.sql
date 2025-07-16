CREATE TABLE IF NOT EXISTS tb_orders (
	id BINARY(16) default (UUID_TO_BIN(UUID())),
	status VARCHAR(100),
	user_id BINARY(16) NOT NULL,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP NOT NULL,
	total_amount DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (id)
);