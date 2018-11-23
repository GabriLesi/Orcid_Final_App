package main_package;

import javax.swing.*;
import java.awt.*;

public class UserInputQuery {
	
	public UserInputQuery() {
		
		//creo e posiziono la finestra
		JFrame framegui = new JFrame();
		framegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framegui.setTitle("Filtro input utente");
		framegui.setSize(300,250);
		framegui.setLocationRelativeTo(null);
		
		//popolo la finestra con elenchi e input testuali
		String[] columnOptions = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
				"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
				"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
				"activities","relations","badges","children","identifiers"};
		final JPanel columnPanel = new JPanel();
		JLabel columnLbl = new JLabel("Columns");
		JComboBox columns = new JComboBox(columnOptions);
		columnPanel.add(columnLbl);
		columnPanel.add(columns);
		
		framegui.add(columnPanel, BorderLayout.CENTER);
		framegui.setVisible(true);
	}
	
}
