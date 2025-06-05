package br.com.ifpe.oxefood.api.produto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProdutoService;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

        CategoriaProduto categoriaProduto = categoriaProdutoService.findById(request.getIdCategoria());
        Produto produto = request.build();
        produto.setCategoriaProduto(categoriaProduto);

        produtoService.save(produto);

        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }


    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

        Produto produto = produtoService.obterPorID(id);
        produto.setCategoriaProduto(categoriaProdutoService.findById(request.getIdCategoria()));

        produtoService.update(id, request.build());
        
        return ResponseEntity.ok().build();
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println("CHEGOU");
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
