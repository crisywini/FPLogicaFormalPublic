package proobs;

import java.util.ArrayList;
import java.util.Stack;

import process.FormaClausal;
import process.FormulaBienFormada;
import process.Process;

public class Main {
	public static void main(String[] args) {

//		ArrayList<String>f1 = new ArrayList<String>();
//		f1.add("p");
//		ArrayList<String>f2 = new ArrayList<String>();
//		f2.add("¬p");
//		f2.add("q");
//		
//		ArrayList<String>f3 = new ArrayList<String>();
//		f3.add("¬r");
//		
//		ArrayList<String>f4 = new ArrayList<String>();
//		f4.add("¬p");
//		f4.add("¬q");
//		f4.add("r");
//		
//		
//		ArrayList<ArrayList<String>>formulas = new ArrayList<ArrayList<String>>();
//		formulas.add(f1);
//		formulas.add(f2);
//		formulas.add(f3);
//		formulas.add(f4);
//		System.out.println(Process.isInsatisfacible(formulas,new ArrayList<ArrayList<String>>()));
//	}
		String fbf2 = "((p)↔(q))→(r)";
		FormulaBienFormada fbf = new FormulaBienFormada(fbf2);
		System.out.println(fbf.getClausules(fbf2));
		System.out.println(fbf.toFC());

	}

}
