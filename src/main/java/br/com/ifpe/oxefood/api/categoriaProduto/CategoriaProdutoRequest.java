package br.com.ifpe.oxefood.api.categoriaProduto;

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

    @NotBlank(message = "A descrição não pode ser nula ou vazia")
    @Size(min = 10, max = 200, message = "A descrição deve ter entre 10 e 200 caracteres")
    private String descricao;
    
    public CategoriaProduto build(){
        return CategoriaProduto.builder()
                .descricao(descricao)
                .build();
    }
}
