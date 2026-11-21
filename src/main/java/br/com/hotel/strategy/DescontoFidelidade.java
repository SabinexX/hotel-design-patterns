
package br.com.hotel.strategy;

/**
 * Estratégia de desconto para hóspedes
 * participantes do programa de fidelidade.
 *
 * Aplica 15% de desconto sobre o valor original.
 *
 * No padrão Strategy, representa uma
 * ConcreteStrategy (Estratégia Concreta).
 */
public class DescontoFidelidade implements EstrategiaDesconto {

    @Override
    public double calcularValorFinal(double valorOriginal) {

        // Aplica 15% de desconto.
        return valorOriginal * 0.85;
    }
}
