@PeruRail
Feature: PeruRail
##Control + Alt + L = comando que sirve para alinear los textos
  Scenario Outline:Automatizando web en PeruRail
    Given el usuario ingresa a la pagina de PeruRail
    When selecciono el destino "<destino>", la ruta "<ruta>" y seleccionamos el tren "<tren>"
    And seleccionamos la fecha de salida "<mesAnioSalida>" y "<diaSalida>"
    And selecciono el tipo de cabina "<tipo_cabina>" y la cantidad de cabinas "<cant_cabinas>"
    And ingresamos la informacion de los pasajero
      | nombre | apellido | fecha_cumpleanio | nacionalidad | tipo_documento      | nro_documento | sexo | telefono | email                             |
      | Marco  | Mamani   | 08-06-1993       | Peru         | Identification Card | 8230749       | Male | 78140596 | marcoantoniomamanichura@chura.com |
    When doy click en continuar en la pagina de pasajeros
    Then se mostrara la pantalla de pago "PAYMENT METHOD"
    And elegiremos como "<metodod_pago>" metodo de pago e ingresaremos el "<nro_tarjeta>","<mes_expiracion>","<anio_expiracion>", "<codigo_seguridad>","<nombre>"
    Examples:
      | destino | ruta         | tren                             | mesAnioSalida  | diaSalida | tipo_cabina | cant_cabinas | metodod_pago | nro_tarjeta    | mes_expiracion | anio_expiracion | codigo_seguridad | nombre                     |
      | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | September 2022 | 14        | SUITE       | 1 CABIN      | visa         | 42445464654564 | 12             | 25              | 456              | Marco Antonio Mamani chura |







