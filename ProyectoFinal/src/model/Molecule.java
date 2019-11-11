package model;

import java.util.ArrayList;

public class Molecule {
	public ArrayList<Atom> atoms;
	public ArrayList<Operator> operators;

	public Molecule() {
		atoms = new ArrayList<Atom>();
		operators = new ArrayList<Operator>();
	}

	public ArrayList<Atom> getAtoms() {
		return atoms;
	}

	public void setAtoms(ArrayList<Atom> atoms) {
		this.atoms = atoms;
	}

	public ArrayList<Operator> getOperators() {
		return operators;
	}

	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}
}
