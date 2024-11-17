# Aarón Livias

![Aarón Livias](https://media.licdn.com/dms/image/v2/D4E03AQGd6fPm4Jv6OA/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1703021391954?e=1729728000&v=beta&t=a5BQTeZpRUQChEQEBUOQGYtUZSlD-jUI57po782suKA)
### Experiencia:
Mi experiencia en desarrollo de software se ve presente en los trabajos personales realizados en las vacaciones. Últimamente eh desarrollado un proyecto de web scraping a distintas páginas web para armar una base de datos propia. Por otro lado, me enfoqué en proyectos relacionado a manejar páginas wed que se centren a cumplir ciertos requisitos de seguridad.
### Tecnologías:
- Python
- Javascript (React)
- Typescript
- Rstudio
### Expectativa:
Aprender a seleccionar las mejores opciones para desarrollar un proyecto apropiadamente, así como incrementar las habildades técnicas y blandas para culminar el proyecto con la calidad deseada.
### De aquí a 10 años
- Trabajando para un proyecto relacionada a las páginas web, tareas como darle mantenimiento o agregar nuevas funcionalidades.

# Tema elegido: Técnicas NLP
## Panorama General
El presente proyecto aborda técnicas NLP para tareas de resumenes y similitud de textos. De esta forma se plantea incorporarlo en el trabajo grupal para ayudar al usuario en la elección del servicio del hogar de modo que se le muestre un resumen de las las reseñas que van generando los servicios. La estrategia se inspira de Mercado Libre en la que incorpora una IA el resumen de textos asociados a sus productos.

![Mercado Libre](https://drive.google.com/uc?export=view&id=1hCmi7Io9b_BaNVUuTnPKbqm_TUABGyW5)

## Modelos de simlitud de textos

### Desarrollo conceptual
#### TF-IDF
Es un algoritmo que realiza un cálculo estadístico para medir qué terminos son relevantes para un texto en particular. Está compuesto por dos términos:
TF: Calcula el número total de términos y el número total de apariciones de un término específico (t) en un documento (d). 

TF (t,d)=(`Número total de t en d`)/(`Número total de términos en d`)

IDF: El IDF mide que tanto ese término específico aparece en el corpus

IDF (t)=1+log⁡((`Número total de documentos`)/(`Número de documentos en t`))

En síntesis, las palabras con mayor TF-IDF se caracterizar por ser de las más frecuentes en ese texto pero excasas en todo el corpus que representa el conjunto de texto. Funciona bien si comentarios similares tienden a compartir las mismas palabras o términos clave, pero sensible a los stopwords. Son palabras irrelevantes para el algoritmo las cuales pueden ser: "la", "y", "los", etc. Por eso hay que filtrarlos.

#### Doc2vec
Captura relaciones semánticas más profundas a nivel de documento. Ejemplo: "La entrega fue excelente" y "Me llegó muy rápido" tiene una relación semántica alta. Esta basada en word2vec la cual tiene dos arquitecturas principales:
1. CBOW: Captura la relación semántica de las palabras y su entrenamiento consiste en predecir una palabra a partir de las palabras que lo rodea, pero expresado en números o vectores. La cual la arquitectura DM se basa de CBOW para la creación de la variante Doc2vec.
2. Skip-gram: En contraste, esta arquitectura se centra en predecir varias palabras a partir de la palabra objetivo. A partir de este se basa la arquitectura DBOW de Doc2vec.

Arquitectura principales de Doc2vec:

| **Memoria Distribuida (DM)** | **Bolsa Distribuida de Palabras (DBOW)** |
|-------------------------------|-----------------------------------------|
| Predice palabras a partir de los vectores de palabras y documentos. | Predecir las palabras a partir del vector del documento. |
| Representación global del documento y la relación que hay dentro de sus palabras. | Representación global del documento. |
| Los datos no se tratan como una bolsa. | Las palabras se tratan como una "bolsa" dado que el orden de estas no importan |

Asimismo, Eberhard et al. (2024) realiza una comparación de estas técnicas en su desempeño para la recomendación de películas:

![Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=1d0D7_7yMKR82JuIjj2x0OLeuQTzh5Q8V)

### Consideraciones técnicas
El lenguaje de programación a utilizar es python. Primero se establece una maquina virtual con los siguientes comandos en el command prompt. Se recomienda utilizar una maquina virtual para evitar que la instalación de las dependencias de trabajos pasados no generen problemas con el proyecto actual.:

```
python -m venv mi_entorno
mi_entorno\Scripts\activate
```

Luego se instala las librerias necesarias para la generación del modelo:
```
pip install nltk scikit-learn gensim pandas numpy
```

1. NumPy: Para ordenar los arregloes de mayor a menor.
2. Pandas: Para la manipulación de los dataframe generados por el diccionario o el archivo en formato .csv
3. gsim: Para la generación del modelo Doc2vec.
4. Scikit-learn: Para la creación del TF-IDF.
5. NLTK: Abarcar diferentes herramientas NLP y se utilizará para filtrar tokenizar y lematizar.

Adicionalmente, se descarga librerias específicas, lo puede hacer con el command prompt o ejecutandolo una sola vez en el código:
```
# Tokenización
nltk.download('punkt') 
nltk.download('punkt_tab')

# Lematización
nltk.download('wordnet')
#   Soporta lematización en varios idiomas
nltk.download('omw-1.4')
```
Terminada la instalación, se procederá a explicar la lógica del proyecto.

![Flujo Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=16LtKE4OniMIASw3RjdzQo5vLLYf-ncbL)

1) A partir de un diccionario, se tokeniza para segmentar las oraciones en palabras y se lematiza para convertir la palabra en su forma base.
2) Podemos utilizar tanto TF-IDF como Doc2vec para generar vectores de representación de reseñas o Embeddings. Con respecto al modelo Doc2vec se requiere establecer algunos parametros de entrada para el entrenamiento. Cabe aclara que por default, el Doc2vec utiliza la arquitectura DM, pero si se requiere cambiar de arquitectura se agraga un parámetro extra definido como 'dm=0'. A continuación los parámetros del modelo:
```
# Definir y entrenar el modelo Doc2Vec
model = Doc2Vec(vector_size=50, #longitud vector que representa la palabra
                window=2, #Número de palabras (izq o der) a tomar en cuenta para hallar la palabra objetivo (La palabra que se va a predecir).
                min_count=1, # El número mínimo de veces que una palabra debe aparecer para considerarse.
                workers=4, # El número de hilos (threads) - Tareas que se realizan en parelelo para agilizar el modelo.
                epochs=100 # Número de veces que pasará el modelo por el conjunto de datos.
                )
```
3) Luego se utiliza las métricas de similitud más populares como la similitud coseno o la distancia euclidiana y así clasificar los vectores. Esto genera una matriz o un arrays de arrays, en la que cada array representa un documento y sus valores el nivel de similitud que tienen hacia otros documentos. En la imagen, el primer valor es 1 porque el texto uno es igual al texto 1, pero en el segundo array el 1 se observa en el segundo valor (indicando que el texto 2 es igual al 2). Así se representa la probabilidad que hay en que un texto sea similar a otro.

![Matriz Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=1zF2DL02Ile-c2_AzyUA9sHxSZNHT-f6Z)
  
4) Se escoge la ID de un texto, por ejemplo, la ID=3 y a partir de la array escogido se ordena de mayor a menor las probabilidades a través de un algoritmo de ordenamiento de Quicksort o directamente argost de Numpy.

Lo cual si se escoge la ID = 3, se obtendrá como resultado:

![Resultado Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=1mdlsfVwzELy5BNfo2FMh8hBEkP08fGbu)

## Algoritmo de resumen de texto - TextRank
### Desarrollo conceptual

Es un algoritmo de NLP inspirada en PageRank porque asigna una puntuación a cada página web basada en el número o cantidad de enlaces que esta tiene sobre otras páginas. Shaistha (2024) indica que el algoritmo asigna una puntuación a cada palabra clave según la relación que tienen con otras palabras clave. Tanto PageRank como TextRank utilizan un algoritmo recursivo para calcular la importancia de páginas o palabras según la actualización de sus puntuaciones basado en relaciones, lo cual presenta información representativa de un documento, lo cual resulta ventajoso para grandes cantidades de texto.

### Consideraciones técnicas

El lenguaje principal a utilizar es python, no obstante para la visualización de los datos se utilizó Jupiter. En la versión de python, se instalará las siguientes librerias:
```
pip install numpy pandas scikit-learn nltk
```
1. NumPy: Para ordenar los arregloes de mayor a menor.
2. Pandas: Para la manipulación de los dataframe generados por el diccionario o el archivo en formato .csv
3. Scikit-learn: Para la creación del TexkRank y TF-IDF.
4. NLTK: Abarcar diferentes herramientas NLP y se utilizará para filtrar los stopwords.

Adicionalmente se descarga la libreria de los stopwords en donde solo se necesita ejecutar una vez para su instalación:
```
import nltk
nltk.download('stopwords')
```

Terminada la instalación, se procederá a explicar la metodología del proyecto:

![Diagrama TextRank](https://drive.google.com/uc?export=view&id=1DkVanXMxZqrt3cmLGb0-v7EFdn4AWuIV)


1. Se divide el texto en oraciones a partir de un '.', luego se corrigen las oraciones finales y casos donde hay doble puntos, se establece un ancho fijo en la segmentación de oraciones para evitar que la matriz sea extensa y filtrar los stopwords.
2. Tokenizar el documento en oraciones y luego se utiliza TF-IDF para encontrar las oraciones más representativas.
   
3. Se aplica la similitud coseno para generar el grafo representativo del textrank pero aún faltaría los puntajes asociados.

![Similitud coseno](https://drive.google.com/uc?export=view&id=1dxvX2DJUZWT0g7fxUUw22_K30neQnmbJ)
  
4. Se normaliza la matriz de modo que se aumente los valores que son casi nulos, así facilitar al modelo en calcular las oraciones más representativas y evitar generar nodos aislados debido a que no tiene conexión con otro. De esta forma cada nodo tiene una probabilidad más alta para parecerse a otro de manera semántica.

![Matriz TextRank](https://drive.google.com/uc?export=view&id=1P4zdb3t2xXnJ2R2f4MPc4c7GcQr4RCCM)

5. Se calculan el PageRank o directamente el Eigenvectors para asignar los nodos más representivos del todo grafo asociado. A partir de una secuencia iterativa, se varia la longitud de los vectores para encontrar los puntajes acorde al grafo.

![PageRank](https://drive.google.com/uc?export=view&id=1f8AAQ2k4QxINLmg8N2ktH8-kiD1VaWC2)

6. Se extrae las oraciones más representativas del texto a partir del algoritmo de ordenamiento.

![Resultados TextRank](https://drive.google.com/uc?export=view&id=1PrBN-2p21D23oF1zh_wMcNWZUxBO_U10)

## Video de la demo

A continuación se presentará un video de la demo que explicará más a detalle el trabajo descrito.
[Video individual](https://drive.google.com/file/d/1yANwjCY09ROsNuj49xsa3Xe3aGUbfR_N/view?usp=sharing)

## Fuentes
[Doc2Vec — Computing Similarity between Documents](https://medium.com/red-buffer/doc2vec-computing-similarity-between-the-documents-47daf6c828cd)

[Practical Guide To Doc2Vec & How To Tutorial In Python](https://spotintelligence.com/2023/09/06/doc2vec/)

[Video de TextRank](https://www.youtube.com/watch?v=wszNhc3iQHg&t=15s)

[Algoritmo de TextRank](https://medium.com/@theofany007/implementation-of-textrank-and-methods-for-keyword-extraction-b84f8f145b2e)

[Abdurahman, B. Z., Ikhsan, N., Muslim, K. K. I., Kenneth, D. R., & Dwi, H. R. (2023). Movie recommender chatbot based on Dialogflow. International Journal of Electrical and Computer Engineering (IJECE).](https://doi.org/10.11591/ijece.v13i1.pp936-947)

[Blessed, G., Bello Kontagora, N., Agajo, J., & Aliyu, I. (2023). Performance evaluation of keyword extraction techniques and stop word lists on speech-to-text corpus. The International Arab Journal of Information Technology, 20(1).](https://doi.org/10.34028/iajit/20/1/14)

[¿Cómo generar palabras clave a partir de un texto? (2024, mayo 2). Eskritor.](https://eskritor.com/es/generar-palabras-clave-a-partir-de-texto/)

[Eberhard, L., Popova, K., Walk, S., & Helic, D. (2024). Computing recommendations from free-form text. Expert Systems with Applications, 236(121268), 121268.](https://doi.org/10.1016/j.eswa.2023.121268)

[Hong, M., Chung, N., & Koo, C. (2023). Tourism recommendation based on word embedding from card transaction data. Computer Science and Information Systems.](https://doi.org/10.2298/CSIS220620002H)

[Shaistha, F. (2024). How TextRank Algorithm Helps in Effortless Keyword Extraction. Markovml.](https://www.markovml.com/blog/textrank-algorithm)

# Deployment Stamps: Implementación de Patrones Cloud

## Desarrollo del patrón

### Problema

Si se aloja una única instancia de la aplicación en la nube, existe la posibilidad de que presente limitaciones en la escabilidad. Es decir, una vez que la aplicación llegue al tope en usuarios conectados al mismo tiempo o el número de recursos utilizados al máximo, el rendimiento de la aplicación caerá notablemente. Además, se plantea el problema en la segmentación de los clientes. Por ejemplo, si un cliente utiliza la aplicación con frecuencia y depende de los recursos de esta requerira que la tasa de actualizaciones sea la mínima y solo si es una versión estable; no obstante, si se tiene un cliente la cual no depende de forma crítica de la aplicación entonces tolerará de mejor formas estas actualizaciones. 

1. Escalabilidad
    
    Hay arquitecturas que tienen una opción de escalar, pero no en múltiples instancias. Haciendo una analogía, es como tener un local para un restaurante y tener solo la posibilidad de hacerlo más grande, pero no crear multiples surcursales dispersas en todo Lima. En otras palabras, si solo tenemos las instancias BD SQL y la aplicación podemos obtener recursos mayores, pero llegará el momento que alcanzará el tope del plan que ofrece Azure para estos recursos.
    
2. Manejar instancias de inquilinos únicos y múltiples
    
    Ejemplo, se tiene dos tipos de clientes en un marketplace, un grupo de vendedores que utiliza la página web con mayor frecuencia (actualizando su contenido, respondiendo comentarios, etc). Esto consume recursos con mayor fuerza, pero se tiene otro grupo de vendedores que ocasionalmente utiliza la aplicación. Segmentar la aplicación en multiples instancias garantiza que la carga de trabajo que exija otros clientes no relentice la de otros. La arquitectura mostrada en la imagen solo admite instancias multiinquilino en donde todos los datos se almacenan en una sola instancia.
    
3. Restricciones geográficas
    
    Algunas industrias como las financieras deben cumplir con normas que exigen tener los datos dentro de las frontares del país y la arquitectura está alojada en Brasil del sur.

### Solución

Si bien, la escabilidad hacia arriba podría ser una solución, la escabilidad horizontal se vuelve más estable ya que se puede crear instacias de la aplicación conocidos como stamps, las cuales se pueden hacer cambios de forma independiente. Es como crear pequeños clones de la aplicación para asignarlo a un tipo de cliente en particular. Cada instancia tiene su propia configuración y tasa de actualizaciones.

### Casos de aplicación

¿Cuándo debemos utilizar el Deployment Stamp Pattern?

1. Cuando la aplicación está cerca de alcanzar al límite de escalabilidad vertical. Por ejemplo, a pesar de estar utilizando el plan más robusto de una BD, aún se requiere más espacio para almacenar los datos.
2. Cuando se necesita almacenar los datos de los clientes en un lugar específico. 
3. Cuando un grupo de clientes necesitan un versión de la aplicación diferente a los demás clientes.
4. Cuando se quiere lograr una resistencia en las interrupciones. Los stamps trabajan de manera individual, por lo que si un stamp está inactivo otros no serán afectados.

¿Cuándo no utilizarlo?

1. Cuando tenemos un sistema simple o aún le falta por escalar bastante de manera vertical. Por ejemplo, se está utilizando el plan gratuito de una BD y tiene a su disposición más planes que podrían hacer más robusto la BD.
2. Cuando necesitamos que todos los datos estén en todos los stamps.
3. Necesitamos escalar componentes de la arquitectura y dejar otros componentes sin stamp.
4. Si tenemos una página web stática. Por ejemplo, la interfaz no varía según el tipo de usuario que se registre.

### Aplicación en el grupo

Se podría segmentar los clientes por vendedores pequeños, medianos y grandes. Asi cuando los clientes que requieran más recursos de la aplicación, se le brindará un servicio más estable en el proveedor de la nube y su propio contendor. Un contenedor permite ejecutar la aplicación de manera aislada, junto con sus dependencias, sin necesidad de depender del principal. Por ejemplo, se puede tener un contendor para backend y otro para el frontend, ambos corriendo al mismo tiempo utilizando Docker. Además, se puede utilizar Docker Swarm para gestionar la implementación de esos contenedores.

3. **Desarrollo de Código y Demo**:

A continuación, se trabajará con una plantilla propia de Azure en donde se verá la creación de los stamps, configuraciones de enrutamiento de tráfico y cómo realizar stamps de manera automática.

Paso 1: Suscripción de Azure 1

Para crearlo se debe dar click a la suscripción, y elegir la opción “actualizar suscripción” (Es una advertencia que sale en la parte superior).

![1](https://drive.google.com/uc?export=view&id=1U9Tv6Ctr4uovYAJ9HT3sxogkClDUcorC)

Paso 2: Entrar a link y click en Deploy to Azure

https://learn.microsoft.com/en-us/samples/azure/azure-quickstart-templates/web-app-sql-database/

![2](https://drive.google.com/uc?export=view&id=11TUxiC88bdVUA4OWD2Mu-l-OQfY3-ToV)

Paso 3: Crear el stamp.

Es importante asignar la región más cercana, en este caso Brazil South.

![3](https://drive.google.com/uc?export=view&id=1Zb1tBO9XGaVhDoxMV5Zx-S9EiVdUOvuj)

Paso 4: Visualizar el grupo de recursos del stamp2

![4](https://drive.google.com/uc?export=view&id=1S7Aun5w8lvdt36fzwBEZXrbyZNdp_wfp)

Tenemos la instacia de la aplicación (el stamp)

1. Grupo de acciones
2. El plan de servicio de la aplicación
3. La base de datos
4. El servidor
5. El servicio de la aplicación.

![5](https://drive.google.com/uc?export=view&id=1rnea5pD_jsEn65GrW1MhdheE-jbiAFfH)

Creamos otro stamp:

![6](https://drive.google.com/uc?export=view&id=1YjUfMosM4nBidthGNZ7xFdBGn_sdqYWI)

Paso 5: Visualizar el dominio predeterminado del stamp.

Click en App Service y luego a examinar, tanto en el Stamp2 como en el Stamp3.

![7](https://drive.google.com/uc?export=view&id=1ULk1RDxqKW_GoX3-s6uv-4nmXepw4r2S)

![8](https://drive.google.com/uc?export=view&id=1oJJhTAZLepfib3IkxlmPh7gx97FLgvwh)

Stamp2:

![9](https://drive.google.com/uc?export=view&id=1WiKWFN3J6uYrkjsqecvCiMahT4wToWF_)

Stamp3:

![10](https://drive.google.com/uc?export=view&id=1hXnVWHEItPdbE9VoyMzNJyaSPq1LmUsa)

Visualmente las páginas son identicas porque se ejecutan a partir de la misma plantilla proporcionada por Azure. No obstante, la diferencia está en el link porque está alojada a un “App service” y “BD SQL” diferente. Por lo que este es uno de los escenarios de los patrones de stamp que puede ayudar a resolver. Podemos segmentar los clientes por cada stamp creado, variando así los requerimientos que debe cumplir la app para satisfacer sus necesidades. Por ejemplo, en Office 365 tienen una diferencia de URL para cada cliente que se una a su servicio. 

¿Qué se hace en concreto?

Se puede definir si un stamp soporta:

1. Multiinquilino
2. Inquilino único

En donde cada stamp tiene una pontencia informática diferente, la cual cada una tendrá su propia URL para iniciar sesión. Pero puede llegar la situación en la que se necesite de una URL donde todos los tipos de clientes utilicen al mismo tiempo y luego administrar ese tráfico para enrutar a cada cliente o inquilino a su respectivo stamp. Es ahí en donde entra el enrutamiento de tráfico, lo cual se hará en los siguiente pasos.

Paso 6: Registrar un proveedor en la suscripción.

Me base del link para registrarlo: https://learn.microsoft.com/es-mx/azure/azure-resource-manager/management/resource-providers-and-types?WT.mc_id=Portal-Microsoft_Azure_AFDX

En suscripción, nos dirigimos a “Proveedores y recursos”.

![11](https://drive.google.com/uc?export=view&id=1gFRPQgXn2WZV_d6uo5j7GNVYQtIHLGBW)

Buscamos, seleccionamos el proveedor y lo registramos:

![12](https://drive.google.com/uc?export=view&id=1dmgfBIcLY8cpRZXadmDRf5lCD-QTvwOa)

Paso 7: Agregar puerta principal.

En la sección “Más servicios”, buscamos “puerta principal”:

![13](https://drive.google.com/uc?export=view&id=1KV5mUySQ1c1w5pvwcpxLyrKPwTU0JFLv)

![14](https://drive.google.com/uc?export=view&id=1y-DHutQPAviIyLjFg5UVeKJWVRitA3rC)

Como es una demo, seleccionamos el siguiente plan:

![15](https://drive.google.com/uc?export=view&id=1pBZej2yUdgGtkfbzi5GIynf7BYa2Mgzi)

Asignamos un nombre al grupo de stamps.

![16](https://drive.google.com/uc?export=view&id=1NxW1EPGJAmrbcjAFqPW7AuS0tcg7w3Jt)

Paso 8: Definir Frontend.

![17](https://drive.google.com/uc?export=view&id=1PKomR3lLicHCWU-SEvhVbxJs0t8IaDjD)

![18](https://drive.google.com/uc?export=view&id=1JLvzww1gtWz_vja54Nxjpg92XRhZtZ1i)

Paso 9: Definir Backend.

![19](https://drive.google.com/uc?export=view&id=1W64rj5d06Vpu17FlTbHZ2jNafjL7XNBU)

![20](https://drive.google.com/uc?export=view&id=1Firqa5_lRVFf74T_pbQXxRvu1Vo1rnxx)

Seleccionamos el link del stamp2 (hipervinculo que vimos en el paso 5) y luego el peso lo ponemos a 100 (Asignar peso a diferentes origenes para distribuir el tráfico, en este caso ambos tiene un peso equivalente). Click en agregar.

Del mismo modo, se creará otro backendpoolpt02, pero utilizando el hipervínculo del stamp3.

Paso 10: Definir las reglas de enrutamiento.

![21](https://drive.google.com/uc?export=view&id=1LKMl7CRhw_ihlm1mJCpb0ExvCibAJz2w)

Seleccionamos “HTTP solo”, pero para definir el stamp02routing lo definimos con “HTTPs solo”. El dominio frontend es el link que se utilizará para llamar a los dominios stamp2 y stamp3.

![22](https://drive.google.com/uc?export=view&id=1CBKXv-f2ph2-FVe__RWtdmCZannG9hnW)

![23](https://drive.google.com/uc?export=view&id=1eP7eEGWTD7naINsreiybIJxp6Ek5N7tU)

Agregamos el link del stamp2.

![24](https://drive.google.com/uc?export=view&id=11r3HD5Z3suV4VpgomRJ51i2JxfZHwNk-)

Hacemos lo mismo con stamp02routing , agregamos el link del stamp3.

![25](https://drive.google.com/uc?export=view&id=1k9dEMut8N6g4Z6z_OyULHolziUG4Vau8)

Click a “Crear”, luego al “Ir al curso”.

![26](https://drive.google.com/uc?export=view&id=1Q5234WqKaja0K_bVJsdPB-tYphjHmUfC)

Copiamos el hosts princpal.

![27](https://drive.google.com/uc?export=view&id=18J3u5IvnqLKLjYrTtJInB0MpqytwopuO)

A continuación, se explorará en la versión http y https del mismo URL.

![28](https://drive.google.com/uc?export=view&id=1vpdzHwcHUxWf2grI14KzGSh9DANCSXId)

Ahora cuando le damos enter y luego lo actualizamos, saldrá el stamp2:

![29](https://drive.google.com/uc?export=view&id=1ddYB7TS873ipif6ifC4BEU6OJIrPEsDT)

Pero si lo ponemos en http:

![30](https://drive.google.com/uc?export=view&id=1RzaSn_vwfNhX6DJ1xgYmdkhRGU9CVNTB)

y luego lo actualizamos, saldrá el stamp3:

![31](https://drive.google.com/uc?export=view&id=10pSKz7DiHwW6aoVVoI84limk_QDDPSQC)

Como se observa, la URL redirige a uno de los stamp, lo cual demuestra que la configuración de enrutamiento está bien y redirigirá el tráfico a diferentes stamp según el protocolo (Http o Https).

No obstante, existe configuraciones de enrutamiento más complejas, lo cual se utiliza “Configuración de motor de reglas” para vincular a las reglas de enrutamiento.

![32](https://drive.google.com/uc?export=view&id=1ab_FHND20meeh57xHriCqZmCTEEQhXeM)

![33](https://drive.google.com/uc?export=view&id=1MbEXIQIHg6-kUQ6SjtL36I9CPGVkjR2c)

![34](https://drive.google.com/uc?export=view&id=1TEwqT9Iz0Mfl5zD4wP9_9q7ESpYSJOjc)

![35](https://drive.google.com/uc?export=view&id=1UZPh2qJuJT2-JT4UGFxVyPxnDa4ImlYm)

![36](https://drive.google.com/uc?export=view&id=1JXGzaHJW0qjRKyLLjcU6icNDEbqv9ie5)

![37](https://drive.google.com/uc?export=view&id=1FerT2CAxl5vJgLCnfLgpFQU9hqJ-xFIc)

La puerta de entrada se reproduce en la URL única que todos los usuarios accederán para acceder a la aplicación y en función a la configuración de enrutamiento va asignar a diferentes stamps, con un “app service” y un “SQL DB” propio. 

Por lo cual, hay dos opciones:

1. Conformarse a que dos tipos de clientes usen diferentes URLs para acceder a sus stamp.
2. Todos los clientes usarán un solo tipo de URL para acceder a su propio stamp en base a las configuraciones de enrutamiento que se especifique en el Azure Front Door.

Ahora, ¿Qué pasa si queremos implementar cientos de stamps?

Entonces, no conviene hacerlo manualmente. Aprovechandose del administrador de implementación en Azure, se escoge una plantilla de topología y una de implementación con sus respectivos parámetros.

La topología define los recursos a utilizar y en dónde.

La implementación define cuándo se aplicarán estos cambios y las condiciones que se debe cumplir para proceder con la creación de stamps.

Como se aprecia en el código rescatado del link: https://www.youtube.com/watch?v=8uaWoKkyIWk

En cada región, incluye diferentes recursos a implementar en un servicio en particular.

![38](https://drive.google.com/uc?export=view&id=1P1F3MvMHm9Su2uZhn5Qk6g3K5D1YPRad)

### Fuentes:

https://www.youtube.com/watch?v=8uaWoKkyIWk

https://learn.microsoft.com/en-us/samples/azure/azure-quickstart-templates/web-app-sql-database/

https://learn.microsoft.com/es-mx/azure/azure-resource-manager/management/resource-providers-and-types?WT.mc_id=Portal-Microsoft_Azure_AFDX

https://learn.microsoft.com/en-us/azure/architecture/patterns/deployment-stamp

4. **Entrega**:
   - Sobre su página personal en el repositorio de Github del grupo debe agregar una sección titulada "Patrones Cloud".
   - Puede desarrollar el código en el mismo repo o en un repositorio externo.
   - Si realiza el video, súbalo a una plataforma de su elección (YouTube, Vimeo, etc.) y comparta el enlace en la documentación.

## Regresar
[Regresar al índice](../../README.md)
