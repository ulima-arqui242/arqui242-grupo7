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
API management o gestión de API es el proceso de diseño, publicación, documentación y análisis de API, en un entorno seguro. En la cual mediante una herramienta de administración de API's, se puede garantizar que tanto APIs públicas como internas funcionen correctamente y sean seguras. Además, aglunas de las carateristicas que se pueden encontrar en este tipo de herramientas son las de api gateway para gestionar, proteger y optimizar el tráfico entre el Frontend y Backend, 


### Consideraciones Técnicas:

La plataforma de API management en cuestión es "Apigee", plataforma de API management de google. Para este proyecto usaremos APIGEE para establecer un proxy entre el frontend y backend .

Para ello es necesario 


## Patron Cloud a Implementar : Asynchronous Request-Reply

### **Problema :**

Hoy en dia las aplicaciones  que corren en navegadores hacen uso de multiples API's para ofrecer funcionalidad y entregar valor a las empresas y usuarios, las cuales pueden interactura solo con los elementos de sistema o tambien con otros externos de terceros. Estas consultas se hacen usualmente mediante el  protocolo HTTP y Rest, y aunque en al acutalidad la gran mayoria de estas apis están optimizadas para responder en 100ms o menos todavia hay muchos factores que pueden afectar la latencia en la respuesta, cómo por ejemplo:

- Componentes de seguridad.
- La ubicación geográfica relativa del autor de la llamada y el backend.
- Infraestructura de red.
- Carga actual.
- El tamaño de la carga útil de la solicitud.
- Longitud de la cola de procesamiento.
- El tiempo que tarda el backend en procesar la solicitud.

Si bien algunos de estos factores se pueden mitigar escalando y añandiendo mas recursos al backend todavia existen otros como la arquitectura de red, que están fuera de control del desarrollador. Pero aún así todavia existen escenarios en los que el procesamiento de la respuesta de una petición síncrona puede tardar demasiado como para responer en la misma conexión, para ello existe la posibilidad de hacer una petición asíncrona que parezca sincrona

### **Consideraciones Tecnicas:**


1. El cliente envia una petición POST conteniendo la data necesarioa de entrada al endpoint  , el servidor recibe la petición y pone en cola el recurso solicitado a la vez envia una respuesta HTTP 200 (Aceptado) conteniendo una dirección a un endpoint al cual consultar por el estado del recurso al que se solicitó acceso.
2. El cliente envia una petición GET al endpoint de estado y recibe un HTTP 200 O 404 indicando que el recurso solicitado todavia no está listo.
3. El cliente envia nuevamente una petición GET al endoint de estado luego de un timpo determinado y el servidor envia un HTTP 302 (found) con la dirección de recurso solicitado .
4. Por ultimo el cliente envia una petición GET a la dirección brindada por el servidor para finalmente acceder al recurso solicitado.


![foto](asy.png)



### **Casos de aplcación :**









### **Aplicación en el trabajo de Grupo :**

El problema que se logró identificar es que uno ed los pasos que los clientes y proveedores deben completar para registrarse es la validación del DNI o RUC por motivos de seguridad. Debido a que el registros consta de varios pasos y que la validadción puede demorar o dar algún error dependiendo de la API seria un problema detener el registro unicamente para validar los documentos de identidad cuando podrian validarse antes de enviar la conclusión del registro.
Mediante la implementación del patrón Asynchronous Request-Reply se espera que los usuarios puedan completar formulario de registro sin la necesidad de esperar a que su dni o RUC se valide meidiante la API de APIsPerú, cumpliendo así con la finalidad del patrón Asynchronous Request-Reply de permitir seguir haciendo uso de otras funciones de la aplicación hast aque se reciba la respuesta de la API.


### **Desarrollo de código :**

#### ** Variables Globales**
![Variables Globales](Globales.png)


####  ** API validar DNI**
![Variables Globales](apiback.png)


####  ** API Estado validar GET**
![Variables Globales](apiestadoGET.png)

####  ** API Estado validar POST**
![Variables Globales](apiestadoPOST.png)


####  ** Variables Globales**
![foto](https://drive.google.com/file/d/1vcbcpC35dEgOmZGqwNAAGIKP4BugLG_y/view?usp=drive_link)



## Patrón Arquitectura MicroKernel



**Desarrollo Conceptual :**

El estilo arquitectónico de Microkernel o también conocido como arquitectura de Plug-in, permite crear aplicaciones extensibles, mediante la cual es posible agregar nueva funcionalidad mediante la adición de pequeños plugins que extienden la funcionalidad inicial del sistema. En una arquitectura de Microkernel las aplicaciones se dividen en dos tipos de componentes, en sistema Core (o sistema central) y los plugins (o módulos), el sistema Core contiene los elementos mínimos para hacer que la aplicación funcione y cumpla el propósito para el cual fue diseñada, por otra parte, los módulos o plugins con componentes periféricos que se añaden o instalan al componente Core para extender su funcionalidad. O sea que solo puede haber un componente Core y muchos Plugins.


![Diagrama](microkernel.jpg)


La idea central de este estilo arquitectónico es permitir la extensión de su funcionalidad o personalización, pero respetando el principio Open-Closed, es decir, está abierto para extender la funcionalidad, pero cerrado para modificar su funcionalidad principal. De esta forma, se logra que los desarrolladores pueden crear plugins para agregar nueva funcionalidad o extender la existente, pero sin alterar la funcionalidad Core del sistema

#### Ventajas

  - Escalabilidad: El patrón permite agregar funcionalidades adicionales a traves de módulos o plugins sin modificar el nucleo del sistema, al tomar este enfoque de arquitectura en vez de implementar multiples funcionalidades junto con el nucleo base se logra reducir el acoplamiento.



**Consideraciones tecnicas :**

El plugin que se desea agregar al sistema base (core) es el de Nodemailer, un plugin que mediante sus propioas librerias que permite enviar correos electronicos incluyendo el destintatario, asunto, mensaje e inclusive permite ingresar HTML con estilos , es importante recalcar que Nodemailer no nos proporciona con un correo desde el cual enviar los correos, para ello nosotros tendremos que utilizar nuestro propio correo y realizar una serie de configuraciones previas .(Por motivos practicos se utilizará un correo de google). Si seguimos las indicaciones en su propia web (https://www.nodemailer.com) para hacer uso de plugin nos encontramos con los siguientes pasos.

### 1. Instalamos las librerias en el proyecto

![install](npminstall.png)

### 2. Creamos un sendmail.JS para la ruta en el backend
Creamos el archivo y copiamos y  el código que nos indica la pagina de https://www.nodemailer.com , sin antes importar las librerias que se han utilizado para manejar los endpoints del backend. (En este caso se utilzó router. para manejar las peticiones. 

![install](sendmailjs.png)

#### Y no olvidamos de agregar el sendmail.js al index del backend

![index](index.png)

### 3. Seteo de credenciales y configuración de correo
A continuación definimos las siguientes variables dentro de un  .env en el backend para poder almacenar el correo y contraseña de la dirección de correo que se planea utilizar, importante dejar el campo de la contraseña vacio, pues luego definiremos   una contraseña especial para aplicaciones que nos propocionará google

![credenciales](env.png)

#### Activamos verificación de 2 pasos
Para poder generar una contraseña de aplicación para una cuenta de google es necesario activar primero la verificación de 2 pasos en el apartado de seguridad de la cuenta de google, para ello ocuparemos de un correo o número de telefono que sirva como autenticador adicional.

![2pasos](2pasos.png)

#### Generar contraseña de aplicación
Luego de haber activado la verificación de 2 pasos ingresamos al siguiente enlace https://myaccount.google.com/u/5/apppasswords?rapt=AEjHL4OhXd0DaCXS7CjMGYZewDnFaRYZhcdZNGlF5_HlRx4o5Q3f5COtnudTolOAf5_Bt7W_FrIwpHLg0HkaCGmbYTEP97T-QyFI8yN9p-5tevqO_WazmzQ .

Ahora definimos el nombre de la aplicación para la que se va a generar la clave de aplicación y le damos a crear 

![claveapp](app.png)

Una vez generada la clave podemos ingresarla en la variable EMAIL_PASSWORD en el .env visto al inicio del paso

(ES DE SUMA IMPORTANCIA PROTEGER ESTA CLAVE YA QUE ES LA QUE PERMITE A CUALQUIER APLICACIÓN ENVIAR CORREOS EN NUESTRO NOMBRE)

![contra](clave.png)

### 4. Prueba
Por ultimo ejecutamos el backend y realizamos una petición de tipo POST al endpoint http://localhost:3009/sendmail e incluimos en su body los siguientes valores

utilizamos postman para hacer a prueba 

![image](https://github.com/user-attachments/assets/0b85fedc-ee7d-4d8a-b5f8-329da7618239)

Y recibimos el correo exitosamente

![image](https://github.com/user-attachments/assets/843aef5b-37fc-45d8-9932-ef03f47760da)



## Demo Video

https://drive.google.com/file/d/1v4ayTE6-QU_Esuu5Ul7mewtyg0cLE0gO/view?usp=sharing

[Regresar al índice](../../README.md)
