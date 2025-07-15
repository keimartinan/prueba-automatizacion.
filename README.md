Automatización con Selenium WebDriver (Java, Cucumber y POM)
Objetivo
Evaluar la capacidad del candidato para desarrollar un robot de automatización utilizando Selenium WebDriver, Cucumber y la metodología Page Object Model (POM). Se evaluará:
•	Manipulación de WebElements (inputs, botones, tablas, selects, etc.).
•	Uso de tiempos de espera adecuados.
•	Implementación de Page Object Model (POM).
•	Estructura de Cucumber con Gherkin.
•	Generación de reportes.
•	Manejo de excepciones y buenas prácticas en automatización.
•	Utilizar navegador Firefox. 
Sitios web a automatizar
•	https://www.saucedemo.com/ → Para el flujo de compra. 

Escenario 1: "Compra de un producto en SauceDemo"
El candidato debe desarrollar una prueba automatizada que realice los siguientes pasos:

Instrucciones
1.	Abrir el navegador e ir a https://www.saucedemo.com/.
2.	Iniciar sesión con las siguientes credenciales:
•	Usuario: standard_user
•	Contraseña: secret_sauce
3.	Validar que el inicio de sesión fue exitoso verificando la presencia de la lista de productos.
4.	Seleccionar un producto (Ejemplo: "Sauce Labs Backpack").
5.	Agregarlo al carrito.
6.	Ir al carrito y validar que el producto agregado está presente.
7.	Proceder al checkout.
8.	Ingresar datos en el formulario de compra:
•	Nombre: John
•	Apellido: Doe
•	Código Postal: 12345
9.	Finalizar la compra y validar que aparece el mensaje "Thank you for your order!".
10.	Cerrar el navegador.
