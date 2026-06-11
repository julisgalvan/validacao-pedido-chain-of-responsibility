# Sistema de Validacao de Pedidos - Chain of Responsibility

## Descricao do Projeto

Este projeto implementa um sistema de validacao de pedidos utilizando o padrao de projeto Chain of Responsibility. O sistema simula a validacao de pedidos em um restaurante, verificando tres criterios essenciais antes de aprovar um pedido:

1. Disponibilidade em estoque - Verifica se o produto tem quantidade disponivel
2. Valor do pedido - Valida se o valor esta dentro dos limites permitidos (R$ 10,00 a R$ 500,00)
3. Confirmacao de pagamento - Verifica se o pagamento foi confirmado

## Padrao de Projeto Utilizado

### Chain of Responsibility (Cadeia de Responsabilidade)

O padrao Chain of Responsibility permite que multiplos objetos tenham a oportunidade de tratar uma solicitacao, evitando o acoplamento entre o remetente da solicitacao e seu receptor. Os objetos sao encadeados e a solicitacao passa pela cadeia ate que um objeto a trate.

Neste projeto, a cadeia funciona da seguinte forma:

Pedido -> ValidadorEstoque -> ValidadorPreco -> ValidadorPagamento -> Aprovado

Se qualquer validador falhar, o pedido e rejeitado.

## Estrutura do Projeto

projeto-validacao-pedido/
├── Main.java                    # Classe principal com testes
├── Pedido.java                  # Modelo do pedido
├── ValidadorPedido.java         # Classe abstrata base para validadores
├── ValidadorEstoque.java        # Valida disponibilidade em estoque
├── ValidadorPreco.java          # Valida limite de preco
└── ValidadorPagamento.java      # Valida confirmacao de pagamento

## Pre-requisitos

- Java JDK 8 ou superior
- IntelliJ IDEA (recomendado) ou qualquer outro editor Java

## Como Executar

### Usando IntelliJ IDEA

1. Abra o IntelliJ IDEA
2. Execute a classe Main (botao verde)

### Usando Terminal

1. Navegue ate a pasta do projeto:
   cd projeto-validacao-pedido

2. Compile o projeto:
   javac *.java

3. Execute o programa:
   java Main

## Exemplo de Saida

=== SISTEMA DE VALIDACAO DE PEDIDOS ===

--- Teste 1: Pedido valido ---
Validando pedido de: Joao Silva
Valor: R$ 150.0
Estoque OK
Valor dentro do limite permitido
Pagamento confirmado
PEDIDO VALIDO! Pedido aprovado com sucesso.

--- Teste 2: Sem estoque ---
Validando pedido de: Maria Souza
Valor: R$ 100.0
ERRO: Produto sem estoque disponivel!
PEDIDO INVALIDO! Verifique os erros acima.

--- Teste 3: Valor invalido (muito baixo) ---
Validando pedido de: Jose Santos
Valor: R$ 5.0
Estoque OK
ERRO: Valor minimo do pedido e R$ 10.0
PEDIDO INVALIDO! Verifique os erros acima.

--- Teste 4: Pagamento nao confirmado ---
Validando pedido de: Ana Costa
Valor: R$ 200.0
Estoque OK
Valor dentro do limite permitido
ERRO: Pagamento nao confirmado!
PEDIDO INVALIDO! Verifique os erros acima.

--- Teste 5: Valor invalido (muito alto) ---
Validando pedido de: Carlos Lima
Valor: R$ 600.0
Estoque OK
ERRO: Valor maximo do pedido e R$ 500.0
PEDIDO INVALIDO! Verifique os erros acima.

## Cenarios de Teste

Teste 1: Pedido valido (R$150, estoque 10, pagamento OK) -> Aprovado
Teste 2: Sem estoque -> Reprovado
Teste 3: Valor muito baixo (R$5) -> Reprovado
Teste 4: Pagamento nao confirmado -> Reprovado
Teste 5: Valor muito alto (R$600) -> Reprovado

## Autor

Desenvolvido como projeto de estudo para disciplina de Analise de Sistemas.

## Data

Junho/2026
