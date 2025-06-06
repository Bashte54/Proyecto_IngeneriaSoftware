package mx.unam.aragon.ico.is.cochesapi.repositories;

import mx.unam.aragon.ico.is.cochesapi.entitys.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CocheRepository extends JpaRepository<Coche, Integer> {
    public Coche findCocheByClave(Integer clave);
    public Coche deleteCocheByClave(Integer clave);
}
