package br.com.ifpe.oxefood.api.segmento;

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

import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import br.com.ifpe.oxefood.modelo.segmento.SegmentoService;

@RestController
@RequestMapping("/api/segmento")
@CrossOrigin
public class SegmentoController {

    @Autowired
    private SegmentoService segmentoService;

    @GetMapping()
    public List<Segmento> obterTodos() {
        return segmentoService.obterTodos();
    }

    @GetMapping("{id}")
    public Segmento obterPorId(@PathVariable Long id) {
        return segmentoService.obterPorID(id);
    }

    @PostMapping()
    public ResponseEntity<Segmento> salvar(@RequestBody SegmentoRequest segmentoRequest) {
        Segmento segmento = segmentoService.save(segmentoRequest.build());

        return new ResponseEntity<Segmento>(segmento, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Segmento> atualizar(@PathVariable Long id, @RequestBody SegmentoRequest segmentoRequest){
        Segmento segmento = segmentoService.update(id, segmentoRequest.build());

        return new ResponseEntity<Segmento>(segmento, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        segmentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
