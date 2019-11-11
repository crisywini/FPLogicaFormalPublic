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

	/**
	 * Metodo que permite agregar un operador
	 * 
	 * @param operator simbolo operador proposicional
	 */
	public void addOperator(char operator) {
		Operator newOperator = new Operator(operator);
		getOperators().add(newOperator);
	}

	/**
	 * Metodo que permite agregar un atomo
	 * 
	 * @param atom simbolo proposicional
	 */
	public void addAtom(char atom) {
		Atom newAtom = new Atom(atom);
		getAtoms().add(newAtom);
	}
	

	@Override
	public String toString() {
		String info = operators.toString() + " " + atoms.toString();
		return info;
	}
}
