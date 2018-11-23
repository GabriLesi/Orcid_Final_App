package main_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class QueryMaker {
	
	//DEVO CAPIRE CHE TIPO DI DATO PASSO DA UNA STRINGA se int double o data e verificare il comportamento di conseguenza
	/*
	public ArrayList<OrcidData> QueryChooser (String StringValue){
		int IntValue;
		double DoubleValue;
		//grazie a un IF nidificato controllo che tipo di dato viene passato
		Integer.parseInt(StringValue)
			
		}
	} 
	*/
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, String value) {
		ArrayList<OrcidData> filteredlist = new ArrayList<OrcidData>();
		
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
		ArrayList<OrcidData> filteredlist = new ArrayList<OrcidData>();
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			OrcidData data = datalist.get(i);
			//uso ID a colpo sicuro perchè è l'unico valore int
			int returned = data.getId();
			if (returned == value) {
					filteredlist.add(data);
			}
		}
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, Date value) {
		ArrayList<OrcidData> filteredlist = new ArrayList<OrcidData>();
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			OrcidData data = datalist.get(i);
			//uso Creationdate a colpo sicuro perchè è l'unico valore date
			Date returned = data.getCreationYear();
			if (returned.equals(value)) {
					filteredlist.add(data);
			}
		}
		return filteredlist;
	}
	
	public ArrayList<OrcidData> ArrayFilter(ArrayList<OrcidData> datalist, String column, double value) {
		ArrayList<OrcidData> filteredlist = new ArrayList<OrcidData>();
		// per ora creo una seconda lista che contiene solo i valori filtrati nella colonna
		for (int i = 0; i < datalist.size(); i++) {
			OrcidData data = datalist.get(i);
			//uso ID a colpo sicuro perchè è l'unico valore int
			double returned;
			switch(column) {
				case "Lat" : returned = data.getLat();
				case "Lon" : returned = data.getLon();
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
			case "Acronyms" : return data.getAcronyms();
			case "Alias": return data.getAlias();
			case "Label": return data.getLabel();
			case "CommercialLabel": return data.getCommercialLabel();
			case "Address": return data.getAddress();
			case "City": return data.getCity();
			case "Citycode": return data.getCitycode();
			case "Country": return data.getCountry();
			case "Countrycode": return data.getCountryCode();
			case "Postcode": return data.getPostcode();
			case "Urbanunit": return data.getUrbanUnit();
			case "Urbanunitcode": return data.getUrbanUnitCode();
			case "Revenuerange": return data.getRevenueRange();
			case "PrivateFinanceDate": return data.getPrivateFinanceDate();
			case "Employees": return data.getEmployees();
			case "TypeCategoryCode": return data.getTypeCategoryCode();
			case "TypeLabel": return data.getTypeLabel();
			case "TypeKind": return data.getTypeKind();
			case "IsPublic": return data.getIsPublic();
			case "Leaders" : return Arrays.toString(data.getLeaders());
			case "Staff" : return Arrays.toString(data.getStaff());
			case "Links": return data.getLinks();
			case "PrivateOrgTypeID": return data.getPrivateOrgTypeId();
			case "PrivateOrgTypeLabel": return data.getPrivateOrgTypeLabel();
			case "Activities": return data.getActivities();
			case "Relations": return data.getRelations();
			case "Badges": return data.getBadges();
			case "Childrens" : return Arrays.toString(data.getChildren());
			case "Identifiers" : return Arrays.toString(data.getIdentifiers());
			default : return null;
		}
	}
	
}
