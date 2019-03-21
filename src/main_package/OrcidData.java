package main_package;

import java.util.Arrays;

import com.opencsv.bean.CsvBindByName;

public class OrcidData {
	//classe dove ogni oggetto sarà una stringa di dati letta
	@CsvBindByName	//@CsvBindByName(column = "id") nel caso non funzioni
	private int id;
	
	@CsvBindByName
	private String acronyms;
	
	@CsvBindByName
	private String alias;
	
	@CsvBindByName
	private String label;
	
	@CsvBindByName
	private String creationYear;
	
	@CsvBindByName
	private String commercialLabel;
	
	@CsvBindByName
	private String address;
	
	@CsvBindByName
	private String city;
	
	@CsvBindByName
	private String citycode;
	
	@CsvBindByName
	private String country;
	
	@CsvBindByName
	private String countryCode;
	
	@CsvBindByName
	private String postcode;
	
	@CsvBindByName
	private String urbanUnit;
	
	@CsvBindByName
	private String urbanUnitCode;
	
	@CsvBindByName
	private double lat;
	
	@CsvBindByName
	private double lon;
	
	@CsvBindByName
	private String revenueRange;
	
	@CsvBindByName
	private String privateFinanceDate;
	
	@CsvBindByName
	private String employees;
	
	@CsvBindByName
	private String typeCategoryCode;
	
	@CsvBindByName
	private String typeLabel;
	
	@CsvBindByName
	private String typeKind;
	
	@CsvBindByName
	private String isPublic;
	
	@CsvBindByName
	private String[] leaders;
	
	@CsvBindByName
	private String[] staff;
	
	@CsvBindByName
	private String links;
	
	@CsvBindByName
	private String privateOrgTypeId;
	
	@CsvBindByName
	private String privateOrgTypeLabel;
	
	@CsvBindByName
	private String activities;
	
	@CsvBindByName
	private String relations;
	
	@CsvBindByName
	private String badges;
	
	@CsvBindByName
	private String[] children;
	
	@CsvBindByName
	private String[] identifiers;
	
	public OrcidData() {
		
	}

	public OrcidData(int id, String acronyms, String alias, String label, String creationYear, String commercialLabel,
			String address, String city, String citycode, String country, String countryCode, String postcode,
			String urbanUnit, String urbanUnitCode, double lat, double lon, String revenueRange,
			String privateFinanceDate, String employees, String typeCategoryCode, String typeLabel, String typeKind,
			String isPublic, String[] leaders, String[] staff, String links, String privateOrgTypeId,
			String privateOrgTypeLabel, String activities, String relations, String badges, String[] children,
			String[] identifiers) {
		super();
		this.id = id;
		this.acronyms = acronyms;
		this.alias = alias;
		this.label = label;
		this.creationYear = creationYear;
		this.commercialLabel = commercialLabel;
		this.address = address;
		this.city = city;
		this.citycode = citycode;
		this.country = country;
		this.countryCode = countryCode;
		this.postcode = postcode;
		this.urbanUnit = urbanUnit;
		this.urbanUnitCode = urbanUnitCode;
		this.lat = lat;
		this.lon = lon;
		this.revenueRange = revenueRange;
		this.privateFinanceDate = privateFinanceDate;
		this.employees = employees;
		this.typeCategoryCode = typeCategoryCode;
		this.typeLabel = typeLabel;
		this.typeKind = typeKind;
		this.isPublic = isPublic;
		this.leaders = leaders;
		this.staff = staff;
		this.links = links;
		this.privateOrgTypeId = privateOrgTypeId;
		this.privateOrgTypeLabel = privateOrgTypeLabel;
		this.activities = activities;
		this.relations = relations;
		this.badges = badges;
		this.children = children;
		this.identifiers = identifiers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcronyms() {
		return acronyms;
	}

	public void setAcronyms(String acronyms) {
		this.acronyms = acronyms;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(String creationYear) {
		this.creationYear = creationYear;
	}

	public String getCommercialLabel() {
		return commercialLabel;
	}

	public void setCommercialLabel(String commercialLabel) {
		this.commercialLabel = commercialLabel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getUrbanUnit() {
		return urbanUnit;
	}

	public void setUrbanUnit(String urbanUnit) {
		this.urbanUnit = urbanUnit;
	}

	public String getUrbanUnitCode() {
		return urbanUnitCode;
	}

	public void setUrbanUnitCode(String urbanUnitCode) {
		this.urbanUnitCode = urbanUnitCode;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getRevenueRange() {
		return revenueRange;
	}

	public void setRevenueRange(String revenueRange) {
		this.revenueRange = revenueRange;
	}

	public String getPrivateFinanceDate() {
		return privateFinanceDate;
	}

	public void setPrivateFinanceDate(String privateFinanceDate) {
		this.privateFinanceDate = privateFinanceDate;
	}

	public String getEmployees() {
		return employees;
	}

	public void setEmployees(String employees) {
		this.employees = employees;
	}

	public String getTypeCategoryCode() {
		return typeCategoryCode;
	}

	public void setTypeCategoryCode(String typeCategoryCode) {
		this.typeCategoryCode = typeCategoryCode;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}

	public String getTypeKind() {
		return typeKind;
	}

	public void setTypeKind(String typeKind) {
		this.typeKind = typeKind;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String[] getLeaders() {
		return leaders;
	}

	public void setLeaders(String[] leaders) {
		this.leaders = leaders;
	}

	public String[] getStaff() {
		return staff;
	}

	public void setStaff(String[] staff) {
		this.staff = staff;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getPrivateOrgTypeId() {
		return privateOrgTypeId;
	}

	public void setPrivateOrgTypeId(String privateOrgTypeId) {
		this.privateOrgTypeId = privateOrgTypeId;
	}

	public String getPrivateOrgTypeLabel() {
		return privateOrgTypeLabel;
	}

	public void setPrivateOrgTypeLabel(String privateOrgTypeLabel) {
		this.privateOrgTypeLabel = privateOrgTypeLabel;
	}

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getRelations() {
		return relations;
	}

	public void setRelations(String relations) {
		this.relations = relations;
	}

	public String getBadges() {
		return badges;
	}

	public void setBadges(String badges) {
		this.badges = badges;
	}

	public String[] getChildren() {
		return children;
	}

	public void setChildren(String[] children) {
		this.children = children;
	}

	public String[] getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(String[] identifiers) {
		this.identifiers = identifiers;
	}

	@Override
	public String toString() {
		return "OrcidData [id=" + id + ", " + (acronyms != null ? "acronyms=" + acronyms + ", " : "")
				+ (alias != null ? "alias=" + alias + ", " : "") + (label != null ? "label=" + label + ", " : "")
				+ (creationYear != null ? "creationYear=" + creationYear + ", " : "")
				+ (commercialLabel != null ? "commercialLabel=" + commercialLabel + ", " : "")
				+ (address != null ? "address=" + address + ", " : "") + (city != null ? "city=" + city + ", " : "")
				+ (citycode != null ? "citycode=" + citycode + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (countryCode != null ? "countryCode=" + countryCode + ", " : "")
				+ (postcode != null ? "postcode=" + postcode + ", " : "")
				+ (urbanUnit != null ? "urbanUnit=" + urbanUnit + ", " : "")
				+ (urbanUnitCode != null ? "urbanUnitCode=" + urbanUnitCode + ", " : "") + "lat=" + lat + ", lon=" + lon
				+ ", " + (revenueRange != null ? "revenueRange=" + revenueRange + ", " : "")
				+ (privateFinanceDate != null ? "privateFinanceDate=" + privateFinanceDate + ", " : "")
				+ (employees != null ? "employees=" + employees + ", " : "")
				+ (typeCategoryCode != null ? "typeCategoryCode=" + typeCategoryCode + ", " : "")
				+ (typeLabel != null ? "typeLabel=" + typeLabel + ", " : "")
				+ (typeKind != null ? "typeKind=" + typeKind + ", " : "")
				+ (isPublic != null ? "isPublic=" + isPublic + ", " : "")
				+ (leaders != null ? "leaders=" + Arrays.toString(leaders) + ", " : "")
				+ (staff != null ? "staff=" + Arrays.toString(staff) + ", " : "")
				+ (links != null ? "links=" + links + ", " : "")
				+ (privateOrgTypeId != null ? "privateOrgTypeId=" + privateOrgTypeId + ", " : "")
				+ (privateOrgTypeLabel != null ? "privateOrgTypeLabel=" + privateOrgTypeLabel + ", " : "")
				+ (activities != null ? "activities=" + activities + ", " : "")
				+ (relations != null ? "relations=" + relations + ", " : "")
				+ (badges != null ? "badges=" + badges + ", " : "")
				+ (children != null ? "children=" + Arrays.toString(children) + ", " : "")
				+ (identifiers != null ? "identifiers=" + Arrays.toString(identifiers) : "") + "]";
	}
	
	/* funzione usata per testare il corretto salvataggio delle liste di elementi
	 * public String printStaff() {
		return Arrays.toString(staff);
	}
	*/
	
	
}