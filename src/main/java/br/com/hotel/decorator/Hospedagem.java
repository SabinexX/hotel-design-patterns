package br.com.hotel.decorator;

/**
 * Interface principal do padrão Decorator.
 *
 * Representa o Component, definindo o contrato
 * utilizado pela hospedagem básica e pelos
 * serviços adicionais.
 */
public interface Hospedagem {

    // Calcula o custo total da hospedagem.
    double calcularCusto();

    // Retorna a descrição da hospedagem.
    String getDescricao();
}
