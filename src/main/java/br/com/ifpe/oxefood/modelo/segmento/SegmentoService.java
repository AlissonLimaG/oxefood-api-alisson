package br.com.ifpe.oxefood.modelo.segmento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegmentoService {

    @Autowired
    private SegmentoRepository repository;

    public Segmento save(Segmento segmento) {
        segmento.setHabilitado(true);
        return repository.save(segmento);
    }

    
    public List<Segmento> obterTodos() {
        return repository.findAll();
    }


    public Segmento obterPorID(Long id){
        return repository.findById(id).get();
    }


    public Segmento update(Long idSegmento, Segmento segmento){

        Segmento segmentoEntity = repository.findById(idSegmento).get();

        segmentoEntity.setDescricao(segmento.getDescricao());

        return repository.save(segmentoEntity);
    }


    public void delete(Long id){
        Segmento segmento = repository.findById(id).get();

        segmento.setHabilitado(false);

        repository.save(segmento);
    }

}
