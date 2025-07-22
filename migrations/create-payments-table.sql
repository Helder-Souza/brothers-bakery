CREATE TABLE IF NOT EXISTS tb_payments (
    payment_id BINARY(16) default (UUID_TO_BIN(UUID())),
    order_id BINARY(16) NOT NULL,
    payment_method VARCHAR(50),
    payment_status VARCHAR(50),
    paid_amount DECIMAL(10,2),
    payment_date TIMESTAMP,
    PRIMARY KEY (payment_id)
);