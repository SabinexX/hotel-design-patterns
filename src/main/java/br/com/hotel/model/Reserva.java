
package br.com.hotel.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa uma reserva de hospedagem.
 *
 * Utiliza o padrão Builder para construir
 * objetos de forma organizada e validada.
 */
public class Reserva {

    private final Hospede hospede;
    private final Quarto quarto;
    private final LocalDate dataEntrada;
    private final LocalDate dataSaida;
    private final int quantidadePessoas;

    // Construtor privado: a criação acontece pelo Builder.
    private Reserva(Builder builder) {
        this.hospede = builder.hospede;
        this.quarto = builder.quarto;
        this.dataEntrada = builder.dataEntrada;
        this.dataSaida = builder.dataSaida;
        this.quantidadePessoas = builder.quantidadePessoas;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    /**
     * Calcula a quantidade de diárias da reserva.
     */
    public long getQuantidadeDiarias() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }

    /**
     * Builder responsável pela construção de reservas.
     */
    public static class Builder {

        private Hospede hospede;
        private Quarto quarto;
        private LocalDate dataEntrada;
        private LocalDate dataSaida;
        private int quantidadePessoas = 1;

        public Builder comHospede(Hospede hospede) {
            this.hospede = hospede;
            return this;
        }

        public Builder comQuarto(Quarto quarto) {
            this.quarto = quarto;
            return this;
        }

        public Builder comDataEntrada(LocalDate dataEntrada) {
            this.dataEntrada = dataEntrada;
            return this;
        }

        public Builder comDataSaida(LocalDate dataSaida) {
            this.dataSaida = dataSaida;
            return this;
        }

        public Builder comQuantidadePessoas(int quantidadePessoas) {
            this.quantidadePessoas = quantidadePessoas;
            return this;
        }

        /**
         * Valida os campos e constrói a reserva.
         */
        public Reserva build() {

            if (hospede == null || quarto == null) {
                throw new IllegalStateException(
                        "Hóspede e quarto são obrigatórios."
                );
            }

            if (dataEntrada == null || dataSaida == null) {
                throw new IllegalStateException(
                        "As datas da reserva são obrigatórias."
                );
            }

            if (!dataSaida.isAfter(dataEntrada)) {
                throw new IllegalArgumentException(
                        "A saída deve ser posterior à entrada."
                );
            }

            if (quantidadePessoas <= 0) {
                throw new IllegalArgumentException(
                        "A quantidade de pessoas deve ser positiva."
                );
            }

            return new Reserva(this);
        }
    }
}
