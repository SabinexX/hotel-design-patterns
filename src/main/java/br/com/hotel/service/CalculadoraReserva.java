
package br.com.hotel.service;

import br.com.hotel.strategy.EstrategiaDesconto;

/**
 * Contexto do padrão Strategy.
 *
 * Responsável por calcular o valor final de uma
 * reserva utilizando uma estratégia de desconto.
 *
 * A estratégia pode ser alterada durante a execução
 * sem modificar a lógica desta classe.
 */
public class CalculadoraReserva {

    // Referência à interface, não às classes concretas.
    private EstrategiaDesconto estrategiaDesconto;

    /**
     * Recebe a estratégia inicial pelo construtor.
     */
    public CalculadoraReserva(EstrategiaDesconto estrategiaDesconto) {
        this.estrategiaDesconto = estrategiaDesconto;
    }

    /**
     * Permite trocar a estratégia durante a execução.
     */
    public void setEstrategiaDesconto(EstrategiaDesconto estrategiaDesconto) {
        this.estrategiaDesconto = estrategiaDesconto;
    }

    /**
     * Calcula o valor da hospedagem e aplica a
     * estratégia de desconto selecionada.
     *
     * @param valorDiaria preço de uma diária
     * @param quantidadeDiarias quantidade de noites
     * @return valor final da hospedagem
     */
    public double calcularTotal(double valorDiaria, int quantidadeDiarias) {

        // Calcula o valor da hospedagem sem descontos.
        double valorOriginal = valorDiaria * quantidadeDiarias;

        // Delega o cálculo à estratégia selecionada.
        return estrategiaDesconto.calcularValorFinal(valorOriginal);
    }
}
