package br.com.ifpe.oxefood.modelo.categoriaProduto;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "Categoria")
@SQLRestriction("habilitado = true")

@Builder //essa anotação dá a classe um metodo de criar objetos diferente, mais performático!
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProduto extends EntidadeAuditavel {

    @Column
    private String descricao;
}
