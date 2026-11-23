# 🏨 Sistema de Gerenciamento de Hotel

Projeto acadêmico desenvolvido em **Java** para a disciplina de **Design Patterns**, ministrada pelo professor Venson.

O sistema demonstra o uso de dois padrões de projeto — **Builder** e **Decorator** — em um fluxo simples de reserva de hospedagem. A aplicação é executada no console e não utiliza banco de dados.

## Tecnologias e pré-requisitos

- Java 17 (versão de compatibilidade configurada no Maven)
- JDK 17 ou superior
- Maven
- IntelliJ IDEA (opcional, recomendado para executar o projeto)
- Git e GitHub para versionamento

## Funcionalidades implementadas

- Criação de hóspedes e quartos.
- Construção de reservas com hóspede, quarto, datas de entrada e saída e quantidade de pessoas.
- Validação dos dados obrigatórios da reserva pelo Builder.
- Cálculo da quantidade de diárias e do custo básico da hospedagem.
- Inclusão opcional de café da manhã e estacionamento com Decorator.
- Combinação dinâmica de serviços adicionais sem modificar a classe da hospedagem básica.

## Padrões de projeto

### 1. Builder — Construção de reservas

**Problema:** uma reserva reúne vários dados e precisa ser criada de maneira legível, com validações antes de ser utilizada.

**Solução:** a classe `Reserva` possui a classe interna `Reserva.Builder`, que configura os campos por métodos encadeados e finaliza a construção com `build()`.

**Classes envolvidas:**

- `Hospede`: dados do hóspede.
- `Quarto`: número, categoria e valor da diária.
- `Reserva`: representa a reserva e oferece o Builder.
- `Reserva.Builder`: reúne os dados e valida as informações para criar a reserva.

**Exemplo:**

```java
Reserva reserva = new Reserva.Builder()
        .comHospede(hospede)
        .comQuarto(quarto)
        .comDataEntrada(LocalDate.of(2026, 12, 10))
        .comDataSaida(LocalDate.of(2026, 12, 13))
        .comQuantidadePessoas(2)
        .build();
```

A implementação verifica a presença de hóspede, quarto e datas, se a saída ocorre após a entrada e se a quantidade de pessoas é positiva.

### 2. Decorator — Serviços adicionais da hospedagem

**Problema:** o hotel precisa oferecer serviços opcionais sem criar uma subclasse diferente para cada combinação (por exemplo, hospedagem com café, com estacionamento ou com ambos).

**Solução:** todas as modalidades implementam a interface `Hospedagem`. Os Decorators envolvem outra `Hospedagem` e acrescentam valor e descrição, preservando os serviços já adicionados.

| Classe | Papel no padrão | Responsabilidade |
|---|---|---|
| `Hospedagem` | Component | Define `calcularCusto()` e `getDescricao()` |
| `HospedagemBasica` | ConcreteComponent | Calcula diárias × valor do quarto |
| `HospedagemDecorator` | Decorator | Mantém e delega para uma `Hospedagem` envolvida |
| `CafeDaManhaDecorator` | ConcreteDecorator | Acrescenta R$ 30,00 por diária |
| `EstacionamentoDecorator` | ConcreteDecorator | Acrescenta R$ 20,00 por diária |

**Exemplo:**

```java
Hospedagem hospedagem = new HospedagemBasica(reserva);
hospedagem = new CafeDaManhaDecorator(hospedagem, reserva.getQuantidadeDiarias());
hospedagem = new EstacionamentoDecorator(hospedagem, reserva.getQuantidadeDiarias());

System.out.println(hospedagem.getDescricao());
System.out.println(hospedagem.calcularCusto());
```

A quantidade de diárias é passada a cada Decorator, de acordo com a implementação atual.

### Integração entre os padrões

O **Builder** cria a `Reserva`. Em seguida, a `HospedagemBasica` utiliza essa reserva para calcular o valor original, e os **Decorators** adicionam serviços opcionais. Assim, construção de objetos e composição de serviços ficam em responsabilidades separadas.

## Estrutura principal do projeto

```text
hotel-design-patterns/
├── src/
│   └── main/
│       └── java/
│           └── br/com/hotel/
│               ├── model/
│               │   ├── Hospede.java
│               │   ├── Quarto.java
│               │   └── Reserva.java
│               ├── decorator/
│               │   ├── Hospedagem.java
│               │   ├── HospedagemBasica.java
│               │   ├── HospedagemDecorator.java
│               │   ├── CafeDaManhaDecorator.java
│               │   └── EstacionamentoDecorator.java
│               └── Main.java
├── pom.xml
├── .gitignore
└── README.md
```

*Árvore resumida dos arquivos principais; arquivos auxiliares de documentação de pacotes podem também existir.*

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SabinexX/hotel-design-patterns.git
   ```
2. Abra o diretório `hotel-design-patterns` no IntelliJ IDEA.
3. Aguarde a importação/sincronização do projeto Maven.
4. Abra `src/main/java/br/com/hotel/Main.java`.
5. Execute o método `main()` pela IDE.

A aplicação apresenta a reserva de demonstração e calcula o valor da hospedagem com diferentes combinações de adicionais.

## Exemplo de execução e verificação manual

O cenário utilizado em `Main.java` cria uma reserva de **10/12/2026 a 13/12/2026** (3 diárias), no quarto **Luxo**, com diária de **R$ 300,00**.

| Cenário | Cálculo | Valor esperado e observado |
|---|---|---:|
| Sem adicionais | 3 × R$ 300,00 | R$ 900,00 |
| Somente café da manhã | R$ 900,00 + 3 × R$ 30,00 | R$ 990,00 |
| Somente estacionamento | R$ 900,00 + 3 × R$ 20,00 | R$ 960,00 |
| Café da manhã e estacionamento | R$ 900,00 + R$ 90,00 + R$ 60,00 | R$ 1.050,00 |

Os quatro cenários foram executados manualmente no console, com os valores esperados, e a aplicação terminou com **exit code 0**. Isso não substitui testes automatizados, que não são apresentados aqui como implementados.

## Histórico de desenvolvimento e refatoração

O repositório utiliza **Issues, branches, commits e Pull Requests** para registrar as etapas do trabalho.

- **Issue #1 / Pull Request #2:** estrutura inicial e configuração do projeto.
- **Issues #4 e #6:** implementações iniciais de Factory Method e Strategy.
- **Issue #8:** adequação do projeto aos padrões exigidos oficialmente.
- **Issue #9:** implementação do Builder, integrada à branch principal.
- **Issue #11:** implementação do Decorator e integração à classe `Main` (commit `93bee9c` na branch `feat/decorator-servicos`; integração à `main` ainda depende do Pull Request).

**Registro da correção de rumo:** a primeira versão adotou Factory Method e Strategy. Após a conferência das orientações oficiais da atividade, essas implementações foram retiradas da versão atual, e o projeto foi refatorado para utilizar **Builder e Decorator**. O histórico dos commits e Pull Requests anteriores foi preservado para documentar a evolução do trabalho.

## Uso de inteligência artificial

Foi utilizado **ChatGPT, modelo GPT-6 (OpenAI)**, como apoio **na Parte 1** do projeto: interpretação e organização dos requisitos, planejamento das Issues e branches, explicações sobre Builder e Decorator, sugestões de código Java, apoio à integração dos padrões, elaboração de cenários de teste manual e redação/revisão da documentação. As saídas foram incorporadas e executadas no ambiente de desenvolvimento, com conferência manual dos resultados.

**As próximas etapas deverão respeitar as regras específicas da disciplina.** Este registro não declara uso de IA em etapas nas quais ele seja proibido.



## Integrantes e contribuições

| Integrante | Contribuições |
|---|---|
| Bruno Sabino | Configuração do projeto, organização do GitHub, implementação dos padrões Builder e Decorator, integração na Main, testes e documentação, com auxílio de IA declarado neste README |
| Filipe Belmiro | Participação ainda pendente |
| Rafael Marques | Participação ainda pendente |

As contribuições individuais serão atualizadas conforme
as atividades forem realizadas e registradas em commits.
