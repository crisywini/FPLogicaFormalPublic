package model;

import java.util.ArrayList;

public class Argument {
	private ArrayList<Molecule> premises;
	private Conclusion conclusion;

	public Argument() {
		this(new Conclusion());
	}

	public Argument(Conclusion conclusion) {
		premises = new ArrayList<Molecule>();
		this.conclusion = conclusion;
	}

	public ArrayList<Molecule> getPremises() {
		return premises;
	}

	public void setPremises(ArrayList<Molecule> premises) {
		this.premises = premises;
	}

	public Conclusion getConclusion() {
		return conclusion;
	}

	public void setConclusion(Conclusion conclusion) {
		this.conclusion = conclusion;
	}
}