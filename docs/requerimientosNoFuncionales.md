## Requerimientos No Funcionales (RNF)

| ID    | Categoría              | Descripción |
|-------|-------------------------|-------------|
| RNF1  | Volumetría / Performance | El sistema debe soportar **100 transacciones por minuto**, incluyendo altas de artículos, modificaciones de stock y operaciones del medio de pago. |
| RNF2  | Tiempo de Respuesta     | Cada servicio (Almacén, Pagos y Envíos) debe responder en **menos de 2 segundos** en condiciones de carga normal. |
| RNF3  | Confiabilidad           | Las transacciones deben ser **ACID**, asegurando consistencia entre inventario, pagos y envíos. |
| RNF4  | Integridad de Datos     | Los servicios deben validar tipos de datos, rangos permitidos y coherencia antes de procesar operaciones. |
