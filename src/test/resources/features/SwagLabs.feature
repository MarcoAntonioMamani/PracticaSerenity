@Login
  Feature: login
   Scenario Outline: Uso de las variables de session
     Given acceder a la "<url>" de SwagLabs con usuarioy password
     Examples:
       | url |
       | https://www.saucedemo.com/ |
