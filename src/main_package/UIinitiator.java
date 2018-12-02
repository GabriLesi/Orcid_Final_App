package main_package;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class UIinitiator {
	
	private JFrame frameUI;
	private JDialog tableDialog;
	private JPanel tablePanel;
	private ArrayList<OrcidData> datalist;
	
	public UIinitiator(ArrayList<OrcidData> datalist) {
		super();
		this.datalist = datalist;
	}
	
	public void start() {
		// TODO Auto-generated method stub
		frameUI.setVisible(true);
		tableDialog.setVisible(false);
	}
	
	private static WindowListener closeWindow = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
		}
	};
	
	public void createAndShowGUI() {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Insets ins = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        int sw = gc.getBounds().width - ins.left - ins.right;
        int sh = gc.getBounds().height - ins.top - ins.bottom;
       
       //Primo frame
        
        frameUI = new JFrame("filtro");
        frameUI.setSize(400,500);
        frameUI.setLocationRelativeTo(null);
        frameUI.addWindowListener(closeWindow);
        
        //creo il panel e aggiungo al frame
        
        UserInputQuery userAnswer = new UserInputQuery(datalist);
        tablePanel = userAnswer.Panelgenerator();
        
        frameUI.add(tablePanel);
        frameUI.pack();
		frameUI.setVisible(true);
		
        //creo il secondo dialog dove metterò la tabella e il suo panel
        
        tableDialog = new JDialog(frameUI);
        tableDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        tableDialog.setTitle("Una bellissima tabella coi dati dei csv");
        
        TableManager table = new TableManager(datalist);
        JPanel panel = table.initializeTable();
        
        tableDialog.setContentPane(panel);
        tableDialog.pack();
        tableDialog.setVisible(true);
	}

	public ArrayList<OrcidData> getDatalist() {
		return datalist;
	}

	public void setDatalist(ArrayList<OrcidData> datalist) {
		this.datalist = datalist;
	}
	
}
