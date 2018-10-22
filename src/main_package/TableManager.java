package main_package;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TableManager extends JPanel{
	 
	ArrayList<OrcidData> datalist = null;
	String[] header = null;
	Vector<Object> row = null;
	
	public TableManager(ArrayList<OrcidData> datalist, String[] header) {
		super();
		this.datalist = datalist;
		this.header = header;
	}
	
	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth) {
	    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        TableColumn column = table.getColumnModel().getColumn(i);
	        //imposto la dimensione standard per tutti i valori, per ora
	        column.setPreferredWidth(tablePreferredWidth);
	    }
	}

	private void initializeUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 500));
        
        //creo definitivamente la tabella e la riempio di dati
        DefaultTableModel model = new DefaultTableModel(header,0);
        
        //loop di datalist per aggiungere i dati alla tabella, ciclo ogni riga e aggiungo ogni elemento alla colonna
        
        
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
        add(pane, BorderLayout.CENTER);
    }
	
	public void showFrame() {
        JPanel panel = this;
        initializeUI();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Una bellissima tabella coi dati dei csv");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

	public List<OrcidData> getDatalist() {
		return datalist;
	}

	public void setDatalist(ArrayList<OrcidData> datalist2) {
		this.datalist = datalist2;
		
		//stampa di controllo
		System.out.println(datalist.size());
	}

	public void setHeader(String[] csvHeader) {
		this.header = csvHeader;
		//stampa di controllo
		System.out.println(header.length);;
	}
}
