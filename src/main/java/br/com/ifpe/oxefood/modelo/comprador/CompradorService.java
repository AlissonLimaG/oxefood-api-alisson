package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository repository;

    public List<Comprador> obterTodos(){
        return repository.findAll();
    }

    public Comprador obterPorId(Long id){
        return repository.findById(id).get();
    }

    public Comprador salvar(Comprador comprador){
        comprador.setHabilitado(true);

        return repository.save(comprador);
    }

    public void deletar(Long id){
        Comprador comprador = repository.findById(id).get();
        comprador.setHabilitado(false);

        repository.save(comprador);
    }


    public Comprador atualizar(Long id, Comprador comprador){
        Comprador compradorEntity = repository.findById(id).get();

        compradorEntity.setSegmento(comprador.getSegmento());
        compradorEntity.setNome(comprador.getNome());
        compradorEntity.setEnderecoComercial(comprador.getEnderecoComercial());
        compradorEntity.setEnderecoResidencial(comprador.getEnderecoResidencial());
        compradorEntity.setComissao(comprador.getComissao());
        compradorEntity.setQtdComprasMediasMes(comprador.getQtdComprasMediasMes());
        compradorEntity.setContratadoEm(comprador.getContratadoEm());

        return repository.save(compradorEntity);
    }
    
}
