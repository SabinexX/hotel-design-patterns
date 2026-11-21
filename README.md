# 🏨 Sistema de Gerenciamento de Hotel

Projeto acadêmico desenvolvido em **Java** para a disciplina de **Design Patterns**, ministrada pelo professor Venson.

O objetivo é demonstrar a aplicação prática de padrões de projeto em um sistema de gerenciamento de hotel, utilizando boas práticas de programação orientada a objetos, como abstração, herança, polimorfismo e separação de responsabilidades.

Nesta primeira etapa, foram implementados dois padrões de projeto: **Factory Method** e **Strategy**.

## Tecnologias utilizadas

- Java 17 (compatibilidade configurada no Maven)
- Maven
- IntelliJ IDEA
- Git e GitHub
- Programação Orientada a Objetos (POO)

## Design Patterns implementados

### 1. Factory Method — Criação de quartos

**Status: Implementado e testado**

O padrão Factory Method é responsável pela criação de diferentes categorias de quartos por meio de classes criadoras especializadas.

Categorias disponíveis:

| Categoria | Valor da diária |
|---|---:|
| Standard | R$ 150,00 |
| Luxo | R$ 300,00 |
| Suíte Presidencial | R$ 600,00 |

**Classes utilizadas:**

- `Quarto` — Product (produto abstrato).
- `QuartoStandard` — ConcreteProduct.
- `QuartoLuxo` — ConcreteProduct.
- `SuitePresidencial` — ConcreteProduct.
- `CriadorQuarto` — Creator (criador abstrato).
- `CriadorQuartoStandard` — ConcreteCreator.
- `CriadorQuartoLuxo` — ConcreteCreator.
- `CriadorSuitePresidencial` — ConcreteCreator.

A classe abstrata `CriadorQuarto` define o método `criarQuarto()`, que é implementado pelas subclasses concretas.

Cada criador determina qual tipo de quarto será instanciado.

### 2. Strategy — Políticas de desconto

**Status: Implementado e testado**

O padrão Strategy permite aplicar diferentes políticas de desconto ao valor das hospedagens sem alterar a lógica principal de cálculo.

Estratégias disponíveis:

| Estratégia | Desconto |
|---|---:|
| Normal | 0% |
| VIP | 10% |
| Fidelidade | 15% |

**Classes utilizadas:**

- `EstrategiaDesconto` — Strategy (interface).
- `DescontoNormal` — ConcreteStrategy.
- `DescontoVIP` — ConcreteStrategy.
- `DescontoFidelidade` — ConcreteStrategy.
- `CalculadoraReserva` — Context.

A classe `CalculadoraReserva` recebe uma implementação de `EstrategiaDesconto` e delega a ela o cálculo do valor final.

A estratégia pode ser alterada durante a execução por meio do método `setEstrategiaDesconto()`.

## Justificativa da escolha dos Design Patterns

Os padrões Factory Method e Strategy foram escolhidos para resolver dois problemas diferentes no gerenciamento de um hotel: **a criação de quartos e o cálculo de descontos nas hospedagens**.

### Factory Method — Problema e solução

**Problema identificado:**

O hotel oferece diferentes categorias de quartos, cada uma com características e valores próprios.

Criar esses objetos diretamente em vários pontos do sistema aumentaria a dependência das classes concretas, dificultando futuras alterações e extensões.

**Solução adotada:**

Utilizamos o Factory Method para delegar a criação dos quartos a classes criadoras especializadas.

A classe abstrata `CriadorQuarto` define o contrato de criação, enquanto cada subclasse implementa o método responsável por instanciar sua categoria correspondente.

**Benefícios:**

- Separa a lógica de criação dos quartos de sua utilização.
- Reduz o acoplamento entre o código cliente e os produtos concretos.
- Permite adicionar novas categorias com novos criadores.
- Favorece a reutilização de código e o polimorfismo.

### Strategy — Problema e solução

**Problema identificado:**

Um hotel pode oferecer diferentes políticas de desconto dependendo do perfil do hóspede.

Caso todas as regras fossem implementadas diretamente na classe responsável pelo cálculo, o sistema poderia acumular estruturas condicionais e tornar-se mais difícil de manter.

**Solução adotada:**

Utilizamos o Strategy para encapsular cada política de desconto em uma classe independente.

A interface `EstrategiaDesconto` define um comportamento comum, implementado pelas classes `DescontoNormal`, `DescontoVIP` e `DescontoFidelidade`.

A classe `CalculadoraReserva` utiliza a interface para executar os cálculos, independentemente da estratégia concreta selecionada.

**Benefícios:**

- Permite trocar a política de desconto durante a execução.
- Evita concentrar diferentes algoritmos de desconto em uma única classe.
- Facilita a criação de novas estratégias.
- Reduz o acoplamento entre o cálculo da hospedagem e as políticas de desconto.

### Integração entre os padrões

Os padrões possuem responsabilidades diferentes, mas complementares.

O Factory Method é responsável pela criação dos quartos, enquanto o Strategy calcula o valor da hospedagem de acordo com a política de desconto selecionada.

**Exemplo:**

1. O Factory Method cria um quarto Luxo com diária de R$ 300,00.
2. Uma hospedagem de três diárias totaliza R$ 900,00.
3. O Strategy aplica a política de desconto VIP de 10%.
4. O valor final da hospedagem é R$ 810,00.

Essa separação permite modificar as categorias de quartos e as políticas de desconto de forma independente.

## Estrutura do projeto

```text
hotel-design-patterns/
├── src/
│   └── main/
│       └── java/
│           └── br/
│               └── com/
│                   └── hotel/
│                       ├── factory/
│                       │   ├── CriadorQuarto.java
│                       │   ├── CriadorQuartoStandard.java
│                       │   ├── CriadorQuartoLuxo.java
│                       │   └── CriadorSuitePresidencial.java
│                       │
│                       ├── model/
│                       │   ├── Quarto.java
│                       │   ├── QuartoStandard.java
│                       │   ├── QuartoLuxo.java
│                       │   └── SuitePresidencial.java
│                       │
│                       ├── strategy/
│                       │   ├── EstrategiaDesconto.java
│                       │   ├── DescontoNormal.java
│                       │   ├── DescontoVIP.java
│                       │   └── DescontoFidelidade.java
│                       │
│                       ├── service/
│                       │   └── CalculadoraReserva.java
│                       │
│                       └── Main.java
│
├── pom.xml
├── .gitignore
└── README.md
```

Os pacotes `factory`, `model`, `strategy` e `service` também possuem arquivos `package-info.java` para documentar suas responsabilidades.

## Funcionalidades implementadas

- [x] Criação de quartos Standard, Luxo e Suíte Presidencial.
- [x] Definição de valores de diária por categoria.
- [x] Implementação do Factory Method.
- [x] Implementação do Strategy.
- [x] Cálculo do valor de hospedagens.
- [x] Aplicação de descontos Normal, VIP e Fidelidade.
- [x] Alteração dinâmica da estratégia de desconto.
- [x] Demonstração integrada dos dois padrões no terminal.

### Funcionalidades previstas para futuras extensões

- [ ] Cadastro de hóspedes.
- [ ] Registro e gerenciamento de reservas.
- [ ] Controle de disponibilidade de quartos.
- [ ] Check-in e check-out.
- [ ] Menu interativo para utilização do sistema.

## Exemplo de execução

Ao executar a aplicação, são apresentados os tipos de quartos e uma simulação de hospedagem.

```text
===== TIPOS DE QUARTOS =====

--- QUARTO STANDARD ---
Categoria: Standard
Valor da diária: R$ 150,00

--- QUARTO LUXO ---
Categoria: Luxo
Valor da diária: R$ 300,00

--- SUÍTE PRESIDENCIAL ---
Categoria: Suíte Presidencial
Valor da diária: R$ 600,00

===== SIMULAÇÃO DE RESERVA =====
Quarto: Luxo
Quantidade de diárias: 3
Valor original: R$ 900,00

--- VALORES COM DESCONTO ---
Normal (0%): R$ 900,00
VIP (10%): R$ 810,00
Fidelidade (15%): R$ 765,00

Simulação concluída com sucesso!
```

## Como executar

### Pré-requisitos

- JDK 17 ou superior, com suporte à compilação para Java 17.
- IntelliJ IDEA com suporte ao Maven.

### Execução pelo IntelliJ IDEA

1. Clone o repositório do GitHub.
2. Abra a pasta do projeto no IntelliJ IDEA.
3. Aguarde a sincronização do Maven.
4. Abra a classe `Main.java`.
5. Execute o método `main()`.

A aplicação apresenta os quartos disponíveis e demonstra os cálculos das políticas de desconto.

## Histórico de desenvolvimento

O projeto é organizado por meio de Issues, branches e Pull Requests, permitindo acompanhar as implementações e as contribuições realizadas.

### Etapa 1 — Configuração inicial

**Issue #1 | Pull Request #2**

- [x] Configuração do Maven.
- [x] Criação da estrutura de diretórios Java.
- [x] Implementação inicial da classe `Main`.
- [x] Organização dos pacotes.
- [x] Configuração do `.gitignore`.
- [x] Teste inicial da aplicação.

### Etapa 2 — Factory Method

**Issue #4 — Implementação concluída**

- [x] Criar a abstração `Quarto`.
- [x] Implementar as três categorias de quartos.
- [x] Criar a hierarquia de criadores.
- [x] Implementar o método `criarQuarto()`.
- [x] Demonstrar a criação dos quartos na classe `Main`.
- [x] Testar a execução das três categorias.
- [x] Integrar a implementação à branch principal.

### Etapa 3 — Strategy

**Issue #6 — Implementação concluída localmente**

- [x] Criar a interface `EstrategiaDesconto`.
- [x] Implementar as estratégias Normal, VIP e Fidelidade.
- [x] Criar a classe `CalculadoraReserva`.
- [x] Permitir a alteração da estratégia durante a execução.
- [x] Integrar Strategy e Factory Method na classe `Main`.
- [x] Testar os cálculos das três estratégias.
- [x] Documentar a justificativa dos padrões.
- [ ] Integrar o Pull Request à branch principal.

## Organização e versionamento

Cada funcionalidade é desenvolvida em uma branch específica, vinculada à respectiva Issue.

Após a implementação, as alterações são registradas em commits e submetidas por meio de Pull Requests.

Esse processo permite identificar a autoria das contribuições, revisar as alterações e acompanhar a evolução do sistema.

## Uso de inteligência artificial

Foi utilizado auxílio de inteligência artificial no planejamento do projeto, na organização do repositório, na elaboração e explicação das implementações dos padrões Factory Method e Strategy, nos exemplos de código, nos testes manuais e na documentação.

A utilização de inteligência artificial será declarada conforme as regras estabelecidas pelo professor para cada etapa do trabalho.