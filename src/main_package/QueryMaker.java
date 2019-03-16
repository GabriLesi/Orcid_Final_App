package main_package;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class QueryMaker {
	
	private String column;
	private String value;
	private double latlon;
	private int id;
	private ArrayList <OrcidData> datalist;
	private ArrayList <OrcidData> filteredlist = new ArrayList <OrcidData>();
	
	public QueryMaker(String column, String value, ArrayList<OrcidData> datalist) {
		super();
		this.column = column;
		this.value = value;
		this.datalist = datalist;
	}
	
	//DEVO CAPIRE CHE TIPO DI DATO PASSO DA UNA STRINGA se int double o date e verificare il comportamento di conseguenza
	public ArrayList<OrcidData> QueryChooser() {
		switch(column) {
			case "id" : {
				id = Integer.valueOf(value);
				setFilteredlist(ArrayFilter(datalist, column, id));
				break;
			}
			case "lat" : {
				latlon = Double.valueOf(value);
				setFilteredlist(ArrayFilter(datalist, column,latlon));
				break;
			}
			case "lon" :{
				latlon = Double.valueOf(value);
				setFilteredlist(ArrayFilter(datalist, column,latlon));
				break;
			}
			default : {
				//caso string
				setFilteredlist(ArrayFilter(datalist, column,value));
				break;
			}
		}
		
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, String value) {
		
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			OrcidData data = datalist.get(i);
			String returned = ColumnStringChooser(column,data);
			
			/* stampa di controllo 
			 * System.out.println(returned);
			*/
			
			if (returned.contains(value)) {
					filteredlist.add(data);
			}
		}
		
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, int value) {
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		//controllo che il valore inserito da utente non sia al di fuori della lista per evitare errori
		if (value <= datalist.size()) {
			//se non è cosi controllo normalmente le corrispondenze
			for (int i = 0; i < datalist.size(); i++) {
				OrcidData data = datalist.get(i);
				//uso ID a colpo sicuro perchè è l'unico valore int
				int returned = data.getId();
				if (returned == value) {
						filteredlist.add(data);
				}
			}
		}
		
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, double value) {
		
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			OrcidData data = datalist.get(i);
			//uso Lat e Lon a colpo sicuro perchè sono gli unici valori double
			double returned;
			switch(column) {
				case "lat" : returned = data.getLat();
				case "lon" : returned = data.getLon();
				default : returned = 0.0;
			}
			
			if (returned == value) {
					filteredlist.add(data);
			}
		}
		
		return filteredlist;
	}
	
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
