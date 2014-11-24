/*******************************************************************/
/*   Program Name:     Lab 3    Sorts                             */
/*                                                                 */
/*   Student Name:     Harrison Engel                              */
/*   Semester:         Fall 2014                                   */
/*   Class-Section:    COSC 20803-035                              */
/*   Instructor:       Dr. Comer                                   */
/*******************************************************************/
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import controll.Controller;

public class Model {
	private Controller control;
	private static int[] staticArr;
	public Model(){}

	public void setControll(Controller c){
		
		this.control = c;
	}
	
	public int[] selectionSort(String fileName, int keys) throws IOException{
		
		String[] sort = createArray(fileName, keys);
		staticArr = new int[]{0,0};
		for(int i=0; i<(sort.length); i++){
			int j = i;
			for(int p=i+1; p<(sort.length); p++){
				if (sort[j].compareTo(sort[p]) < 0){
					j = p;
				}
				staticArr[0]++;
			}
			String temp = sort[i];
			sort[i] = sort[j];
			sort[j] = temp;
			staticArr[1]+=3;
		}
		for(String a : sort){
			System.out.println(a);
		}
		return staticArr;
	}
	
	public int[] cocktailSort(String fileName, int keys) throws IOException{
		int[] toReturn = new int[2];
		String[] sort = createArray(fileName, keys);
		
		int k = 0, j = keys-1;
		while(k < j){
			for(int i=k; i<j; i++){
				toReturn[0]++;
				if(sort[i].compareToIgnoreCase(sort[i+1]) > 0){
					String temp = sort[i];
					sort[i] = sort[i+1];
					sort[i+1] = temp;
					toReturn[1]+=3;
				}
			}
			--j;
			for(int i=j; i>k; i--){
				toReturn[0]++;
				if(sort[i].compareToIgnoreCase(sort[i-1])<0){
					String temp = sort[i];
					sort[i] = sort[i-1];
					sort[i-1] = temp;
					toReturn[1]+=3;
				}
			}
			++k;
		}
		
		return toReturn;
	}
	
	public int[] quickSort(String fileName, int keys) throws IOException{

		String[] sort = createArray(fileName, keys);
		staticArr = new int[]{0,0};
		quickSortProcess(sort, 0, sort.length - 1);
		for(String a : sort){
			System.out.println(a);
		}
		return staticArr;
	}
	
	private void quickSortProcess(String[] arr, int left, int right){
		if (left < right){
			int i = left;
			int j = right + 1;
			String temp = arr[left];
			
			while (i<j){
				i = i+1;
				while ((i < right) && (arr[i].compareTo(temp) < 0)){
					++staticArr[0];
					i = i+1;
				}

				j=j-1;			
				while((j>left) && (arr[j].compareTo(temp) > 0)){
					++staticArr[0];
					j=j-1;
				}
				String t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				staticArr[1]+=3;
			}
			String t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			staticArr[1]+=3;
			
			t = arr[j];
			arr[j] = arr[left];
			arr[left] = t;
			staticArr[1]+=3;
			//iter++;
			//System.out.println("Made it through iteration " + iter);
			quickSortProcess(arr, left, j-1);
			quickSortProcess(arr,j+1, right);
		} else return;
		
		
	}
	
	public int[] heapSort(String fileName, int keys) throws IOException{
		String[] sort = createArray(fileName, keys);
		staticArr = new int[]{0,0};
		
		for(int i=((sort.length-1)/2); i>=0; i--){
			heapify(sort, i, sort.length-1);
		}
		
		for(int i=(sort.length-2); i>=0; i--){
			String temp = sort [0];
			sort[0] = sort[i+1];
			sort[i+1] = temp;
			staticArr[1]+=3;
			
			heapify(sort, 0, i);
		}
		
		for(int j=0; j<sort.length; j++){
			System.out.println(sort[j]);
		}
		
		return staticArr;
	}
	
	private String[] createArray(String fileName, int keys) throws IOException{
		String[] toReturn = new String[keys];
		BufferedReader br = new BufferedReader(new FileReader("bin/model/" + fileName.trim() + ".dat"));
		for(int i=0; i<keys; i++){
			toReturn[i] = br.readLine().trim();
		}
		br.close();
		return toReturn;
	}
	
	private void heapify(String[] sort, int root, int n){
		boolean notFinished = true;
		String temp = sort[root];
		int j = 2*root;
		
		while ((j<=n) && notFinished){
			if(j<n){
				if(sort[j].compareTo(sort[j+1]) < 0) j+=1;
				staticArr[0]++;
			}
			staticArr[0]++;
			if(temp.compareTo(sort[j]) >= 0) notFinished = false;
			else{
				String t = sort[j];
				sort[j] = sort[j/2];
				sort[j/2] = t;
				staticArr[1]+=3;
				j = 2*j;
			}
		}
		sort[j/2] = temp;
	}
}
