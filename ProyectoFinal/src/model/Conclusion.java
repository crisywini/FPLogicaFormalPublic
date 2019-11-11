package model;

public class Conclusion {
	private Molecule conclusion;

	public Conclusion() {
		this(new Molecule());
	}

	public Conclusion(Molecule conclusion) {
		this.conclusion = conclusion;
	}

	public Molecule getConclusion() {
		return conclusion;
	}

	public void setConclusion(Molecule conclusion) {
		this.conclusion = conclusion;
	}
}
