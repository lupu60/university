package duckesChoice;

public class Tranzactie {
	private String idTricou, tipTranzactie;
	private int bucTranzactionate;

	/**
	 * @param idTricou
	 * @param tipTranzactie
	 * @param bucTranzactionate
	 */
	public Tranzactie(String idTricou, String tipTranzactie,
			int bucTranzactionate) {
		super();
		this.idTricou = idTricou;
		this.tipTranzactie = tipTranzactie;
		this.bucTranzactionate = bucTranzactionate;
	}

	/**
	 * @return the idTricou
	 */
	public String getIdTricou() {
		return idTricou;
	}

	/**
	 * @return the tipTranzactie
	 */
	public String getTipTranzactie() {
		return tipTranzactie;
	}

	/**
	 * @return the bucTranzactionate
	 */
	public int getBucTranzactionate() {
		return bucTranzactionate;
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
		result = prime * result + bucTranzactionate;
		result = prime * result
				+ ((idTricou == null) ? 0 : idTricou.hashCode());
		result = prime * result
				+ ((tipTranzactie == null) ? 0 : tipTranzactie.hashCode());
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
		if (!(obj instanceof Tranzactie)) {
			return false;
		}
		Tranzactie other = (Tranzactie) obj;
		if (bucTranzactionate != other.bucTranzactionate) {
			return false;
		}
		if (idTricou == null) {
			if (other.idTricou != null) {
				return false;
			}
		} else if (!idTricou.equals(other.idTricou)) {
			return false;
		}
		if (tipTranzactie == null) {
			if (other.tipTranzactie != null) {
				return false;
			}
		} else if (!tipTranzactie.equals(other.tipTranzactie)) {
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
		return "Tranzactie [idTricou=" + idTricou + ", tipTranzactie="
				+ tipTranzactie + ", bucTranzactionate=" + bucTranzactionate
				+ "]";
	}

}
