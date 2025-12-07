## 3.1.1	Compra Exitosa de Estambres 
Condición: "Como cliente registrado, quiero comprar 5 madejas de estambre de lana y 2 de algodón para recibir mi número de guía de envío." 

Compartamiento:
1.	El cliente envía solicitud.
2.	WS_Pedido confirma stock y aparta las 7 madejas.
3.	WS_Pedido devuelve el costo total.
4.	WS_Autorizacion confirma que el cliente tiene saldo suficiente.
5.	WS_Envios registra el envío y devuelve guía.
6.	El BPEL responde al cliente con el numPedido

## 3.1.2 Compra con Descuento de Temporada (RN10)

Historia: "Como cliente, quiero aprovechar las ofertas de fin de invierno comprando estambre de lana gruesa en primavera para obtener un precio reducido." Flujo de Negocio:

Compartamiento:
1. El cliente envía solicitud por 10 madejas de LanaGruesa_Invierno.
2. WSPedido verifica stock y detecta que el producto está fuera de su intervalo de temporada.
3. WSPedido aplica regla RN10 (ej. 20% descuento) y devuelve un montoCO menor al precio de lista.
4. BPEL recibe el monto con descuento y solicita autorización a WSAutorizacion.
5. WSAutorizacion aprueba el monto (más fácil de aprobar al ser menor).
6. Se genera envío y se confirma al cliente el precio final con ahorro aplicado.
