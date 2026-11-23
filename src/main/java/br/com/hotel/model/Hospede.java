package br.com.hotel.model;

/**
 * Representa um hóspede cadastrado no hotel.
 *
 * Esta classe armazena as informações básicas
 * necessárias para associar um hóspede a uma reserva.
 */
public class Hospede {

    private final String nome;
    private final String cpf;
    private final String telefone;

    /**
     * Construtor responsável por cadastrar
     * as informações do hóspede.
     */
    public Hospede(String nome, String cpf, String telefone) {

        // Valida se o nome foi informado.
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do hóspede é obrigatório."
            );
        }

        // Valida se o CPF foi informado.
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException(
                    "O CPF do hóspede é obrigatório."
            );
        }

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}
