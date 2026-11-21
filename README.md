# 🏨 Sistema de Gerenciamento de Hotel

Projeto desenvolvido em Java para a disciplina de **Design Patterns**, ministrada pelo professor Venson.

O objetivo é construir um sistema de gerenciamento de hotel, aplicando padrões de projeto para melhorar a organização, a reutilização e a manutenção do código.

## Design Patterns

### Strategy — Planejado

Responsável pela implementação de diferentes políticas de desconto nas reservas.

Estratégias previstas:
- Sem desconto
- Desconto VIP
- Desconto fidelidade

### Factory Method — Planejado

Responsável pela criação de diferentes categorias de quartos, utilizando classes criadoras especializadas.

Categorias previstas:
- Quarto Standard
- Quarto Luxo
- Suíte Presidencial

## Tecnologias

- Java 17
- Maven
- IntelliJ IDEA
- Git e GitHub

## Estrutura do projeto

```text
src/main/java/br/com/hotel/
├── factory/
├── model/
├── service/
├── strategy/
└── Main.java
```

## Funcionalidades previstas

- Cadastro de hóspedes
- Criação de diferentes tipos de quartos
- Gerenciamento de reservas
- Cálculo do valor das hospedagens
- Aplicação de políticas de desconto
- Interface de interação pelo terminal

## Histórico de desenvolvimento

### Etapa 1 — Configuração inicial

**Issue #1 | Pull Request #2**

- [x] Configuração do Maven
- [x] Estrutura de diretórios Java
- [x] Criação da classe Main
- [x] Organização dos pacotes
- [x] Configuração do .gitignore
- [x] Teste inicial da aplicação

### Etapa 2 — Factory Method

**Próxima implementação**

- [ ] Criar abstração de quarto
- [ ] Implementar categorias de quartos
- [ ] Criar a hierarquia de criadores
- [ ] Testar a criação dos quartos

### Etapa 3 — Strategy

**Implementação futura**

- [ ] Criar interface de estratégia
- [ ] Implementar regras de desconto
- [ ] Integrar estratégias às reservas
- [ ] Testar os cálculos

## Execução

O projeto utiliza Maven e pode ser aberto no IntelliJ IDEA.

A aplicação é iniciada pela classe `Main.java`.

## Organização e versionamento

O desenvolvimento é organizado por meio de Issues, branches específicas e Pull Requests.

Cada funcionalidade é implementada separadamente, permitindo acompanhar a evolução do projeto e identificar as contribuições dos integrantes.

## Uso de inteligência artificial

Foi utilizado auxílio de inteligência artificial no planejamento inicial, na organização do repositório e na configuração da estrutura do projeto. O uso será documentado conforme as regras estabelecidas para cada etapa da disciplina.