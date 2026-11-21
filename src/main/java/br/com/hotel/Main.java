
package br.com.hotel;

import br.com.hotel.factory.CriadorQuarto;
import br.com.hotel.factory.CriadorQuartoStandard;
import br.com.hotel.factory.CriadorQuartoLuxo;
import br.com.hotel.factory.CriadorSuitePresidencial;

/**
 * Classe principal do Sistema de Gerenciamento de Hotel.
 *
 * Demonstra o funcionamento do padrão Factory Method,
 * utilizado para criar diferentes categorias de quartos.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("   SISTEMA DE GERENCIAMENTO DE HOTEL");
        System.out.println("====================================");

        // Utilizamos o tipo abstrato CriadorQuarto.
        // Cada implementação decide qual quarto criar.

        CriadorQuarto criadorStandard = new CriadorQuartoStandard();
        CriadorQuarto criadorLuxo = new CriadorQuartoLuxo();
        CriadorQuarto criadorPresidencial = new CriadorSuitePresidencial();

        System.out.println("\n--- QUARTO STANDARD ---");
        criadorStandard.apresentarQuarto();

        System.out.println("\n--- QUARTO LUXO ---");
        criadorLuxo.apresentarQuarto();

        System.out.println("\n--- SUÍTE PRESIDENCIAL ---");
        criadorPresidencial.apresentarQuarto();

        System.out.println("\nQuartos criados com sucesso!");
    }
}
