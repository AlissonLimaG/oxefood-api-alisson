package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;

    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Número de RG não pode ser branco ou nulo")
    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "O número do celular não pode ser branco ou nulo")
    private String foneCelular;

    private String foneFixo;

    private Integer qtdEntregasRealizadas;

    @NotNull(message = "O valor não pode ser nulo")
    private Double valorFrete;

    @NotBlank(message = "A rua do endereço não pode estar em branco.")
    private String enderecoRua;

    private String enderecoComplemento;

    @NotBlank(message = "O número do endereço não pode estar em branco.")
    private String enderecoNumero;

    @NotBlank(message = "O bairro do endereço não pode estar em branco.")
    private String enderecoBairro;

    @NotBlank(message = "A cidade do endereço não pode estar em branco.")
    private String enderecoCidade;

    @NotBlank(message = "O CEP do endereço não pode estar em branco.")
    private String enderecoCep;

    @NotBlank(message = "O estado (UF) do endereço não pode estar em branco.")
    private String enderecoUf;

    private Boolean ativo;

    public Entregador build() {

        // método do lombok definido na classe Entregador usando @Builder
        return Entregador.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .valorFrete(valorFrete)
                .enderecoRua(enderecoRua)
                .enderecoComplemento(enderecoComplemento)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidade(enderecoCidade)
                .enderecoCep(enderecoCep)
                .enderecoUf(enderecoUf)
                .ativo(ativo)
                .build();
    }
}
