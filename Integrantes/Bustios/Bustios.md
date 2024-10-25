# Abraham Bustios

![Abraham Bustios Terres](bezos.jpg)

¿Cuál es mi experiencia en desarrollo de software?
Experienca en desarrollo de proyectos de curso en Java, C# y javascript. 

¿Qué tecnologías conozco o domino?

Conocimientos de ingenieria de Software y metologias ágiles.
NextJS 

¿Cuál es mi expectativa del curso?

Ampliar mis conocimientos en el área del desarrollo de software para adentrarme en el mundo laboral profesional.


¿Cómo me veo en 10 años? 

Como un desarrollador independiente y dueño de mi propio estudio de desarrollo de videojuegos.




## Tema elegido: API Management

### Desarrollo Conceptual
API management o gestión de API es el proceso de diseño, publicación, documentación y análisis de API, en un entorno seguro. Mediante una herramienta de administración de API, se puede garantizar que tanto APIs públicas como internas funcionen correctamente y sean seguras. Puedes controlar el acceso, nutrir a la comunidad de suscriptores, recopilar y analizar estadísticas de uso e informar sobre el rendimiento.

Usualmente, los componentes de API management, proporcionan mecanismos y herramientas para ayudar a la comunidad de desarrolladores y suscriptores.

#### Diseño de API: es decir, brinda a los usuarios, desde desarrolladores hasta socios, la capacidad de diseñar, publicar e implementar una API, así como registrar documentación, políticas de seguridad, descripciones, límites de uso, capacidad de tiempo de ejecución, entre otra información relevante.

#### Puerta de enlace de API: 
funciona como un filtro de todas las APIs al hacer cumplir las políticas y solicitudes de seguridad de las APIs relevantes y también garantiza la autorización y la seguridad. 

#### Tienda de APIs: 
brinda a los usuarios la capacidad de mantener sus APIs en una tienda o catálogo donde pueden exponerlas a posibles interesados. Además, los usuarios pueden obtener soporte de los usuarios y la comunidad, etc. 

#### Análisis de API: 
la gestión de APIs permite a los usuarios monitorear el uso del API, la carga, los registros, las transacciones, los datos históricos, entre otras métricas que informan mejor el estado y el éxito de las APIs disponibles.

#### Monetización: 
esta función permite el cobro por el acceso a APIs comerciales. Esto incluye el soporte para configurar reglas de precios, según el uso, la carga y la funcionalidad, emitir facturas y cobrar pagos.

### Consideraciones Técnicas:

La plataforma de API management en cuestión es "Apigee", plataforma de API management de google. Para este proyecto usaremos APIGEE para establecer un proxy entre el frontend y backend .

Para ello es necesario 


## Patron Cloud a Implementar : Valet Key

**Problema :** 
Un problema que logramos identificar es que al contar con 2 tipos de usuarios para el aplicativo web , el usuario (cliente) y el usuario (Proveedor) . El Cliente debe poder acceder a funciones como el buscador de servicios y contratación de proveedor, mientras que el proveedor debe poder publicitar sus servicios, responder mensajes y actualziar etapa del servicio ( contratado , en proceso , finalziado). Por ende, es importante restringir el acceso de un tipo usuario a las funciones de otro tipo de usuario y evitar errores .
**Solución:**
Mediante la implemetnación del patrón Valet Key ( token de acceso), se puede asignar un token distintivo a cada tipo de usuario a la hora de logearse en la paltaforma , y de esa forma restrtingir el acceso a cada tipo de usuario.
**Casos de aplcación :**






[Regresar al índice](../../README.md)
