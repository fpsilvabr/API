# language: pt
# encoding UTF-8
@backend
Funcionalidade: Realizar Pull

  Cenario: Realizar um pull
    Dado que estaja logado na aplicacao
    E carregue os dados de source
      | phoneNumber   | cardNumber       | expireDate |accountType|
      | 5511998936551 | 4895142232120006 | 2022-12    |00		  |   
    E carregue o dados da aplicacao amount
      | value | currency |
      | 52.01   | BRL      |
    E carregue o json para o pull
      | transactionCryptogram 						|
      | 0200000000001122c18ca72a8a78c64000000000    |
    Quando enviar a requisicao para o pull
    Entao a aplicacao retorna o status solicitado
      | status |
      | 200    |
