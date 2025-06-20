package br.com.ifpe.oxefood.api.categoriaProduto;

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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoriaProduto")
@CrossOrigin
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService service;


    @PostMapping()
    public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request){
        CategoriaProduto entity = request.build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(entity));
    }

    
    @GetMapping()
    public ResponseEntity<List<CategoriaProduto>> findAll(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProduto> findById(@PathVariable Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CategoriaProdutoRequest request){
        service.update(id, request.build());
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
