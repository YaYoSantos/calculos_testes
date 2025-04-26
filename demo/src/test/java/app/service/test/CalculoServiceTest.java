package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import app.dto.Entrada; 
import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	
	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 06 - Testar mediana com null")
	void cenario06(){
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(null);
		lista.add(9);
		lista.add(39);
		
		assertThrows(Exception.class,()->{
			this.calculoService.mediana(lista);
		});
	} 
	
	@Test
	@DisplayName("Cena 07 - Testar media")
	void cenario07(){
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		
		assertEquals(4, this.calculoService.media(lista));
	} 
	
	@Test
	@DisplayName("Cena 08 - Testar maior número com lista comum")
	void cenario08() {
		List<Integer> lista = List.of(1, 3, 7, 2, 5);
		assertEquals(7, this.calculoService.maior(lista));
	}

	@Test
	@DisplayName("Cena 09 - Testar maior número com todos os elementos iguais")
	void cenario09() {
		List<Integer> lista = List.of(4, 4, 4, 4);
		assertEquals(4, this.calculoService.maior(lista));
	}

	@Test
	@DisplayName("Cena 10 - Testar maior número com lista vazia")
	void cenario10() {
		List<Integer> lista = new ArrayList<>();
		assertThrows(Exception.class, () -> this.calculoService.maior(lista));
	}

	@Test
	@DisplayName("Cena 11 - Testar menor número com lista comum")
	void cenario11() {
		List<Integer> lista = List.of(10, 3, 8, 15, 1);
		assertEquals(1, this.calculoService.menor(lista));
	}

	@Test
	@DisplayName("Cena 12 - Testar menor número com todos os elementos iguais")
	void cenario12() {
		List<Integer> lista = List.of(9, 9, 9, 9);
		assertEquals(9, this.calculoService.menor(lista));
	}

	@Test
	@DisplayName("Cena 13 - Testar menor número com lista vazia")
	void cenario13() {
		List<Integer> lista = new ArrayList<>();
		assertThrows(Exception.class, () -> this.calculoService.menor(lista));
	}

	

}
