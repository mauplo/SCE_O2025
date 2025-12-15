<p align="left">
  <img src="docs/portada.png" width="600">
</p>

# SCE_O2025

Guía del Proyecto

Este repositorio contiene toda la información, entregables y lineamientos para el proyecto **SCE_O2025**. El objetivo de este README es servir como **guía completa para todos los integrantes del equipo**, detallando documentos clave, entregables, organización y flujos de trabajo.

---

## Estructura del repositorio

```
SCE_O2025/
│
├── 1_Pedidos/           # WS y POJO de Pedidos
├── 2_Autorizaciones/    # WS y POJO de Autorización
├── 3_Envios/            # WS y POJO de Envíos
├── 4_Integrado/         # BPEL y CA
├── FormatosParaProy../  # Documentación
├── InterfazDesacoplada/ # Interfaz para POJOs
├── docs/                # Documentación adicional, diagramas, recursos
└── README.md            # Este archivo
```

---

## Documentación principal

A continuación se encuentran los enlaces a los documentos principales del proyecto:

* **[Documentación General del Proyecto](https://itam2-my.sharepoint.com/:w:/g/personal/mauricia_pena_itam_mx/ET12bkKyEfRAtNFNBocvW4UBbO7VTKhAXcck083euPIBzw?e=Vp8Ioh)**

* **[Responsabilidades del Equipo](https://itam2-my.sharepoint.com/:w:/g/personal/mauricia_pena_itam_mx/Ef9O6lchtohJtBIcgw2eDNcBSGT6g_CMjHWNdV9M11uGvw?e=7tsG1L)**

---

## Entregables del Proyecto

Esta sección resume todos los entregables esperados y su status: completado/faltante.
TODO está en el documento FormatosParaProyectoFinal_Documentacion.docx

### 1. Control del Proyecto

- [X] Plan de Trabajo en Excel. **[Plan de Trabajo](https://itam2-my.sharepoint.com/:x:/g/personal/mauricia_pena_itam_mx/EZKX-tA5iQBDp5gFwEEe9qUBdBMM6JRz1Fy_mODThtlhSA?e=6CQH8m)**

### 2. Requerimientos de Negocio

- [X] Documento de Requerimientos de Negocio en formato tabular simple. **[Reglas de Negocio](docs/requerimientosFuncionales.md)**
- [X] Requerimientos no funcionales: Volumetrics (Cantidad esperada y máxima de transacciones y de qué tipo) **[Reglas NF](docs/requerimientosNoFuncionales.md)**

### 3. **Casos de Uso / Historias de Usuario**

- [X] Happy Path **[Happy Paths](docs/happyPaths.md)**
- [X] Rutas Alternas para Reglas de Negocio **[Rutas Alternas](docs/rutasAlternas.md)**

### 4. **Documento de Arquitectura**

- [X] Bosquejo de Arquitectura con los nombres de los componentes con descripción breve del componente con tecnología de soporte;

### 5. Responsabilidades de Componentes de Arquitectura y relación con reglas de Negocio

- [X] Tabla con los componentes de Arquitectura con:
- [X] Responsabilidades en cuanto a requerimientos funcionales;
- [X] Responsabilidades en cuanto a requerimientos no funcionales.

### 6. **Implementación del Sistema**

- [X] Tabla de detalle de plan de trabajo con bitácora diaria de avance de las actividades y desviaciones del proyecto. 

### 7. **Documentación de pruebas funcionales**

- [X] Batería de pruebas Funcionales por servicio de negocio y en general:
- [X] Descripción del “Steady State” para cada caso;
- [X] Script de carga de Bases de datos para “Steady State”;
- [X] Transacciones habituales
- [X] Datos a inyectar;
- [X] Respuesta esperada y forma de verificación;
- [X] Proceso automatizado de detección de cumplimiento.

### 8. **Documentación de pruebas No Funcionales**

- [X] Descripción de carga para la prueba no funcional:
- [X] Volumetrics por tipo de transacción para cada servicio;
- [X] Condiciones de “Steady State” y Scipt de carga de Bases de Datos;
- [X] Volumetrics por tipo de transacción y modalidad para servicio integrado

### 9. **Arquitectura y control de versiones**

- [X] Bitácora de Entregas y desviaciones de Integración con:
- [X] Entregas y versiones de componentes;
- [X] Instalación de la versión “Steady” para cada entrega parcial;
- [X] Cumplimiento con la integración.

### 10. **Documento y componente del WS de Almacen**

- [X] Documento de Arquitectura del servicio con:
- [X] Relación a Reglas y Requerimientos de Negocio;
- [X] Pruebas funcionales
- [X] Pruebas No Funcionales.

### 11. **Documento y componente del WS de Pagos**

- [X] Documento de Arquitectura del servicio con:
- [X] Relación a Reglas y Requerimientos de Negocio;
- [X] Pruebas funcionales
- [X] Pruebas No Funcionales.

### 12. **Documento y componente del WS de Entregas**

- [X] Documento de Arquitectura del servicio con:
- [X] Relación a Reglas y Requerimientos de Negocio;
- [X] Pruebas funcionales
- [X] Pruebas No Funcionales.

### 13. **Documento de Estress a cada servicio**

- [X] Script, Proceso y Pojos de estress;
- [X] Tabla con resultados de las Pruebas de Estress para las versiones estables.

---

## Roles y Responsabilidades

Consulta el documento completo aquí:
**[Responsabilidades del equipo](https://itam2-my.sharepoint.com/:w:/g/personal/mauricia_pena_itam_mx/Ef9O6lchtohJtBIcgw2eDNcBSGT6g_CMjHWNdV9M11uGvw?e=7tsG1L)**

Resumen:

* **Project Manager** – Coordinación general, avances, entregables
* **Arquitectura** – Diseño técnico, validación de componentes
* **Desarrollo** – Implementación de módulos asignados
* **QA** – Pruebas y validación
* **Documentación** – Mantener actualizado SharePoint y el repositorio

---
