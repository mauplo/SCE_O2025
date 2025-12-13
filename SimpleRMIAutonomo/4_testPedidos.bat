@echo off
echo 4_testPedidos.bat
echo Ejecuta el estresador para probar el servicio de Pedidos (WSPedido)
echo.
echo Uso:
echo   4_testPedidos.bat [NumClientes] [NumSolicitudesPorCliente] [HOSTNAME]
echo.
echo   - NumClientes: Numero de clientes concurrentes (default: 20)
echo   - NumSolicitudesPorCliente: Numero de pedidos por cliente (default: 10)
echo   - HOSTNAME: Host del servidor (default: localhost)
echo.
@echo on

REM Configuración del POJO
set POJO=pojo_parcial_02.Pojo_Parcial_02
set POJOJAR=1_POJO_Pedidos.jar
set INTERFAZJAR=InterfazDesacoplada.jar

REM Configuración de codebase y classpath
set cb=-Djava.rmi.server.codebase=file:%cd%\tstRMI_desacoplado.jar
set cp=-cp .;%cd%\InterfazDesacoplada.jar;%cd%\tstRMI_desacoplado.jar;%cd%\%POJOJAR%

REM Procesar argumentos
if [%1] NEQ [] goto conclientes
estresador 20 %cp% %cb% example.hello.Distribuidor Cliente_Des localhost 10 %POJO%
goto fin

:conclientes
if [%2] NEQ [] goto consolicitudes
estresador %1 %cp% %cb% example.hello.Distribuidor Cliente_Des localhost 10 %POJO%
goto fin

:consolicitudes
if [%3] NEQ [] goto conHost
estresador %1 %cp% %cb% example.hello.Distribuidor Cliente_Des localhost %2 %POJO%
goto fin

:conHost
estresador %1 %cp% %cb% example.hello.Distribuidor Cliente_Des %3 %2 %POJO%

:fin
@echo off
echo.
echo === Test completado ===

pause
