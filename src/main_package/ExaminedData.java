package main_package;

import java.util.ArrayList;

public class ExaminedData {
	
	private ArrayList<String> valueList = new ArrayList<String>();
	private ArrayList<Integer> counterList = new ArrayList<Integer>();
	private String valoreFiltrato;
	private int contaValoriFiltrati;
	
	public ExaminedData(String valoreFiltrato, int contaValoriFiltrati) {
		super();
		this.valoreFiltrato = valoreFiltrato;
		this.contaValoriFiltrati = contaValoriFiltrati;
	}
	
	public ExaminedData() {
		// TODO Auto-generated constructor stub
	}
	
	public void ColumnExaminer(String valoreEsame) {
		//cerco nell'array se ho gi� il dato : se si, incremento il contatore di 1, altrimenti lo aggiungo e setto un nuovo contatore ad 1
		for (int i = 0; i<= valueList.size(); i++) {
			//se contengo il valore aumento il contatore con il corrispettivo indice, altrimenti aggiungo il valore e lo creo 
			if (valueList.contains(valoreEsame)) {
				//se trovo il valore allora risalgo all'indice e lo aggiorno di conseguenza
				int correctindex = valueList.indexOf(valoreEsame);
				counterList.set(correctindex, counterList.get(correctindex) + 1);
				//stampa di controllo
				//System.out.println("Sommo l'elemento "+ valueList.get(correctindex) +" e appare " + counterList.get(correctindex) + "volte");
			}
			else {
				valueList.add(valoreEsame);
				counterList.add(1);
				System.out.println("Aggiungo l'elemento "+ valueList.get(i) +" e appare " + counterList.get(i) + "volte");
			}
		}
		
	}
	
	public void Printer() {
		System.out.println("---------------VALORI ESAMINATI DELLA COLONNA FILTRATA---------------");
		for (int i = 0; i<valueList.size(); i++) {
			System.out.println(counterList.get(i) + " istanze per " + valueList.get(i));
		}
		System.out.println("---------------------------------------------------------------------");
	}

	public int getContaValoriFiltrati() {
		return contaValoriFiltrati;
	}

	public void setContaValoriFiltrati(int contaValoriFiltrati) {
		this.contaValoriFiltrati = contaValoriFiltrati;
	}

	public String getValoreFiltrato() {
		return valoreFiltrato;
	}

	public void setValoreFiltrato(String valoreFiltrato) {
		this.valoreFiltrato = valoreFiltrato;
	}
	
	
}
