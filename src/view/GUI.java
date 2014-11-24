/*******************************************************************/
/*   Program Name:     Lab 3    Sorts                             */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Model;
import controll.Controller;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldComparisons, textFieldMoves;
	private JComboBox<String> comboBoxFile, comboBoxSort;
	private JComboBox<Integer> comboBoxKeys;
	public JButton btnSort;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					Controller control = new Controller();
					control.setGUI(frame);
					Model model = new Model();
					control.setModel(model);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumber = new JLabel("Number of Keys");
		lblNumber.setBounds(31, 33, 81, 14);
		contentPane.add(lblNumber);
		
		comboBoxKeys = new JComboBox<Integer>();
		comboBoxKeys.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {100, 1000, 2000, 5000}));
		comboBoxKeys.setBounds(31, 58, 89, 20);
		contentPane.add(comboBoxKeys);
		
		JLabel lblFileToBe = new JLabel("File to be Used");
		lblFileToBe.setBounds(31, 89, 89, 14);
		contentPane.add(lblFileToBe);
		
		comboBoxFile = new JComboBox<String>();
		comboBoxFile.setModel(new DefaultComboBoxModel<String>(new String[] {"Ascending", "Descending", "Random"}));
		comboBoxFile.setBounds(31, 114, 89, 20);
		contentPane.add(comboBoxFile);
		
		JLabel lblSortingMethod = new JLabel("Sorting Method");
		lblSortingMethod.setBounds(31, 145, 81, 14);
		contentPane.add(lblSortingMethod);
		
		comboBoxSort = new JComboBox<String>();
		comboBoxSort.setModel(new DefaultComboBoxModel<String>(new String[] {"Cocktail Shaker", "Quicksort", "Heapsort", "Selection Sort"}));
		comboBoxSort.setBounds(31, 170, 98, 20);
		contentPane.add(comboBoxSort);
		
		JLabel lblKeyComparisons = new JLabel("Key Comparisons");
		lblKeyComparisons.setBounds(190, 33, 98, 14);
		contentPane.add(lblKeyComparisons);
		
		textFieldComparisons = new JTextField();
		textFieldComparisons.setBounds(298, 30, 145, 20);
		contentPane.add(textFieldComparisons);
		textFieldComparisons.setColumns(10);
		
		JLabel lblKeyMoves = new JLabel("Key Moves");
		lblKeyMoves.setBounds(190, 89, 98, 14);
		contentPane.add(lblKeyMoves);
		
		textFieldMoves = new JTextField();
		textFieldMoves.setBounds(298, 86, 145, 20);
		contentPane.add(textFieldMoves);
		textFieldMoves.setColumns(10);
		
		btnSort = new JButton("Sort!");
		btnSort.setBounds(298, 141, 121, 23);
		contentPane.add(btnSort);
	}
	
	public String getFileSelection(){
		return (String)comboBoxFile.getSelectedItem();
	}
	
	public String getSortSelection(){
		return (String)comboBoxSort.getSelectedItem();
	}
	
	public int getNumberKeys(){
		Integer toReturn = (Integer)comboBoxKeys.getSelectedItem();
		return toReturn.intValue();
	}
	
	public void setComparisons(int i){
		this.textFieldComparisons.setText( "" + i);
	}
	
	public void setMoves(int i){
		this.textFieldMoves.setText("" + i);
	}
	
}
