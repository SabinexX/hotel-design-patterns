package br.com.hotel.model;

/**
 * Classe abstrata que representa um quarto do hotel.
 *
 * Define as características e comportamentos comuns
 * a todos os tipos de quartos.
 *
 * No padrão Factory Method, esta classe representa
 * o Product (Produto).
 */
public abstract class Quarto {

    // Retorna a categoria do quarto
    public abstract String getCategoria();

    // Retorna o valor de uma diária
    public abstract double getValorDiaria();

    /**
     * Exibe as informações do quarto.
     *
     * Este método pode ser utilizado por qualquer
     * implementação concreta de Quarto.
     */
    public void exibirInformacoes() {
        System.out.println("Categoria: " + getCategoria());

        System.out.printf(
                "Valor da diária: R$ %.2f%n",
                getValorDiaria()
        );
    }
}
