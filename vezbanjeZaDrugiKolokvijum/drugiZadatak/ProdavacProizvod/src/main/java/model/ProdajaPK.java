package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the prodaja database table.
 * 
 */
@Embeddable
public class ProdajaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idp;

	@Column(insertable=false, updatable=false)
	private int sifp;

	public ProdajaPK() {
	}
	public int getIdp() {
		return this.idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public int getSifp() {
		return this.sifp;
	}
	public void setSifp(int sifp) {
		this.sifp = sifp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProdajaPK)) {
			return false;
		}
		ProdajaPK castOther = (ProdajaPK)other;
		return 
			(this.idp == castOther.idp)
			&& (this.sifp == castOther.sifp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idp;
		hash = hash * prime + this.sifp;
		
		return hash;
	}
}