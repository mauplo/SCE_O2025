## Reglas de Negocio

| ID  | Regla de Negocio | Descripción |
|-----|------------------|-------------|
| RN1 | Identificación de Usuarios | Los usuarios deben estar registrados en el medio de pago con un **idCliente único**. |
| RN2 | Identificación de Productos | Los estambres en el almacen debe estar registrado con un **idProd único**, incluyendo color, grosor, tipo de fibra y lote. |
| RN3 | Formato de Pedidos | Los pedidos se realizarán con un **idCliente** y lista de estambres con cantidades respectivas. |
| RN4 | Validación de Stock | La compra solo procede si existe el inventario necesario. |
| RN5 | Validación de Crédito | La compra solo procede si el cliente tiene crédito autorizado en el WS de Facturación. |
| RN6 | Política de Rollback | Si el crédito es rechazado, el sistema debe liberar los productos apartados en inventario. |
| RN7 | Generación de Envío | Tras aprobar el crédito, se debe generar una guía en el WS de Envíos asociada al cliente y pedido. |
| RN8 | Manejo por Lotes | Los estambres deben venderse considerando su **lote de producción**; no se pueden mezclar lotes en la misma orden si tienen restricciones de calidad. |
| RN9 | Productos Sustitutos | Si un estambre no está disponible, el sistema debe sugerir **productos sustitutos compatibles** (mismo grosor y fibra). |
| RN10 | Reglas de Descuento | Aplicar descuentos a estambres de temporada. |
