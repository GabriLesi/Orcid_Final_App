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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVprinter {

	private static final String CSV_PATH = "C:\\Users\\Gabriele Lesignoli\\Desktop\\TESI\\organizations_ORCID.csv";
	private static final String[] CSV_HEADER = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
			"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
			"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
			"activities","relations","badges","children","identifiers"};
	
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
				System.out.println(singledata); 
			}
			
			//ora che ho i dati creo la tabella e ne imposto i valori
			TableManager tablegen = new TableManager(datalist,CSV_HEADER);
			
			//Ora che ho l'elenco completo provo a stampare una tabella dai dati
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                tablegen.showFrame();
	            }
	        });
		}
		
	}

}
