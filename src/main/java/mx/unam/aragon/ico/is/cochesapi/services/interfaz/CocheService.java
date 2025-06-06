package mx.unam.aragon.ico.is.cochesapi.services.interfaz;

import mx.unam.aragon.ico.is.cochesapi.entitys.Coche;

import java.util.Optional;

public interface CocheService {
    public abstract Coche crear(Coche coche);
    public abstract Iterable<Coche> listarTodos();
    public abstract Optional<Coche> buscarporId(Integer id);
    public abstract Coche actualizar(Integer id, Coche coche);
    public abstract void eliminar(Integer id);

}
