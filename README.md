## Challenge ONE | Java | Back End | Conversor de Moneda

 ¡Bienvenido al proyecto con la solución al desafío Conversor de Moneda con Java! Pasos principales:

 Este proyecto es un conversor de monedas que te permite convertir una cantidad específica de dinero de tu moneda local a otros tipos de monedas. El programa también incluye un convertidor decimal a binario "Solo números enteros".

 El código comienza con una clase llamada CurrencyConverter que contiene atributos como localMoney, conversionsMenu, acronym, moneys y saveConversion.

El método principal del programa establece el valor de localMoney y saveConversion en cero, luego muestra un menú con dos opciones (conversor de moneda y convertidor decimal a binario). El programa entra en un bucle infinito, mostrando la operación correspondiente a la opción seleccionada y preguntando si el usuario quiere continuar.

El método showMenu muestra un menú al usuario para elegir entre las diferentes monedas disponibles para la conversión. El método chooseLocalCurrency permite al usuario seleccionar su moneda local y la cantidad de dinero que desea convertir. El método executeOperation tiene una estructura switch que selecciona la operación correcta a realizar según la selección del menú del usuario.

El método currencyConversionMenu muestra las opciones de conversión de moneda disponibles para la moneda local seleccionada. Finalmente, el método convertCurrency calcula la tasa de conversión y muestra la cantidad convertida.

Por otro lado tenemos una clase llamada Money que pertenece al mismo paquete de la clase CurrencyConverter.

Esta clase  utiliza la biblioteca JSoup para extraer información de un sitio web y obtener los valores de conversión de la moneda. A continuación se describen las características de esta clase:

Atributos:

- url: una cadena que representa la URL del sitio web que se va a analizar.
- currencyValue: un número decimal que representa el valor de la moneda.
- html: un objeto Document de JSoup que representa la estructura HTML del sitio web.
- article: un objeto Elements de JSoup que contiene los elementos HTML que contienen los valores de conversión.
  
Métodos: 

- Money(): un constructor sin argumentos que inicializa todos los atributos con valores nulos o cero.

- Money(String url): un constructor que acepta una cadena que representa la URL del sitio web.
- 
    Money(String url, double currencyValue, Document html, Elements article): un constructor que acepta cuatro argumentos para inicializar los atributos de la clase.
-
    getHtml(): un método que utiliza JSoup para conectarse a la URL especificada y obtener la estructura HTML del sitio web. Luego llama al método getCurrencyValue() para obtener el valor de conversión de la moneda.
-
    getCurrencyValue(): un método que analiza la estructura HTML del sitio web para encontrar el valor de conversión de la moneda. Luego, limpia el valor encontrado y lo convierte a un número decimal para almacenarlo en el atributo currencyValue.
