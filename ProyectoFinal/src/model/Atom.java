package model;

public class Atom {
	private char atom;

	public Atom() {
		this('p');
	}

	public Atom(char atom) {
		this.atom = atom;
	}

	public char getAtom() {
		return atom;
	}

	public void setAtom(char atom) {
		this.atom = atom;
	}

	@Override
	public String toString() {
		return atom + "";
	}
}
