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

## Video de la dema

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

### Solución

Si bien, la escabilidad hacia arriba podría ser una solución, la escabilidad horizontal se vuelve más estable ya que se puede crear instacias de la aplicación conocidos como sellos, las cuales se pueden hacer cambios de forma independiente. Es como crear pequeños clones de la aplicación para asignarlo a un tipo de cliente en particular. Cada instancia tiene su propia configuración y tasa de actualizaciones. 

### Casos de aplicación

1. Cuando se tiene varios grupos de clientes segmentados en todo el país, en donde se pueden conectar en la instancia de la nube más cercana para evitar problemas de conectivadad.
2. Cuando se requiera abordar una mayor demanda en la aplicación, en vez de comprar un servicio en la nube más grande, solo se requerira manejar varias instancia de la aplicación para que cada grupo pueda segmentar los clientes.

### Aplicación en el grupo


3. **Desarrollo de Código y Demo**:
   - Implemente una solución que utilice el patrón seleccionado en un caso real o en un escenario de ejemplo bien definido.
   - Documente el caso real y detalle el proceso de implementación, asegurándose de describir cada paso realizado.
   - (Opcional) Prepare una demo en video donde muestre el funcionamiento de la implementación, explicando brevemente su funcionamiento.

4. **Entrega**:
   - Sobre su página personal en el repositorio de Github del grupo debe agregar una sección titulada "Patrones Cloud".
   - Puede desarrollar el código en el mismo repo o en un repositorio externo.
   - Si realiza el video, súbalo a una plataforma de su elección (YouTube, Vimeo, etc.) y comparta el enlace en la documentación.

## Regresar
[Regresar al índice](../../README.md)
