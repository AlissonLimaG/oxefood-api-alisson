package br.com.ifpe.oxefood.api.comprador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.comprador.CompradorService;
import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import br.com.ifpe.oxefood.modelo.segmento.SegmentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/comprador")
@CrossOrigin
public class CompradorController {

    @Autowired
    private CompradorService compradorService;

    @Autowired
    private SegmentoService segmentoService;

    @GetMapping
    public List<Comprador> obterTodos() {
        return compradorService.obterTodos();
    }

    @GetMapping("{id}")
    public Comprador obterPorId(@PathVariable Long id) {
        return compradorService.obterPorId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        compradorService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Comprador> salvar(@RequestBody CompradorRequest compradorRequest) {
        Segmento segmento = segmentoService.obterPorID(compradorRequest.getIdSegmento());

        Comprador compradorEntity = compradorRequest.build();
        compradorEntity.setSegmento(segmento);

        Comprador comprador = compradorService.salvar(compradorEntity);

        return new ResponseEntity<Comprador>(comprador, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Comprador> atualizar(
            @PathVariable Long id,
            @RequestBody CompradorRequest compradorRequest) {

        Segmento segmento = segmentoService.obterPorID(compradorRequest.getIdSegmento());

        Comprador comprador = compradorRequest.build();
        comprador.setSegmento(segmento);

        Comprador response = compradorService.atualizar(id, comprador);

        return new ResponseEntity<Comprador>(response, HttpStatus.OK);
    }

}
