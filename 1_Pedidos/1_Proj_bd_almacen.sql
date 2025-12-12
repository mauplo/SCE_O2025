connect 'jdbc:derby://localhost:1527/proj_almacen;user=app;password=app';

DROP TABLE ordered_product;
DROP TABLE customer_order;
DROP TABLE product;
DROP TABLE category;
DROP TABLE customer;
DROP SEQUENCE num_conf;

CREATE SEQUENCE num_conf AS INT START WITH 1 INCREMENT BY 1;

------------------------------- 
--     CUSTOMER
-------------------------------
CREATE TABLE customer 
(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1) 
     CONSTRAINT CUSTOMER_PK PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  phone VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  city_region VARCHAR(2) NOT NULL,
  cc_number VARCHAR(19) NOT NULL
);

INSERT INTO customer (name, email, phone, address, city_region, cc_number) VALUES
('Harry Gomar', 'harry.gomar@estambres.com', '5512345678', 'Av. Tejidos 101', 'CX', '1234567890123456'),
('Mauricia Pena', 'mauricia.pena@estambres.com', '5587654321', 'Calle Agujas 22', 'MX', '6543210987654321'),
('Adrian Janus', 'adrian.janus@estambres.com', '5511223344', 'Blvd. Lana 55', 'NL', '1122334455667788'),
('Axel Castro', 'axel.castro@estambres.com', '5599887766', 'Callejon Hilo 8', 'JA', '9988776655443322');

------------------------------- 
--     CUSTOMER_ORDER
-------------------------------
CREATE TABLE customer_order 
(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1) 
     CONSTRAINT CUSTOMER_ORDER_PK PRIMARY KEY,
  amount DECIMAL(8,2) NOT NULL, -- Aumentado para soportar totales más grandes
  date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  confirmation_number INT NOT NULL,
  customer_id INT NOT NULL CONSTRAINT CUST_ORD_FK REFERENCES customer
);

------------------------------- 
--     CATEGORY
-------------------------------
CREATE TABLE category 
(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1) 
     CONSTRAINT CATEGORY_PK PRIMARY KEY,
  name VARCHAR(45) NOT NULL 
);

INSERT INTO category (name) VALUES 
('Lana'),
('Algodon'),
('Acrilico'),
('Mezcla');

------------------------------- 
--     PRODUCTS
-------------------------------
-- Se agregan columnas para Lote, Temporada y Descuento
CREATE TABLE product 
(
  id INT NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1, INCREMENT BY 1), 
  name VARCHAR(45) NOT NULL,
  price DECIMAL(5,2) NOT NULL,
  description VARCHAR(50),
  last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  category_id INT NOT NULL,
  existencia INT NOT NULL,
  grosor VARCHAR(45),
  fibra VARCHAR(45),
  marca VARCHAR(45),
  lote VARCHAR(20) DEFAULT 'GENERAL', -- Nuevo campo Lote
  es_temporada SMALLINT DEFAULT 0,    -- Nuevo campo Temporada (0: No, 1: Si)
  descuento DECIMAL(3,2) DEFAULT 0.00, -- Nuevo campo Descuento (ej. 0.10)
  PRIMARY KEY (id),
  CONSTRAINT fk_product_category
    FOREIGN KEY (category_id)
    REFERENCES category (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO product (name, price, description, last_update, category_id, existencia, grosor, fibra, marca, lote, es_temporada, descuento) VALUES
('Merino Suave', 150.00, 'Lana merino fina para bebes', TIMESTAMP('2025-01-01 09:00:00'), 1, 500, 'Ligero (3)', '100% Merino', 'Lion Brand', 'LOTE-A1', 1, 0.10),
('Lana Highland', 200.50, 'Lana virgen de tierras altas', TIMESTAMP('2025-01-01 09:00:00'), 1, 300, 'Medio (4)', '100% Lana', 'Patons', 'LOTE-B2', 0, 0.00),
('Algodon Pima', 120.00, 'Algodon peruano brillante', TIMESTAMP('2025-01-01 09:00:00'), 2, 600, 'Fino (2)', '100% Algodon', 'Bernat', 'LOTE-C3', 1, 0.15),
('Hilaza Rustica', 85.00, 'Ideal para amigurumis', TIMESTAMP('2025-01-01 09:00:00'), 2, 800, 'Super Fino (1)', '100% Algodon', 'Sinfonia', 'LOTE-C3', 0, 0.00),
('Super Saver', 60.00, 'Económico y duradero', TIMESTAMP('2025-01-01 09:00:00'), 3, 10, 'Medio (4)', '100% Acrilico', 'Red Heart', 'LOTE-D4', 0, 0.00), -- Poca existencia para probar sustitutos
('Baby Soft', 55.00, 'Antialergico colores pastel', TIMESTAMP('2025-01-01 09:00:00'), 3, 900, 'Ligero (3)', '100% Acrilico', 'Cisne', 'LOTE-E5', 0, 0.00),
('Wool-Ease', 110.00, 'Calidez de lana facil cuidado', TIMESTAMP('2025-01-01 09:00:00'), 4, 400, 'Abultado (5)', '80% Acrilico 20% Lana', 'Lion Brand', 'LOTE-F6', 1, 0.05),
('Mandala Ombre', 180.00, 'Cambios de color degradados', TIMESTAMP('2025-01-01 09:00:00'), 4, 350, 'Medio (4)', 'Acrilico Premium', 'Lion Brand', 'LOTE-G7', 0, 0.00);

------------------------------- 
--     ORDERED_PRODUCTS
-------------------------------
CREATE TABLE ordered_product
(
  customer_order_id INT NOT NULL, 
  product_id INT NOT NULL, 
  quantity SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (customer_order_id, product_id),
  CONSTRAINT fk_ordered_product_customer_order
    FOREIGN KEY (customer_order_id)
    REFERENCES customer_order (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ordered_product_product
    FOREIGN KEY (product_id)
    REFERENCES product (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

disconnect;