
package br.com.hotel;

import br.com.hotel.model.Hospede;
import br.com.hotel.model.Quarto;
import br.com.hotel.model.Reserva;

import br.com.hotel.decorator.Hospedagem;
import br.com.hotel.decorator.HospedagemBasica;
import br.com.hotel.decorator.CafeDaManhaDecorator;
import br.com.hotel.decorator.EstacionamentoDecorator;

import java.time.LocalDate;

/**
 * Classe principal do Sistema de Gerenciamento de Hotel.
 *
 * Demonstra os dois padrões exigidos:
 *
 * Builder: construção de uma reserva.
 * Decorator: inclusão de serviços adicionais.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("  SISTEMA DE GERENCIAMENTO DE HOTEL ");
        System.out.println("====================================");

        // ===== 1. ENTIDADES PRINCIPAIS =====

        // Cria um hóspede fictício.
        Hospede hospede = new Hospede(
                "João Silva",
                "12345678900",
                "(48) 99999-9999"
        );

        // Define o quarto e o valor de sua diária.
        Quarto quarto = new Quarto(101, "Luxo", 300.00);

        // ===== 2. BUILDER =====

        // Constrói a reserva e valida os campos obrigatórios.
        Reserva reserva = new Reserva.Builder()
                .comHospede(hospede)
                .comQuarto(quarto)
                .comDataEntrada(LocalDate.of(2026, 12, 10))
                .comDataSaida(LocalDate.of(2026, 12, 13))
                .comQuantidadePessoas(2)
                .build();

        System.out.println("\n===== RESERVA CRIADA (BUILDER) =====");
        System.out.println("Hóspede: " + reserva.getHospede().getNome());
        System.out.println("Quarto: " + reserva.getQuarto().getNumero());
        System.out.println("Categoria: " + reserva.getQuarto().getCategoria());
        System.out.println("Entrada: " + reserva.getDataEntrada());
        System.out.println("Saída: " + reserva.getDataSaida());
        System.out.println("Pessoas: " + reserva.getQuantidadePessoas());
        System.out.println("Diárias: " + reserva.getQuantidadeDiarias());

        // ===== 3. DECORATOR =====

        // Hospedagem original, sem serviços adicionais.
        Hospedagem hospedagem = new HospedagemBasica(reserva);

        System.out.println("\n===== HOSPEDAGEM BÁSICA =====");
        System.out.println(hospedagem.getDescricao());
        System.out.printf(
                "Total: R$ %.2f%n",
                hospedagem.calcularCusto()
        );

        // Adiciona café da manhã à hospedagem.
        hospedagem = new CafeDaManhaDecorator(
                hospedagem,
                reserva.getQuantidadeDiarias()
        );

        System.out.println("\n===== COM CAFÉ DA MANHÃ =====");
        System.out.println(hospedagem.getDescricao());
        System.out.printf(
                "Total: R$ %.2f%n",
                hospedagem.calcularCusto()
        );

        // Adiciona estacionamento, preservando o café da manhã.
        hospedagem = new EstacionamentoDecorator(
                hospedagem,
                reserva.getQuantidadeDiarias()
        );

        System.out.println("\n===== COM TODOS OS ADICIONAIS =====");
        System.out.println(hospedagem.getDescricao());
        System.out.printf(
                "Total: R$ %.2f%n",
                hospedagem.calcularCusto()
        );


        // ===== 4. TESTE DE ESTACIONAMENTO ISOLADO =====

        // Criamos uma nova hospedagem básica para garantir
        // que o café da manhã não esteja incluído.
        Hospedagem somenteEstacionamento =
                new EstacionamentoDecorator(
                        new HospedagemBasica(reserva),
                        reserva.getQuantidadeDiarias()
                );

        System.out.println("\n===== SOMENTE ESTACIONAMENTO =====");
        System.out.println(somenteEstacionamento.getDescricao());

        System.out.printf(
                "Total: R$ %.2f%n",
                somenteEstacionamento.calcularCusto()
        );


        System.out.println("\nReserva finalizada com sucesso!");
    }
}
