package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    
    public CategoriaProduto save(CategoriaProduto entity){
        entity.setHabilitado(true);
        return repository.save(entity);
    }


    public List<CategoriaProduto> findAll(){
        return repository.findAll();
    }


    public CategoriaProduto findById(Long id){
        return repository.findById(id).get();
    }


    public void update(Long id, CategoriaProduto categoria){
        System.out.println("CAMADA DE SERVIÇO");
        CategoriaProduto entity = repository.findById(id).get();

        entity.setDescricao(categoria.getDescricao());

        repository.save(entity);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }
}
