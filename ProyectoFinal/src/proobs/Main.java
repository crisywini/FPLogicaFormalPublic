package proobs;

import model.Molecule;
import process.Process;

public class Main {
	public static void main(String[] args) {
		String formula = "(p)v(q)";
		Molecule mol;
		try {
			mol = Process.parseString(formula);
			System.out.println(mol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
