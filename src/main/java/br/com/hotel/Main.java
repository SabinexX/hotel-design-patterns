
package br.com.hotel;

import br.com.hotel.model.Hospede;
import br.com.hotel.model.Quarto;
import br.com.hotel.model.Reserva;

import java.time.LocalDate;

/**
 * Classe principal do Sistema de Gerenciamento de Hotel.
 *
 * Demonstra o padrão Builder na construção de reservas.
 * O Decorator será integrado na próxima etapa.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("  SISTEMA DE GERENCIAMENTO DE HOTEL ");
        System.out.println("====================================");

        // 1. Cadastra um hóspede fictício para demonstração.
        Hospede hospede = new Hospede(
                "João Silva",
                "12345678900",
                "(48) 99999-9999"
        );

        // 2. Define o quarto escolhido.
        Quarto quarto = new Quarto(
                101,
                "Luxo",
                300.00
        );

        // 3. Utiliza o Builder para construir a reserva.
        Reserva reserva = new Reserva.Builder()
                .comHospede(hospede)
                .comQuarto(quarto)
                .comDataEntrada(LocalDate.of(2026, 12, 10))
                .comDataSaida(LocalDate.of(2026, 12, 13))
                .comQuantidadePessoas(2)
                .build();

        // 4. Apresenta as informações da reserva.
        System.out.println("\n===== RESERVA CRIADA =====");

        System.out.println("Hóspede: " + reserva.getHospede().getNome());
        System.out.println("Quarto: " + reserva.getQuarto().getNumero());
        System.out.println("Categoria: " + reserva.getQuarto().getCategoria());
        System.out.println("Entrada: " + reserva.getDataEntrada());
        System.out.println("Saída: " + reserva.getDataSaida());
        System.out.println("Pessoas: " + reserva.getQuantidadePessoas());
        System.out.println("Diárias: " + reserva.getQuantidadeDiarias());

        double valorTotal = reserva.getQuantidadeDiarias()
                * reserva.getQuarto().getValorDiaria();

        System.out.printf("Valor da hospedagem: R$ %.2f%n", valorTotal);

        System.out.println("\nReserva construída com sucesso!");
    }
}
