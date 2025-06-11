Feature: Compra de un producto en saucedemo

  Scenario: Usuario compra un producto exitosamente
    Given que el usuario abre la aplicación saucedemo
    When inicia sesión con usuario "standard_user" y contraseña "secret_sauce"
    When valida que el usuario ve la lista de productos
    And selecciona el producto "Sauce Labs Backpack"
    And lo agrega al carrito
    And navega al carrito de compras
    And valida que el producto "Sauce Labs Backpack" está en el carrito
    When procede al checkout
    And ingresa nombre "John", apellido "Doe" y código postal "12345"
    And finaliza la compra
    Then debería ver el mensaje "Thank you for your order!"

