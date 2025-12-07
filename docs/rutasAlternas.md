## 3.2.1 Fallo por Inconsistencia de Lotes (Regla RN8)

Condición: El cliente pide 8 madejas de un estambre específico. En almacén hay 10 en total, pero 4 son del "Lote A" y 6 son del "Lote B". 

Comportamiento:
1. BPEL invoca a altaPedido.
2. WSPedido detecta que no puede cubrir 8 unidades con un solo lote homogéneo.
3. WSPedido no aparta nada y retorna código de error por lote
4. BPEL identifica el código y lanza un Fault específico: "No es posible surtir la cantidad con un mismo lote de teñido para garantizar la calidad del proyecto".

## 3.2.2 Sugerencia de Sustitutos por Falta de Stock (Regla RN9)

Condición: El cliente pide "Algodón Rosa Pastel". Stock = 0. 

Comportamiento:
1. BPEL invoca a altaPedido.
2. WSPedido retorna 0 apartados, pero llena la estructura de respuesta listaSustitutos con estambres de mismo color y fibra
3. BPEL evalúa if (apartados == 0).
4. En el Else, en lugar de solo lanzar error, el BPEL construye una respuesta que incluye: "Producto agotado. Le sugerimos las siguientes alternativas compatibles con su aguja: [Lista de Sustitutos]".
