package proobs;

import java.util.ArrayList;
import java.util.Stack;

import process.Process;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String>f1 = new ArrayList<String>();
		f1.add("p");
		ArrayList<String>f2 = new ArrayList<String>();
		f2.add("�p");
		f2.add("q");
		
		ArrayList<String>f3 = new ArrayList<String>();
		f3.add("�r");
		
		ArrayList<String>f4 = new ArrayList<String>();
		f4.add("�p");
		f4.add("�q");
		f4.add("r");
		
		
		ArrayList<ArrayList<String>>formulas = new ArrayList<ArrayList<String>>();
		formulas.add(f1);
		formulas.add(f2);
		formulas.add(f3);
		formulas.add(f4);
		System.out.println(Process.isInsatisfacible(formulas,new ArrayList<ArrayList<String>>()));
	}

}
