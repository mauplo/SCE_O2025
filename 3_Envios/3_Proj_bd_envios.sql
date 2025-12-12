connect 'jdbc:derby://localhost:1527/proj_envios;user=app;password=app';

DROP TABLE envio;

------------------------------- 
--     ENVIO
-------------------------------
CREATE  TABLE  envio
(
  id INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT ENVIO_PK PRIMARY KEY,
  id_cliente      INT NOT NULL,
  num_pedido      INT NOT NULL,
  fecha_registro  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dias            INT NOT NULL,
  fecha_entrega   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status_envio    VARCHAR(1) NOT NULL
);


disconnect;
