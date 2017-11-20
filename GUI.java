import java.awt.Container;
import java.util.HashMap;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;

/**
 * 
 *
 * @author Andrew Nguyen
 */

public class GUI extends JFrame {
	
	JMenu menu1, menu2;
	JMenuBar menuBar;
	JMenuItem createAddressBook_main, saveAddressBook_main, DisplayBuddyInfo, addBuddyInfo;
	JTextArea textArea;
	JOptionPane optionPane;
	Container contentPane;
	FlowLayout layout;
	AddressBook_main AddressBook_mainUnit;
	
	//For MVC
	//* JLabel listLabel;
	private JList<String> buddyList;
	DefaultListModel<String> listModel;


	
	public GUI(AddressBook_main AddressBook_main) {
		super("Booking GUI");
		this.AddressBook_mainUnit = AddressBook_main;
		
		//For MVC - Create the model and add elements to List for JList
		listModel = new DefaultListModel<>();
		listRefresh(listModel);
		
		//Create the JList
		//* listLabel = new JLabel("List Edit: ");
		this.buddyList = new JList<>(listModel);
		
		//Create Frame Size
		setLocationRelativeTo(null);
		this.setSize(500, 300);
		layout = new FlowLayout();
		
		contentPane = getContentPane();
		contentPane.setLayout(layout);
		
		//Creating Menu Bar
		menuBar = new JMenuBar();
		
		menu1 = new JMenu("AddressBook_main");
		menu2 = new JMenu("BuddyInfo");
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		//List of menu item for AddressBook_main
		createAddressBook_main = new JMenuItem("Create AddressBook_main");
		saveAddressBook_main = new JMenuItem("Save AddressBook_main");
		DisplayBuddyInfo = new JMenuItem("Display BuddyList");
		menu1.add(createAddressBook_main);
		menu1.add(saveAddressBook_main);
		menu1.addSeparator();
		menu1.add(DisplayBuddyInfo);
		
		//List of menu item for BuddyList
		addBuddyInfo = new JMenuItem("Add a BuddyInfo to AddressBook_main");
		menu2.add(addBuddyInfo);
		
		//ActionListener handler
		theHandler handler = new theHandler();
		createAddressBook_main.addActionListener(handler);
		saveAddressBook_main.addActionListener(handler);
		DisplayBuddyInfo.addActionListener(handler);
		addBuddyInfo.addActionListener(handler);
		
		//For MVC - ListSelectionListener handler
		theListHandler listHandler = new theListHandler();
		buddyList.addListSelectionListener(listHandler);
		buddyList.setVisible(false);
		
		//Disable tabs before Create AddressBook is made
		saveAddressBook_main.setEnabled(false);
		DisplayBuddyInfo.setEnabled(false);
		addBuddyInfo.setEnabled(false);
		
		
		//Setting up final interface
		textArea = new JTextArea(20,30);
		textArea.setEditable(false);
		
		
		this.contentPane.add(textArea);
		//* this.contentPane.add(listLabel);
		this.add(new JScrollPane(buddyList));
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/*
	 * EXTRA METHODS AND LISTENERS
	 */
	
	//For MVC - To Reduce duplication
	private void listRefresh(DefaultListModel<String> listModel) {
		listModel.clear();
		for(int i = 0; i < AddressBook_mainUnit.getSize(); i++) {
			listModel.addElement(AddressBook_mainUnit.getAddressBook_mainListIndex(i));
		}
	}
	
	//Handler for ActionListeners
	private class theHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == createAddressBook_main) {
				System.out.println(e.getActionCommand());
				textArea.setText("Creating AddressBook_main...\n" + "...\n" + "AddressBook_main Created!\n" + "Added Default BuddyInfo list for testing!");
				createAddressBook_main.setEnabled(false);
				saveAddressBook_main.setEnabled(true);
				DisplayBuddyInfo.setEnabled(true);
				addBuddyInfo.setEnabled(true);
			}
			if(e.getSource() == saveAddressBook_main) {
				System.out.println(e.getActionCommand());
				textArea.setText("AddressBook_main Saving...\n" + "...\n" + "AddressBook_main Saved!");
				
				// FIGURE OUT HOW TO SAVE LIST INTO A TEXT FILE
			}
			if(e.getSource() == DisplayBuddyInfo) {
				System.out.println(e.getActionCommand());
				textArea.setText(AddressBook_mainUnit.getAddressBook_mainList());

				//For MVC - Display List of BuddyInfo
				buddyList.setVisible(true);
			}
			if(e.getSource() == addBuddyInfo) {
				String newName = "";
				String newAddress = "";
				String newNumber = "";
				System.out.println(e.getActionCommand());
				newName = JOptionPane.showInputDialog("Enter Name:");
				newAddress = JOptionPane.showInputDialog("Enter Address:");
				newNumber = JOptionPane.showInputDialog("Enter Phone Number: xxx-xxx-xxxx");
				
				//COULD ADD A CHECK CONDITION FOR PROPER PHONE NUMBER FORMAT
				AddressBook_mainUnit.addBuddy(new BuddyInfo(newName,newAddress,newNumber));
				textArea.setText(AddressBook_mainUnit.getAddressBook_mainList());
				
				//For MVC - Update Side List
				listRefresh(listModel);
			}
		}
	}
	
	//For MVC - Handler for ListListeners
	private class theListHandler implements ListSelectionListener{
		JMenuItem option1;
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
                final List<String> selectedValuesList = buddyList.getSelectedValuesList();
                System.out.println(selectedValuesList);
                
                // FIGURE OUT HOW TO DISPLAY MENUITEM WHEN THE NAME IS CLICKED
			}
		}
	}
}
