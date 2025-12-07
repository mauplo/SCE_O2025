## 3.1.1	Compra Exitosa de Estambres
Historia: "Como cliente registrado, quiero comprar 5 madejas de estambre de lana y 2 de algodón para recibir mi número de guía de envío." 
1.	El cliente envía solicitud.
2.	WS_Pedido confirma stock y aparta las 7 madejas.
3.	WS_Pedido devuelve el costo total.
4.	WS_Autorizacion confirma que el cliente tiene saldo suficiente.
5.	WS_Envios registra el envío y devuelve guía.
6.	El BPEL responde al cliente con el numPedido
