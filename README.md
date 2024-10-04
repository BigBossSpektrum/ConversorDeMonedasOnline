# Conversor de Monedas

### Este es un proyecto de consola en Java que permite realizar conversiones de monedas utilizando la API de ExchangeRate-API. El programa muestra una lista de las 10 monedas más populares junto con sus abreviaciones y nombres completos, permitiendo al usuario seleccionar la moneda de origen, la moneda de destino, y la cantidad que desea convertir. El resultado de la conversión se muestra de manera clara con las tasas de cambio actualizadas.

# Características

- Permite convertir entre las 10 monedas más populares:
  - USD (Dólar estadounidense)
  - EUR (Euro)
  - GBP (Libra esterlina)
  - JPY (Yen japonés)
  - AUD (Dólar australiano)
  - CAD (Dólar canadiense)
  - CHF (Franco suizo)
  - CNY (Yuan chino)
  - SEK (Corona sueca)
  - NZD (Dólar neozelandés)
  
- Utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.
- Incluye un menú interactivo que permite al usuario seleccionar monedas por abreviación y nombre.
- Implementación sencilla utilizando Java y HttpClient para consultas HTTP.

# Dependencias

El proyecto utiliza las siguientes dependencias:

- Google Gson: Para convertir los datos JSON recibidos desde la API en objetos Java.
- Java HttpClient: Para realizar la solicitud HTTP a la API de tipos de cambio.
  
# Instalación

## 1. Clonar el repositorio

Clona este repositorio en tu máquina local con el siguiente comando:

> git clone https://github.com/tu_usuario/conversor-monedas.git

## 2. Agregar las dependencias

Si estás utilizando Maven, asegúrate de agregar la siguiente dependencia para Gson en tu archivo pom.xml:

    <dependency><groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version></dependency>

Si no estás utilizando Maven, descarga la biblioteca Gson desde aquí y agrégala manualmente al classpath de tu proyecto.

## 3. Configurar tu API Key

El programa utiliza una API Key de ExchangeRate-API. Si necesitas generar tu propia clave, puedes hacerlo aquí. Luego, reemplaza el valor de la clave en el código ConsultaAPI.java con tu propia clave API:

> URI link = URI.create("https://v6.exchangerate-api.com/v6/TU_API_KEY/latest/USD");

# Uso

## 1. Ejecutar el programa

Para ejecutar el programa, asegúrate de compilar y ejecutar la clase Principal.java.

Desde la línea de comandos:

  `
  javac Principal.java
  java Principal
  `
## 2. Flujo del programa

- El programa mostrará un menú con las monedas más populares y sus nombres completos.
- El usuario seleccionará la moneda de origen y destino introduciendo el número correspondiente.
- Luego, se solicitará la cantidad de la moneda de origen que desea convertir.
- El programa mostrará el resultado de la conversión y permitirá realizar nuevas conversiones o salir del programa.
  
## 3. Ejemplo de salida

      Seleccione una opción para la moneda de origen: 
      1. USD (Dólar estadounidense)
      2. EUR (Euro)
      3. GBP (Libra esterlina)
      4. JPY (Yen japonés)
      ...
      11. Salir
      Seleccione una opción (1-11): 1
      Seleccione una opción para la moneda de destino: 
      1. USD (Dólar estadounidense)
      2. EUR (Euro)
      ...
      11. Salir
      Seleccione una opción (1-11): 2
      Introduce la cantidad a convertir: 100
      100.00 USD equivalen a 87.34 EUR
      ¿Deseas realizar otra conversión? (si/no): no

# Consideraciones

- La precisión del resultado depende de las tasas de cambio proporcionadas por la API en el momento de la consulta.
- Si el programa lanza excepciones relacionadas con la API, asegúrate de revisar tu conexión a Internet y la validez de la clave API.
