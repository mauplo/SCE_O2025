## 3.2.1 Fallo por Falta de Stock
Condición: El cliente pide un estambre agotado. 

Comportamiento: 
1. El servicio WSPedido retorna return <= 0. 
2. El BPEL captura esto en el If1 y responde con Fault: No se puede surtir el pedido.

## 3.2.2 Fallo por Crédito Insuficiente (Con Rollback)

Condición: Hay stock, pero el cliente no tiene dinero. 

Comportamiento:
1. Stock apartado exitosamente.
2. WS_Autorizacion lanza Excepcion_Negocio.
3. El FaultHandler del BPEL captura el error.
4. Se invoca RegresaProductos en WSPedido para liberar el stock.
5. Se notifica al usuario el error de crédito.
