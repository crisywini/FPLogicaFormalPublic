package proobs;

import java.util.Stack;

import model.Molecule;
import process.Process;

public class Main {
	public static void main(String[] args) {
		Stack<Character> formulaS = new Stack<Character>();
		String formula = "(((p)v(q))C((q)v(p)))v(p)";
		System.out.println(Process.removeCondicional(formula));
	}

}
