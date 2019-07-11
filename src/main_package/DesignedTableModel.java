package main_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DesignedTableModel extends AbstractTableModel {
	//Classe che contiene i metodi x la costruzione della tabella
	//Partendo dai dati e dalle colonne si genera la tabella
	
	  private ArrayList<OrcidData> datalist ;
	  private String[] columns ; 

	  public DesignedTableModel(ArrayList<OrcidData> datalist, String[] header){
	    super();
	    this.datalist = datalist;
	    this.columns = header;
	  }

	  // Number of column of your table
	  public int getColumnCount() {
	    return columns.length ;
	  }

	  // Number of row of your table
	  public int getRowsCount() {
	    return datalist.size();
	  }

	  // Quello che va inserito in una singola cella della tabella
	  public Object getValueAt(int row, int col) {
		//seleziono la linea da scrivere, con lo switch seleziono il valore singolo da visualizzare (brutto ma semplice e chiaro)
	    OrcidData data = datalist.get(row);
	    switch(col) {
	      case 0 : return data.getId();
	      case 1 : return data.getAcronyms();
	      case 2 : return data.getAlias();
	      case 3 : return data.getLabel();
	      case 4 : return data.getCreationYear();
	      case 5 : return data.getCommercialLabel();
	      case 6 : return data.getAddress();
	      case 7 : return data.getCity();
	      case 8 : return data.getCitycode();
	      case 9 : return data.getCountry();
	      case 10 : return data.getCountryCode();
	      case 11 : return data.getPostcode();
	      case 12 : return data.getUrbanUnit();
	      case 13 : return data.getUrbanUnitCode();
	      case 14 : return data.getLat();
	      case 15 : return data.getLon();
	      case 16 : return data.getRevenueRange();
	      case 17 : return data.getPrivateFinanceDate();
	      case 18 : return data.getEmployees();
	      case 19 : return data.getTypeCategoryCode();
	      case 20 : return data.getTypeLabel();
	      case 21 : return data.getTypeKind();
	      case 22 : return data.getIsPublic();
	      //come getStaff
	      case 23 : return stringArrayManager(Arrays.toString(data.getLeaders()));
	      //Staff è una lista di elementi, provo a visualizzarlo meglio come NUMERO di ricercatori
	      //I valori vengono comunque salvati per usi futuri (es filtro o esaminatore)
	      case 24 : return stringArrayManager(Arrays.toString(data.getStaff()));
	      case 25 : return data.getLinks();
	      case 26 : return data.getPrivateOrgTypeId();
	      case 27 : return data.getPrivateOrgTypeLabel();
	      case 28 : return data.getActivities();
	      case 29 : return data.getRelations();
	      case 30 : return data.getBadges();
	      //come getStaff
	      case 31 : return stringArrayManager(Arrays.toString(data.getChildren()));
	      //come getStaff
	      case 32 : return stringArrayManager(Arrays.toString(data.getIdentifiers()));
	      default: return null;
	    }
	  }

	  // Optional, the name of your column
	  public String getColumnName(int col) {
	    return columns[col] ;
	  }
	  
	  //StringArrayManager serve a contare quante istanze si trovano in una lista di valori della tabella (es staff : Mario Rossi, Luciano Ligabue....)
	  //Visto che alcune colonne avevano 4 valori e altre 159, ho deciso di mostrare solo quanti valori hanno gli array in queste colonne
	  //i dati sono comunque salvati ma per semplicità non sono stati mostrati altrimenti la tabella sarebbe stata molto sbilanciata
	  public String stringArrayManager(String rowdata) {
		  //testo con "null" perchè ho trasformato il mio array in una string per leggerlo
		  if (!(rowdata.equals("null"))) {
			  //isolo gli elementi di rowdata in una lista
			  List<String> elephantList = Arrays.asList(rowdata.split(","));
			  //ritorno solo il numero di figli perchè l'elenco sarebbe enorme e non so come visualizzarlo
			  return String.valueOf(elephantList.size());
		  }
		  //se arrivo qui la lista è vuota e metto un carattere nullo, non il valore nullo x visualizzare correttamente il tutto
		  return "";
	  }
	  
	  @Override
	  public int getRowCount() {
		  // TODO Auto-generated method stub
		  return datalist.size();
	  }

	}
