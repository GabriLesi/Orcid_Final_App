package main_package;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UIinitiator {
	
	private JFrame frameUI;
	private ArrayList<OrcidData> datalist;
	private ArrayList<OrcidData> filteredlist;
	
	public UIinitiator(ArrayList<OrcidData> datalist) {
		super();
		this.datalist = datalist;
	}
	
	public void start() {
		// TODO Auto-generated method stub
		frameUI.setVisible(true);
	}
	
	private static WindowListener closeWindow = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose();
		}
	};
	private JTextField valueTextField;
	private String valueString;
	private String columnString;
	private String columnToExamineString;
	private JTable table;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createAndShowGUI() {
 
       //Creo il frame e il layout GBL
        
        frameUI = new JFrame("CSV Manager : filtro");
        frameUI.setBounds(100,100,500,500);
        frameUI.setLocationRelativeTo(null);
        frameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frameUI.getContentPane().setLayout(gridBagLayout);
       
        //prime etichette per la GUI e textfield dove inserirò il valore da filtrare
        JLabel lblValoreDaFiltrare = new JLabel("Valore da filtrare");
		GridBagConstraints gbc_lblValoreDaFiltrare = new GridBagConstraints();
		gbc_lblValoreDaFiltrare.anchor = GridBagConstraints.EAST;
		gbc_lblValoreDaFiltrare.insets = new Insets(0, 0, 5, 5);
		gbc_lblValoreDaFiltrare.gridx = 0;
		gbc_lblValoreDaFiltrare.gridy = 0;
		frameUI.getContentPane().add(lblValoreDaFiltrare, gbc_lblValoreDaFiltrare);
		
		//etichetta per la colonna da filtrare
		JLabel lblColonnaDaFiltrare = new JLabel("Colonna da filtrare");
		GridBagConstraints gbc_lblColonnaDaFiltrare = new GridBagConstraints();
		gbc_lblColonnaDaFiltrare.anchor = GridBagConstraints.EAST;
		gbc_lblColonnaDaFiltrare.insets = new Insets(0, 0, 5, 5);
		gbc_lblColonnaDaFiltrare.gridx = 0;
		gbc_lblColonnaDaFiltrare.gridy = 1;
		frameUI.getContentPane().add(lblColonnaDaFiltrare, gbc_lblColonnaDaFiltrare);
		
		//textfield per il valore da filtrare
		valueTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		frameUI.getContentPane().add(valueTextField, gbc_textField);
		valueTextField.setColumns(10);
        
		//combobox con i dati che indicano la colonna
		String[] columnOptions = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
				"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
				"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
				"activities","relations","badges","children","identifiers"};
		JComboBox comboBox = new JComboBox(columnOptions);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		frameUI.getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblColonnaDaEsaminare = new JLabel("Colonna da esaminare dopo il filtro");
		GridBagConstraints gbc_lblColonnaDaEsaminare = new GridBagConstraints();
		gbc_lblColonnaDaEsaminare.anchor = GridBagConstraints.EAST;
		gbc_lblColonnaDaEsaminare.insets = new Insets(0, 0, 5, 5);
		gbc_lblColonnaDaEsaminare.gridx = 0;
		gbc_lblColonnaDaEsaminare.gridy = 2;
		frameUI.getContentPane().add(lblColonnaDaEsaminare, gbc_lblColonnaDaEsaminare);
		
		//combobox con i dati che indicano la colonna
				String[] columnOptionsToExamine = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
						"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
						"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
						"activities","relations","badges","children","identifiers"};
		JComboBox comboBox_colonnaEsamina = new JComboBox(columnOptionsToExamine);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		frameUI.getContentPane().add(comboBox_colonnaEsamina, gbc_comboBox_1);
        
		//creo lo scrollPane dove metterò la tabella per poterla leggere
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		frameUI.getContentPane().add(scrollPane, gbc_scrollPane);
		
		//creo la table dal file, la aggiornerò premendo il bottone
        TableManager tablemanager = new TableManager(datalist);
        table = tablemanager.InitializeTableValues();
        scrollPane.setViewportView(table);
        
        //premo il bottone per aggiornare la tabella, nel caso di errori o messaggio e non faccio nulla o metto una tabella nulla
        JButton filterButton = new JButton("FILTRA !");
		GridBagConstraints gbc_filterButton = new GridBagConstraints();
		gbc_filterButton.gridheight = 3;
		gbc_filterButton.insets = new Insets(0, 0, 5, 0);
		gbc_filterButton.gridx = 2;
		gbc_filterButton.gridy = 0;
		frameUI.getContentPane().add(filterButton, gbc_filterButton);
        
        //Premo il bottone : salvo i valori, chiamo il filtro, cambio la datalist e refresho la tabella
		filterButton.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Salvo i valori da filtrare
				// TODO Auto-generated method stub
				setValueString(valueTextField.getText());
				setColumnString((String)comboBox.getSelectedItem());
				setColumnToExamineString((String)comboBox_colonnaEsamina.getSelectedItem());
				
				/*
				System.out.println(valueString);
				System.out.println(columnString);
				System.out.println(columnToExamineString);
				System.out.println("--------------------------");
				*/
				
				//check che la lista non sia vuota, in quel caso ripristino datalist
				if (valueString.isEmpty()){
					filteredlist = datalist;
					System.out.println("Controllo colonne evitato perchè la lista non è stata filtrata");
				} 
				else {
					//Creo la datalist filtrata - CASTO IN BASE AL VALORE DELLA COLONNA
					QueryMaker filterquery = new QueryMaker(columnString, valueString, datalist, columnToExamineString);
					filteredlist = filterquery.QueryChooser();
					
				}
				//Creo una nuova tabella usando la datalist filtrata (uso un'altra variabile per non perdere quella completa)
				tablemanager.setDatalist(filteredlist);
				table = tablemanager.InitializeTableValues();
				scrollPane.setViewportView(table);
			}
			
		});
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

	public String getValueString() {
		return valueString;
	}

	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

	public String getColumnString() {
		return columnString;
	}

	public void setColumnString(String columnString) {
		this.columnString = columnString;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public String getColumnToExamineString() {
		return columnToExamineString;
	}

	public void setColumnToExamineString(String columnToExamineString) {
		this.columnToExamineString = columnToExamineString;
	}
}
