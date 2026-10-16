# Controle de Altura

Programa de console em Java que cadastra 15 pessoas (nome e altura) e permite consultar os registros por faixa de altura, além de calcular a média das alturas.

## Funcionalidades

O programa exibe um menu com as seguintes opções:

1. Cadastrar os 15 registros
2. Listar pessoas com 1.50 m ou menos
3. Listar pessoas com mais de 1.50 m
4. Listar pessoas com mais de 1.50 m e menos de 2.00 m
5. Exibir todos os registros com a média das alturas
6. Sair

As opções 2 a 5 só funcionam depois que o cadastro (opção 1) for feito.

## Validações

- Opção do menu inválida (letras ou números fora do intervalo) não derruba o programa
- A altura precisa ser um número maior que zero; caso contrário, o programa pergunta de novo

## Estrutura do projeto

```
controle-altura/
├── .gitignore
├── README.md
└── src/
    └── controle/
        └── altura/
            ├── Main.java
            └── Pessoa.java
```

- `Pessoa.java`: classe com `nome` e `altura`, construtor, getters e setters
- `Main.java`: menu, cadastro, filtros por altura e cálculo da média

## Como executar

Requisito: JDK instalado (Java 8 ou superior).

```
javac -d out src/controle/altura/*.java
java -cp out controle.altura.Main
```

> **Atenção:** digite as alturas com **ponto** (exemplo: `1.75`), não com vírgula.

## Exemplo de uso

```
======MENU======

1.Cadastrar os 15 registros.
...

Escolha uma opção:
1

Cadastro 1
Nome:
Maria
Altura (ex: 1.75):
1.62
```

## Conceitos praticados

- Programação orientada a objetos (classe, construtor, encapsulamento)
- Arrays de objetos
- Métodos estáticos
- Leitura de dados com `Scanner` e validação de entrada
- Estruturas de controle (`do-while`, `switch`, `for`)

## Autor

Davi Marinho