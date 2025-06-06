package mx.unam.aragon.ico.is.cochesapi.services;

import mx.unam.aragon.ico.is.cochesapi.entitys.Coche;
import mx.unam.aragon.ico.is.cochesapi.repositories.CocheRepository;
import mx.unam.aragon.ico.is.cochesapi.services.interfaz.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CocheServiceImpl implements CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    @Override
    public Coche crear(Coche coche) {
        return cocheRepository.save(coche);
    }

    @Override
    public Iterable<Coche> listarTodos() {
        return cocheRepository.findAll();
    }

    @Override
    public Optional<Coche> buscarporId(Integer id) {
        return cocheRepository.findById(id);
    }

    @Override
    public Coche actualizar(Integer id, Coche coche) {
        Optional<Coche> cocheActual = cocheRepository.findById(id);
        if (cocheActual.isPresent()) {
            Coche tmp = cocheActual.get();
            tmp.setMarca(coche.getMarca());
            tmp.setModelo(coche.getModelo());
            tmp.setColor(coche.getColor());
            tmp.setPrecio(coche.getPrecio());
            tmp.setFoto(coche.getFoto());
            return cocheRepository.save(tmp);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        //return cocheRepository.deleteCocheByClave(id);
        cocheRepository.deleteById(id);

    }
}
