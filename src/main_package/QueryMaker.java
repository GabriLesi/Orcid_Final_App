package main_package;

import java.util.ArrayList;
import java.util.Arrays;

public class QueryMaker {
	
	//classe con diversi metodi per il filtraggio di una arraylist di orciddata (ne riceve una da filtrare e ne ritorna una filtrata)
	private String column;
	private String columnToExamine;
	private String value;
	//valore per latitudine e longitudine
	private double latlon;
	private int id;
	//lista dati iniziale, da filtrare
	private ArrayList <OrcidData> datalist;
	//lista dati in uscita, fitrata
	private ArrayList <OrcidData> filteredlist = new ArrayList <OrcidData>();
	//lista valori esaminati, mostrati su console a fine filtro
	private ExaminedData examinedList  = new ExaminedData();
	
	public QueryMaker(String column, String value, ArrayList<OrcidData> datalist, String columnToExamine) {
		super();
		this.column = column;
		this.columnToExamine = columnToExamine;
		this.value = value;
		this.datalist = datalist;
	}
	
	//DEVO CAPIRE CHE TIPO DI DATO PASSO DA UNA STRINGA se int double o date e verificare il comportamento di conseguenza
	public ArrayList<OrcidData> QueryChooser() {
		//controllo il nome della colonna da filtrare
		switch(column) {
			case "id" : {
				//se � ID converto il valore di value in Int e avvio il filtro
				id = Integer.valueOf(value);
				setFilteredlist(ArrayFilter(datalist, column, id));
				break;
			}
			case "lat" : {
				//se � LAT o LON converto in Double e filtro
				latlon = Double.valueOf(value);
				setFilteredlist(ArrayFilter(datalist, column,latlon));
				break;
			}
			case "lon" :{
				//se � LAT o LON converto in Double e filtro
				latlon = Double.valueOf(value);
				setFilteredlist(ArrayFilter(datalist, column,latlon));
				break;
			}
			default : {
				//se � un valore String allora controllo normalmente
				setFilteredlist(ArrayFilter(datalist, column,value));
				break;
			}
		}
		
		return filteredlist;
	}
	
	//caso STRING
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, String value) {
		
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			//controllo 1 valore
			OrcidData data = datalist.get(i);
			String returned = ColumnStringChooser(column,data);
			
			/* stampa di controllo 
			 * System.out.println(returned);
			*/
			
			//se il valore letto contiene il valore da filtrare lo aggiungo, altrimenti lo scarto
			if (returned.contains(value)) {
					filteredlist.add(data);
					
					//se ho aggiunto il valore ho rispettato il filtro QUINDI vado ad esaminare la colonna e inserisco i valori
					String valueToExamine = ColumnStringChooser(columnToExamine, data);
					examinedList.ColumnExaminer(valueToExamine);
			}
		}
		
		//mostro quanti e quali valori ho esaminato
		examinedList.Printer();
		
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, int value) {
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		//controllo che il valore inserito da utente non sia al di fuori della lista per evitare errori
		if (value <= datalist.size()) {
			//se non � cosi controllo normalmente le corrispondenze
			for (int i = 0; i < datalist.size(); i++) {
				OrcidData data = datalist.get(i);
				//uso ID a colpo sicuro perch� � l'unico valore int
				int returned = data.getId();
				if (returned == value) {
						filteredlist.add(data);
						
						//se ho aggiunto il valore ho rispettato il filtro QUINDI vado ad esaminare la colonna e inserisco i valori
						String valueToExamine = ColumnStringChooser(columnToExamine, data);
						examinedList.ColumnExaminer(valueToExamine);
						
				}
			}
			//mostro quanti e quali valori ho esaminato
			examinedList.Printer();
		}
		
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, double value) {
		
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			OrcidData data = datalist.get(i);
			//uso Lat e Lon a colpo sicuro perch� sono gli unici valori double
			double returned;
			switch(column) {
				case "lat" : returned = data.getLat();
				case "lon" : returned = data.getLon();
				default : returned = 0.0;
			}
			
			if (returned == value) {
					filteredlist.add(data);
					
					//se ho aggiunto il valore ho rispettato il filtro QUINDI vado ad esaminare la colonna e inserisco i valori
					String valueToExamine = ColumnStringChooser(columnToExamine, data);
					examinedList.ColumnExaminer(valueToExamine);
			}
		}
		//mostro quanti e quali valori ho esaminato
		examinedList.Printer();
		
		return filteredlist;
	}
	
	//selettore di colonne per le JComboBox e i filtri associati
	public String ColumnStringChooser(String column, OrcidData data) {
		switch(column) {
			case "acronyms" : return data.getAcronyms();
			case "alias": return data.getAlias();
			case "label": return data.getLabel();
			case "commercialLabel": return data.getCommercialLabel();
			case "creationYear" : return data.getCreationYear();
			case "address": return data.getAddress();
			case "city": return data.getCity();
			case "citycode": return data.getCitycode();
			case "country": return data.getCountry();
			case "countrycode": return data.getCountryCode();
			case "postcode": return data.getPostcode();
			case "urbanunit": return data.getUrbanUnit();
			case "urbanunitcode": return data.getUrbanUnitCode();
			case "revenuerange": return data.getRevenueRange();
			case "privateFinanceDate": return data.getPrivateFinanceDate();
			case "employees": return data.getEmployees();
			case "typeCategoryCode": return data.getTypeCategoryCode();
			case "typeLabel": return data.getTypeLabel();
			case "typeKind": return data.getTypeKind();
			case "isPublic": return data.getIsPublic();
			case "leaders" : return Arrays.toString(data.getLeaders());
			case "staff" : return Arrays.toString(data.getStaff());
			case "links": return data.getLinks();
			case "privateOrgTypeID": return data.getPrivateOrgTypeId();
			case "privateOrgTypeLabel": return data.getPrivateOrgTypeLabel();
			case "activities": return data.getActivities();
			case "relations": return data.getRelations();
			case "badges": return data.getBadges();
			case "childrens" : return Arrays.toString(data.getChildren());
			case "identifiers" : return Arrays.toString(data.getIdentifiers());
			default : return null;
		}
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getLatlon() {
		return latlon;
	}

	public void setLatlon(double latlon) {
		this.latlon = latlon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<OrcidData> getDatalist() {
		return datalist;
	}

	public void setDatalist(ArrayList<OrcidData> datalist) {
		this.datalist = datalist;
	}

	public ArrayList<OrcidData> getFilteredlist() {
		return filteredlist;
	}

	public void setFilteredlist(ArrayList<OrcidData> filteredlist) {
		this.filteredlist = filteredlist;
	}
	
}
