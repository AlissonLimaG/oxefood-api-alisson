package br.com.ifpe.oxefood.modelo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto){

        produto.setHabilitado(true);
        
        return repository.save(produto);
    }
}
