package main_package;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.ArrayList;
//libreria OpenCSV
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVprinter {
	
	//percorso dove si trova il file CSV da leggere
	private static final String CSV_PATH = "C:\\Users\\Gabriele Lesignoli\\Desktop\\TESI\\organizations_ORCID.csv";
	
	public static void main(String[] args) throws IOException {
		
		//prova a leggere il file, se non lo trova non parte il programma
		try (Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));)
		{	
			//crea un bean dei file presenti sul file CSV, withType determina la classe dove andranno inseriti i dati, leadingspace è per evitare la prima colonna di intestazione
			CsvToBean<OrcidData> dataToBean = new CsvToBeanBuilder<OrcidData>(reader)
					.withType(OrcidData.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			
			//iteratore per leggere ogni file dell'elenco e arraylist per contenere gli oggetti creati
			Iterator<OrcidData> dataIterator = dataToBean.iterator();
			ArrayList <OrcidData> datalist = new ArrayList<OrcidData>();
			
			//ciclo di lettura valori finchè posso, se leggo aumento l'iteratore e inserisco il file nell'array
			while (dataIterator.hasNext()) {
				OrcidData singledata = dataIterator.next();
				datalist.add(singledata);
				
				/*stampa di prova per verificare i nomi dello staff
				if(singledata.getId() == 26550) {
					System.out.println("--------------------");
					String [] test = singledata.getStaff();
					for (int i = 0; i<test.length; i++) {
						System.out.println(test[i]);
					}
					System.out.println("--------------------");
				}
				*/
				
				//STAMPA DI PROVA, messa sotto commento perchè ho verificato che i dati sono registrati correttamente
				//System.out.println(singledata); 
			}
			
			//Ora che ho l'elenco completo provo a stampare una tabella dai dati
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	//ora che ho i dati creo la tabella e ne imposto i valori riempendo l'interfaccia grafica
	    			UIinitiator UI = new UIinitiator(datalist);
	    			UI.createAndShowGUI();
	    			UI.start();
	            }
	        });
		}
		
	}

}