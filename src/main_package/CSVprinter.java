package main_package;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVprinter {

	private static final String CSV_PATH = "C:\\Users\\Gabriele Lesignoli\\Desktop\\TESI\\organizations_ORCID.csv";
	
	public static void main(String[] args) throws IOException {
		
		try (Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));)
		{	
			CsvToBean<OrcidData> dataToBean = new CsvToBeanBuilder<OrcidData>(reader)
					.withType(OrcidData.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();
			
			//iteratore per leggere ogni file dell'elenco
			Iterator<OrcidData> dataIterator = dataToBean.iterator();
			ArrayList <OrcidData> datalist = new ArrayList<OrcidData>();
			
			//ciclo di lettura valori finchè posso
			while (dataIterator.hasNext()) {
				OrcidData singledata = dataIterator.next();
				datalist.add(singledata);
				
				//STAMPA DI PROVA, messa sotto commento perchè ho verificato che i dati sono registrati correttamente
				//System.out.println(singledata); 
			}
			
			//Ora che ho l'elenco completo provo a stampare una tabella dai dati
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	//ora che ho i dati creo la tabella e ne imposto i valori
	    			UIinitiator UI = new UIinitiator(datalist);
	    			UI.createAndShowGUI();
	    			UI.start();
	            }
	        });
		}
		
	}

}
