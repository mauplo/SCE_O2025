# SCE_O2025

Guía del Proyecto

Este repositorio contiene toda la información, entregables y lineamientos para el proyecto **SCE_O2025**. El objetivo de este README es servir como **guía completa para todos los integrantes del equipo**, detallando documentos clave, entregables, organización y flujos de trabajo.

---

## Documentación principal

A continuación se encuentran los enlaces a los documentos principales del proyecto:

* **[Documentación General del Proyecto](https://itam2-my.sharepoint.com/:w:/g/personal/mauricia_pena_itam_mx/ET12bkKyEfRAtNFNBocvW4UBbO7VTKhAXcck083euPIBzw?e=Vp8Ioh)**

* **[Responsabilidades del Equipo](https://itam2-my.sharepoint.com/:w:/g/personal/mauricia_pena_itam_mx/Ef9O6lchtohJtBIcgw2eDNcBSGT6g_CMjHWNdV9M11uGvw?e=7tsG1L)**

* **[Plan de Trabajo](https://itam2-my.sharepoint.com/:x:/g/personal/mauricia_pena_itam_mx/EZKX-tA5iQBDp5gFwEEe9qUBdBMM6JRz1Fy_mODThtlhSA?e=6CQH8m)**

---

## Entregables del Proyecto

Esta sección resume todos los entregables esperados y su status: completado/faltante.

### 1. Control del Proyecto

- [ ] Plan de Trabajo en Excel

### 2. Requerimientos de Negocio

- [ ] Documento de Requerimientos de Negocio en formato tabular simple.
- [ ] Requerimientos no funcionales: Volumetrics (Cantidad esperada y máxima de transacciones y de qué tipo)
- [ ] Reglas de Negocio

### 3. **Casos de Uso / Historias de Usuario**

- [ ] Happy Path
- [ ] Rutas Alternas para Reglas de Negocio

### 4. **Documento de Arquitectura**

- [ ] Bosquejo de Arquitectura con los nombres de los componentes con descripción breve del componente con tecnología de soporte;

### 5. Responsabilidades de Componentes de Arquitectura y relación con reglas de Negocio

- [ ] Tabla con los componentes de Arquitectura con:
- [ ] Responsabilidades en cuanto a requerimientos funcionales;
- [ ] Responsabilidades en cuanto a requerimientos no funcionales.

### 6. **Implementación del Sistema**

- [ ] Tabla de detalle de plan de trabajo con bitácora diaria de avance de las actividades y desviaciones del proyecto. 

### 7. **Documentación de pruebas funcionales**

- [ ] Batería de pruebas Funcionales por servicio de negocio y en general:
- [ ] Descripción del “Steady State” para cada caso;
- [ ] Script de carga de Bases de datos para “Steady State”;
- [ ] Transacciones habituales
- [ ] Datos a inyectar;
- [ ] Respuesta esperada y forma de verificación;
- [ ] Proceso automatizado de detección de cumplimiento.

### 8. **Documentación de pruebas No Funcionales**

- [ ] Descripción de carga para la prueba no funcional:
- [ ] Volumetrics por tipo de transacción para cada servicio;
- [ ] Condiciones de “Steady State” y Scipt de carga de Bases de Datos;
- [ ] Volumetrics por tipo de transacción y modalidad para servicio integrado

### 9. **Arquitectura y control de versiones**

- [ ] Bitácora de Entregas y desviaciones de Integración con:
- [ ] Entregas y versiones de componentes;
- [ ] Instalación de la versión “Steady” para cada entrega parcial;
- [ ] Cumplimiento con la integración.

### 10. **Documento y componente del WS de Almacen**

- [ ] Documento de Arquitectura del servicio con:
- [ ] Relación a Reglas y Requerimientos de Negocio;
- [ ] Pruebas funcionales
- [ ] Pruebas No Funcionales.

### 11. **Documento y componente del WS de Pagos**

- [ ] Documento de Arquitectura del servicio con:
- [ ] Relación a Reglas y Requerimientos de Negocio;
- [ ] Pruebas funcionales
- [ ] Pruebas No Funcionales.

### 12. **Documento y componente del WS de Entregas**

- [ ] Documento de Arquitectura del servicio con:
- [ ] Relación a Reglas y Requerimientos de Negocio;
- [ ] Pruebas funcionales
- [ ] Pruebas No Funcionales.

## 13. **Documento de Estress a cada servicio**

- [ ] Script, Proceso y Pojos de estress;
- [ ] Tabla con resultados de las Pruebas de Estress para las versiones estables.

---

## Estructura del repositorio

```
SCE_O2025/
│
├── docs/                # Documentación adicional, diagramas, recursos
├── backend/             # Código fuente del backend
├── frontend/            # Código del frontend (si aplica)
├── bpel/                # Procesos BPEL, WSDL, XSD
├── database/            # Scripts SQL y diagramas
├── testing/             # Casos de prueba y evidencia
└── README.md            # Este archivo
```

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

## Flujo de trabajo del equipo

1. **Revisión del plan de trabajo**
2. **Asignación de tareas** según responsabilidades
3. **Integración en ramas individuales → revisión → merge**
4. **Documentación continua en SharePoint**
5. **Entrega formal de componentes** según fechas

---

## Notas importantes para el equipo

* Mantener toda la evidencia y documentación dentro de las carpetas oficiales.
* Actualizar este README cuando surja un entregable nuevo.
* Todo componente debe incluir al menos:

  * Descripción
  * Instrucciones de ejecución
  * Dependencias

---
