
package br.com.hotel;

import br.com.hotel.factory.CriadorQuarto;
import br.com.hotel.factory.CriadorQuartoLuxo;
import br.com.hotel.factory.CriadorQuartoStandard;
import br.com.hotel.factory.CriadorSuitePresidencial;
import br.com.hotel.model.Quarto;
import br.com.hotel.service.CalculadoraReserva;
import br.com.hotel.strategy.DescontoNormal;
import br.com.hotel.strategy.DescontoVIP;
import br.com.hotel.strategy.DescontoFidelidade;

/**
 * Classe principal do Sistema de Gerenciamento de Hotel.
 *
 * Demonstra a utilização conjunta dos padrões:
 *
 * Factory Method: criação de diferentes tipos de quartos.
 * Strategy: aplicação de diferentes políticas de desconto.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("   SISTEMA DE GERENCIAMENTO DE HOTEL");
        System.out.println("====================================");

        // ===== FACTORY METHOD =====

        System.out.println("\n===== TIPOS DE QUARTOS =====");

        CriadorQuarto criadorStandard = new CriadorQuartoStandard();
        CriadorQuarto criadorLuxo = new CriadorQuartoLuxo();
        CriadorQuarto criadorPresidencial = new CriadorSuitePresidencial();

        System.out.println("\n--- QUARTO STANDARD ---");
        criadorStandard.apresentarQuarto();

        System.out.println("\n--- QUARTO LUXO ---");
        criadorLuxo.apresentarQuarto();

        System.out.println("\n--- SUÍTE PRESIDENCIAL ---");
        criadorPresidencial.apresentarQuarto();

        // ===== STRATEGY =====

        System.out.println("\n===== SIMULAÇÃO DE RESERVA =====");

        // O Factory Method cria o quarto utilizado na reserva.
        Quarto quartoReservado = criadorLuxo.criarQuarto();

        int quantidadeDiarias = 3;

        double valorOriginal =
                quartoReservado.getValorDiaria() * quantidadeDiarias;

        System.out.println("Quarto: " + quartoReservado.getCategoria());
        System.out.println("Quantidade de diárias: " + quantidadeDiarias);
        System.out.printf("Valor original: R$ %.2f%n", valorOriginal);

        // Inicialmente, a reserva utiliza a estratégia normal.
        CalculadoraReserva calculadora =
                new CalculadoraReserva(new DescontoNormal());

        double totalNormal = calculadora.calcularTotal(
                quartoReservado.getValorDiaria(), quantidadeDiarias
        );

        // Altera a estratégia para desconto VIP.
        calculadora.setEstrategiaDesconto(new DescontoVIP());

        double totalVIP = calculadora.calcularTotal(
                quartoReservado.getValorDiaria(), quantidadeDiarias
        );

        // Altera novamente a estratégia para Fidelidade.
        calculadora.setEstrategiaDesconto(new DescontoFidelidade());

        double totalFidelidade = calculadora.calcularTotal(
                quartoReservado.getValorDiaria(), quantidadeDiarias
        );

        System.out.println("\n--- VALORES COM DESCONTO ---");

        System.out.printf("Normal (0%%): R$ %.2f%n", totalNormal);
        System.out.printf("VIP (10%%): R$ %.2f%n", totalVIP);
        System.out.printf("Fidelidade (15%%): R$ %.2f%n", totalFidelidade);

        System.out.println("\nSimulação concluída com sucesso!");
    }
}
