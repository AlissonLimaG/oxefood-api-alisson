package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) {

        if (produto.getValorUnitario() < 20 && produto.getValorUnitario() > 100) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_LIMITE_PRODUTO);
        }

        produto.setHabilitado(true);

        return repository.save(produto);
    }


    public List<Produto> listarTodos() {

        return repository.findAll();
    }


    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }


    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setCategoriaProduto(produtoAlterado.getCategoriaProduto());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());

        repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {

        Produto entity = repository.findById(id).get();
        entity.setHabilitado(false);

        repository.save(entity);
    }


    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

       List<Produto> listaProdutos = repository.findAll();

       if ((codigo != null && !"".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria == null)) {
               listaProdutos = repository.consultarPorCodigo(codigo);
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria == null)) {    
               listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo == null || "".equals(titulo)) &&
           (idCategoria != null)) {
               listaProdutos = repository.consultarPorCategoria(idCategoria); 
       } else if (
           (codigo == null || "".equals(codigo)) &&
           (titulo != null && !"".equals(titulo)) &&
           (idCategoria != null)) {
               listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria); 
       }

       return listaProdutos;
}

}
