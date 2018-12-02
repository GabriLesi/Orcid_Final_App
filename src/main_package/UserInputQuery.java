package main_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserInputQuery {
	
	//pre-istanzio i due valori che verranno passati al sistema di filtraggio dall'utente
	private String columnfilter;
	private String valuefilter;
	private JTextField filterfield;
	private JComboBox columns;
	private JPanel newPanel;
	private ArrayList<OrcidData> datalist;
	
	public UserInputQuery(ArrayList<OrcidData> datalist) {
		super();
		this.datalist = datalist;
	}
	
	public JPanel Panelgenerator() {
		
		//creo e posiziono la finestra
		
		//creo il panel e la griglia per collocare gli elementi
		newPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
		
		//popolo la finestra con elenchi e input testuali
		String[] columnOptions = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
				"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
				"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
				"activities","relations","badges","children","identifiers"};
		JLabel columnLbl = new JLabel("Attributo da filtrare");
		columns = new JComboBox(columnOptions);
		constraints.gridx = 0;
		constraints.gridy = 0;
		newPanel.add(columnLbl, constraints);
		constraints.gridx = 1;
		newPanel.add(columns, constraints);
		
		//creo la casella di testo
		//LA SINTASSI DEL NOME DEVE ESSERE "nome, cognome" TASSATIVAMENTE altrimenti non funziona
		JLabel textLbl = new JLabel("Testo da filtrare");
		filterfield = new JTextField("la sintassi per Staff è nome, cognome");
		constraints.gridy = 1;
		constraints.gridx = 0;
		newPanel.add(textLbl, constraints);
		constraints.gridx = 1;
		newPanel.add(filterfield, constraints);
		
		//creo il bottone per avviare il filtro
		JButton enterButton = new JButton("Esegui filtro");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		
		//lo rendo funzionante
		enterButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setValuefilter(filterfield.getText());
				setColumnfilter((String) columns.getSelectedItem());
				
				//filtro i dati passati prima di creare la nuova tabella
				QueryMaker query = new QueryMaker();
				datalist = query.ArrayFilter(datalist, columnfilter, valuefilter);
				/* stampa di controllo 
				System.out.println(getColumnfilter());
				System.out.println(getValuefilter());
				*/
			}	
		});
		
		newPanel.add(enterButton, constraints);
		
		newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Selezione Filtro"));
		
		return newPanel;
	}

	public String getColumnfilter() {
		return columnfilter;
	}

	public void setColumnfilter(String columnfilter) {
		this.columnfilter = columnfilter;
	}

	public String getValuefilter() {
		return valuefilter;
	}

	public void setValuefilter(String valuefilter) {
		this.valuefilter = valuefilter;
	}

	public ArrayList<OrcidData> getDatalist() {
		return datalist;
	}

	public void setDatalist(ArrayList<OrcidData> datalist) {
		this.datalist = datalist;
	}

	
	
}
