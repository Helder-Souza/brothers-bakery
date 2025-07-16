CREATE TABLE IF NOT EXISTS tb_order_items (
	id BINARY(16) default (UUID_TO_BIN(UUID())),
	order_id BINARY(16) NOT NULL,
	product_name VARCHAR(100) NOT NULL,
	quantity INTEGER NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (id)
);