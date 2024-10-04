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

Clonar el repositorio

Clona este repositorio en tu máquina local con el siguiente comando:

`git clone https://github.com/tu_usuario/conversor-monedas.git`
