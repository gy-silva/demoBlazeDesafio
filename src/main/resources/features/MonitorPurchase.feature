#language: pt

Funcionalidade: Compra de monitor

  @CompraDeMonitor
  Cenário: Compra de monitor com dados
    Dado que o usuário está na Home Page
    Quando o usuário seleciona a categoria de Monitor
    E adiciona um monitor para o carrinho
    E usuário vai até o carrinho
    E faz o processo de checkout
    E completa o formulário de compra
    Então compra será bem sucedida


