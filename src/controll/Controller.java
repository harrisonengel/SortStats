/*******************************************************************/
/*   Program Name:     Lab 3    Sorts                             */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/

package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;
import view.GUI;



public class Controller implements ActionListener{

	private GUI view;
	private Model model;
	
	public Controller() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		String fileName = view.getFileSelection();
		int keys = view.getNumberKeys();
		int[] toDisplay;
		
		if (view.getSortSelection().equalsIgnoreCase("Cocktail Shaker")){
			toDisplay = model.cocktailSort(fileName, keys);
		}
		else if(view.getSortSelection().equalsIgnoreCase("Quicksort")){
			toDisplay = model.quickSort(fileName, keys);
		} else if(view.getSortSelection().equalsIgnoreCase("Heapsort")){
			toDisplay = model.heapSort(fileName, keys);
		} else{
			toDisplay = model.selectionSort(fileName, keys);
		}
		
		view.setComparisons(toDisplay[0]);
		view.setMoves(toDisplay[1]);
		
		} catch (FileNotFoundException fnfe){
			System.out.println("OOPS file not found");
		} catch (IOException ioe){
			System.out.println("OOPS IOException");
		}
	}
	
	public void setGUI(GUI g){
		this.view = g;
		view.btnSort.addActionListener(this);
	}
	
	public void setModel(Model m){
		this.model = m;
		model.setControll(this);
	}
	
}
