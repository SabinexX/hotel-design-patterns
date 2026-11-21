package br.com.hotel.strategy;

/**
 * Estratégia de desconto para hóspedes VIP.
 *
 * Aplica 10% de desconto sobre o valor original.
 *
 * No padrão Strategy, representa uma
 * ConcreteStrategy (Estratégia Concreta).
 */
public class DescontoVIP implements EstrategiaDesconto {

    @Override
    public double calcularValorFinal(double valorOriginal) {

        // Aplica 10% de desconto.
        return valorOriginal * 0.90;
    }
}
