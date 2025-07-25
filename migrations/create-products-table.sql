CREATE TABLE IF NOT EXISTS tb_products (
	id BINARY(16) default (UUID_TO_BIN(UUID())),
	name VARCHAR(50) NOT NULL,
	sku VARCHAR(255),
	ean VARCHAR(255),
	price DECIMAL(10,2) NOT NULL,
	url_image VARCHAR(255),
	discount INTEGER,
	created_at TIMESTAMP NOT NULL,
	updated_at TIMESTAMP NOT NULL,
	PRIMARY KEY (id)
);