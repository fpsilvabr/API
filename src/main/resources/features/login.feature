# language: pt
# encoding UTF-8

Funcionalidade: Realizar Login

  @login
  Esquema do Cenario: Realizar login na aplica��o
    Dado que informo os dados de login <email> e <password>
    Quando envio uma requisicao POST 
    Entao o codigo de resposta e <statusCode>
    E o servico retorna o token na respota

    Exemplos:
      | email                | password     | statusCode |
      | "eve.holt@reqres.in" | "cityslicka" | 200        |
