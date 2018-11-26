package main_package;

import javax.swing.*;
import java.awt.*;

public class UserInputQuery {
	
	//pre-istanzio i due valori che verranno passati al sistema di filtraggio dall'utente
	private String columnfilter;
	private String valuefilter;
	
	public UserInputQuery() {
		
		//creo e posiziono la finestra
		JFrame framegui = new JFrame();
		framegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framegui.setTitle("Filtro input utente");
		framegui.setSize(300,500);
		framegui.setLocationRelativeTo(null);
		
		//creo il panel e la griglia per collocare gli elementi
		final JPanel newPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
		
		//popolo la finestra con elenchi e input testuali
		String[] columnOptions = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
				"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
				"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
				"activities","relations","badges","children","identifiers"};
		JLabel columnLbl = new JLabel("Attributo da filtrare");
		JComboBox columns = new JComboBox(columnOptions);
		constraints.gridx = 0;
		constraints.gridy = 0;
		newPanel.add(columnLbl, constraints);
		constraints.gridx = 1;
		newPanel.add(columns, constraints);
		
		//creo la casella di testo
		JLabel textLbl = new JLabel("Testo da filtrare");
		JTextField filterfield = new JTextField(15);
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
		newPanel.add(enterButton, constraints);
		
		newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Selezione Filtro"));
		
		framegui.add(newPanel);
		framegui.pack();
		framegui.setVisible(true);
	}
	
}
