package app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.Entrada;
import app.entity.Calculo;
import app.repository.CalculoRepository;

@Service
public class CalculoService {

	@Autowired
	private CalculoRepository calculoRepository;

	public Calculo calcular(Entrada entrada) {
	    List<Integer> lista = entrada.getLista();

	    Calculo calculo = new Calculo();
	    calculo.setLista(lista);
	    calculo.setSoma(this.soma(lista));
	    calculo.setMedia(this.media(lista));
	    calculo.setMediana(this.mediana(lista));
	    calculo.setMaior(this.maior(lista));
	    calculo.setMenor(this.menor(lista));
	    calculo.setTotalElementos(lista.size());

	    return calculo;
	}




	public int soma(List<Integer> lista) {
		int soma = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == null)
				throw new RuntimeException("dslçfjakd");
			else
				soma += lista.get(i);
		}
		return soma;
	}


	public double media(List<Integer> lista) {
		
		double resultado =  this.soma(lista) / lista.size();
		System.out.println(resultado);
		return resultado;
	}


	public double mediana(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);

	    if (lista.size() % 2 == 1) { //ÍMPAR
	        return lista.get(lista.size() / 2);
	    } else {
	        int meio1 = lista.get(lista.size() / 2 - 1);
	        int meio2 = lista.get(lista.size() / 2);
	        return (meio1 + meio2) / 2;
	    }
	}
	
	public int maior(List<Integer> lista) {
	    if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
	    return Collections.max(lista);
	}

	public int menor(List<Integer> lista) {
	    if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
	    return Collections.min(lista);
	}

	

}
