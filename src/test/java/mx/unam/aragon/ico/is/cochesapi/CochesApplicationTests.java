/*package mx.unam.aragon.ico.is.cochesapi;

import mx.unam.aragon.ico.is.cochesapi.entitys.Coche;
import mx.unam.aragon.ico.is.cochesapi.repositories.CocheRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CochesApplicationTests {

    @Autowired
    private CocheRepository cocheRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertCoche() {
		Coche coche = new Coche(0,"Nissan", "Tsuru", "rojo", 60000.0f,null);
		cocheRepository.save(coche);
	}

	@Test
	void leerCochePorClave() {
		Integer clavetmp = 2;
		Coche tmp = cocheRepository.findCocheByClave(clavetmp);
		System.out.println(tmp);
	}

	@Test
	public void eliminarCoche() {
		Integer clave = 3;
		cocheRepository.deleteById(clave);
	}

	@Test
	public void actualizarCoche() {
		Integer clave = 2;
		Coche tmp = cocheRepository.findCocheByClave(clave);
		tmp.setModelo("versa");
		cocheRepository.save(tmp);
	}
}
*/