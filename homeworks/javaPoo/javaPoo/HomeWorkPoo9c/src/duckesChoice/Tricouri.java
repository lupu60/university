package duckesChoice;


import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Tricouri {
	private String id, descriere, culoare, marime;
	private int nrBucati;

	/**
	 * @param id
	 * @param descriere
	 * @param culoare
	 * @param marime
	 * @param nrBucati
	 */
	public Tricouri(String id, String descriere, String culoare, String marime,
			int nrBucati) {
		super();
		this.id = id;
		this.descriere = descriere;
		this.culoare = culoare;
		this.marime = marime;
		this.nrBucati = nrBucati;
	}

	/** Constructor without parameter */
	public Tricouri() {

	}

	public void pushTricou(int numarDeTricouri) {
		nrBucati += numarDeTricouri;
	}

	public List<Tricouri> popTricou(int numarDeTricouri)
			throws NoSuchElementException {
		if (numarDeTricouri <= nrBucati) {
			nrBucati -= numarDeTricouri;
			return Collections.nCopies(numarDeTricouri, this);
		} else
			throw new NoSuchElementException(
					"Nu exista atatea tricouri in stoc");

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the descriere
	 */
	public String getDescriere() {
		return descriere;
	}

	/**
	 * @return the culoare
	 */
	public String getCuloare() {
		return culoare;
	}

	/**
	 * @return the marime
	 */
	public String getMarime() {
		return marime;
	}

	/**
	 * @return the nrBucati
	 */
	public int getNrBucati() {
		return nrBucati;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param descriere
	 *            the descriere to set
	 */
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	/**
	 * @param culoare
	 *            the culoare to set
	 */
	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	/**
	 * @param marime
	 *            the marime to set
	 */
	public void setMarime(String marime) {
		this.marime = marime;
	}

	/**
	 * @param nrBucati
	 *            the nrBucati to set
	 */
	public void setNrBucati(int nrBucati) {
		this.nrBucati = nrBucati;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tricouri)) {
			return false;
		}
		Tricouri other = (Tricouri) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tricouri [id=" + id + ", descriere=" + descriere + ", culoare="
				+ culoare + ", marime=" + marime + "]";
	}
	
	public int compareToDescriere(Tricouri tr){
		return (-tr.descriere.compareTo(this.descriere));
	}
	public int compareToNrBuc(Tricouri tr){
		return -(tr.nrBucati-this.nrBucati);
	}

}
