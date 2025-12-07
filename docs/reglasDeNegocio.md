## Reglas de Negocio

| ID  | Regla de Negocio | Descripción |
|-----|------------------|-------------|
| RN1 | Identificación de Productos | Cada estambre debe estar registrado con un **idProd único**, incluyendo color, grosor, tipo de fibra y lote. |
| RN2 | Validación de Stock | Antes de confirmar la compra, el sistema debe verificar existencia suficiente por producto en el inventario (WSPedido). |
| RN3 | Cálculo de Costo | Si el stock es suficiente, se debe calcular el monto total de la orden (montoCO). |
| RN4 | Validación de Crédito | La compra solo procede si el cliente tiene crédito autorizado en el WS de Facturación. |
| RN5 | Política de Rollback | Si el crédito es rechazado, el sistema debe liberar los productos apartados en inventario. |
| RN6 | Generación de Envío | Tras aprobar el crédito, se debe generar una guía en el WS de Envíos asociada al cliente y pedido. |
| RN7 | Manejo por Lotes | Los estambres deben venderse considerando su **lote de producción**; no se pueden mezclar lotes en la misma orden si tienen restricciones de calidad. |
| RN8 | Productos Sustitutos | Si un estambre no está disponible, el sistema debe sugerir **productos sustitutos compatibles** (mismo grosor y fibra). |
| RN9 | Reglas de Descuento | Aplicar descuentos a estambres de temporada. |
