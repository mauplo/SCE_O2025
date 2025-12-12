connect 'jdbc:derby://localhost:1527/proj_credito;user=app;password=app';

DROP TABLE operacion;
DROP TABLE cliente;
DROP TABLE proveedor;

------------------------------- 
--     CLIENTE
-------------------------------
CREATE  TABLE  cliente
(
  id INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT CLIENTE_PK PRIMARY KEY,
  nombre              VARCHAR(45)  NOT NULL ,
  email               VARCHAR(45)  NOT NULL ,
  tel                 VARCHAR(45)  NOT NULL ,
  calle_num           VARCHAR(45)  NOT NULL ,
  colonia             VARCHAR(45)  NOT NULL,
  municipio           VARCHAR(45)  NOT NULL,
  entidad             VARCHAR(45)  NOT NULL,  
  rfc                 VARCHAR(13)  NOT NULL,
  linea_credito       DECIMAL(9,2) NOT NULL DEFAULT 100000.00,
  monto_disponible    DECIMAL(9,2) NOT NULL DEFAULT 100000.00,
  monto_utilizado     DECIMAL(9,2) DEFAULT 0.0,
  monto_max           DECIMAL(8,2) DEFAULT 10000.00, 
  status              VARCHAR(1)   NOT NULL DEFAULT 'A',
  fecha_status        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  fecha_ult_solicitud TIMESTAMP
  );

INSERT INTO cliente (nombre,email,tel,calle_num,colonia,municipio,entidad,rfc,linea_credito,monto_disponible) VALUES
('Harry Gomar',  'harry.gomar@estambres.com',  '5512345678', 'Av. Tejidos 101', 'Centro', 'Coyoacan', 'CDMX','GOMH900101H1',100000.00,100000.00),
('Mauricia Pena','mauricia.pena@estambres.com','5587654321', 'Calle Agujas 22', 'Del Valle', 'Benito Juarez', 'CDMX','PENM850505M2',100000.00,100000.00),
('Adrian Janus', 'adrian.janus@estambres.com', '5511223344', 'Blvd. Lana 55', 'Polanco', 'Miguel Hidalgo', 'CDMX','JANA920303H3',100000.00,100000.00),
('Axel Castro',  'axel.castro@estambres.com',  '5599887766', 'Callejon Hilo 8', 'Condesa', 'Cuauhtemoc', 'CDMX','CASA880808H4',100000.00,100000.00);

------------------------------- 
--     PROVEEDOR
-------------------------------

CREATE  TABLE  proveedor
(
  id INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT PROVEEDOR_PK PRIMARY KEY,
  nombre              VARCHAR(45)  NOT NULL ,
  email               VARCHAR(45)  NOT NULL ,
  tel                 VARCHAR(45)  NOT NULL ,
  calle_num           VARCHAR(45)  NOT NULL ,
  colonia             VARCHAR(45)  NOT NULL,
  municipio           VARCHAR(45)  NOT NULL,
  entidad             VARCHAR(45)  NOT NULL,  
  rfc                 VARCHAR(13)  NOT NULL,
  monto_adeudado      DECIMAL(9,2) NOT NULL DEFAULT 0.0,
  fecha_status        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status              VARCHAR(1)   NOT NULL DEFAULT 'A',
  fecha_ult_operacion TIMESTAMP,
  tipo_op             VARCHAR(1)
  );

INSERT INTO proveedor (nombre,email,tel,calle_num,colonia,municipio,entidad,rfc) VALUES
('Hilaturas del Norte S.A.' ,'hilnorte@prov.com',      '8183000001','Industrial 500'    ,'Norte',               'Monterrey', 'NL',  'HIL 980325UI8'),
('Fibras Sinteticas S.A.'   ,'fisin@prov.com'  ,'3336000002','Plastico 200','Zapopan', 'Zapopan',   'JAL','FIS 011204FX3'),
('Algodones Naturales','algnat@prov.com'   ,  '2222000003','Campo 1'   ,'Cholula',              'Puebla','PUE',  'ALG 951023G57'),
('Importadora Estambre'   ,'impex@prov.com',  '5555000004','Aduana 4'      ,'Aeropuerto',           'Venustiano C.',     'CDMX','IMP 991028PJ5');

------------------------------- 
--     OPERACION
-------------------------------
CREATE  TABLE  operacion 
(
  id INT  NOT NULL GENERATED ALWAYS AS IDENTITY 
     (START WITH 1 ,INCREMENT BY 1) 
     CONSTRAINT OPERACION_PK PRIMARY KEY,
  id_cliente   INT NOT NULL,
  id_proveedor INT NOT NULL,
  autorizacion INT,
  fecha_op     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status_op    VARCHAR(1) NOT NULL,
  monto        DECIMAL(8,2) NOT NULL DEFAULT 0.0,
  CONSTRAINT fk_clte_op
    FOREIGN KEY (id_cliente )
    REFERENCES cliente (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_prov_op
    FOREIGN KEY (id_proveedor )
    REFERENCES proveedor (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

create sequence num_autorizacion as int start with 1 increment by 1;

disconnect;