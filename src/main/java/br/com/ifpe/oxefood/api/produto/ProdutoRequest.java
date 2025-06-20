package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotNull(message = "Deve informar a categoria")
    private Long idCategoria;

    @NotBlank(message = "Preencha o código")
    private String codigo;

    @NotBlank(message = "Preencha o título")
    private String titulo;

    @NotBlank(message = "Preencha a descrição")
    @Size(min = 10, max = 200, message = "A descrição deve ter entre 10 e 200 caracteres")
    private String descricao;

    @NotNull(message = "O valor não pode ser nulo")
    @NegativeOrZero(message = "O valor não pode ser negativo ou Zero")
    private Double valorUnitario;

    @NegativeOrZero(message = "O tempo mínimo de entrega não pode ser negativo ou zero")
    private Integer tempoEntregaMinimo;

    @NegativeOrZero(message = "O tempo máximo de entrega não pode ser negativo ou zero")
    private Integer tempoEntregaMaximo;

    public Produto build() {

        // método do lombok definido na classe Produto usando @Builder
        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }
}
