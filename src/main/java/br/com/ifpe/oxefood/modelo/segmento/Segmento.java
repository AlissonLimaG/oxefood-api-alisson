package br.com.ifpe.oxefood.modelo.segmento;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Segmento")
@SQLRestriction("habilitado = true")

@Builder // essa anotação dá a classe um método de criar objetos diferente, mais performático!
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Segmento extends EntidadeAuditavel{

    @Column
    private String descricao;
    
}
