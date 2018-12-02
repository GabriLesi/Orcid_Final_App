package main_package;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TableManager extends JPanel {
	 
	ArrayList<OrcidData> datalist = null;
	private static final String[] header = {"id","acronyms","alias","label","creationYear","commercialLabel","address","city","citycode",
			"country","countryCode","postcode","urbanUnit","urbanUnitCode","lat","lon","revenueRange","privateFinanceDate","employees",
			"typeCategoryCode","typeLabel","typeKind","isPublic","leaders","staff","links","privateOrgTypeId","privateOrgTypeLabel",
			"activities","relations","badges","children","identifiers"};
	private JPanel tablepanel = new JPanel();
	
	public TableManager(ArrayList<OrcidData> datalist) {
		super();
		this.datalist = datalist;
	}
	
	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth) {
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        TableColumn column = table.getColumnModel().getColumn(i);
	        //imposto la dimensione standard per tutti i valori, per ora
	        column.setPreferredWidth(tablePreferredWidth);
	    }
	}

	public JPanel initializeTable() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 500));
        
        //creo definitivamente la tabella e la riempio di dati
        TableModel model = new DesignedTableModel(datalist, header);
        JTable table = new JTable(model);
        
        // Fix del resize della tabella
        setBorder(new EmptyBorder(5, 5, 5, 5));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      //metto le dimensioni fisse di righe e colonne per una maggiore leggibilità
        table.setRowHeight(25);
        setJTableColumnsWidth(table, 100);
       //ordina i valori delle righe in base alle colonne
        table.setAutoCreateRowSorter(true);
        
        JScrollPane pane = new JScrollPane(table);
        tablepanel.add(pane, BorderLayout.CENTER);
        
        return tablepanel;
    }

	public List<OrcidData> getDatalist() {
		return datalist;
	}

	public void setDatalist(ArrayList<OrcidData> datalist2) {
		this.datalist = datalist2;
		
		//stampa di controllo
		//System.out.println(datalist.size());
	}
	
}
