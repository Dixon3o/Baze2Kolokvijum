package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the CLET database table.
 * 
 */
@Entity
@NamedQuery(name="Clet.findAll", query="SELECT c FROM Clet c")
public class Clet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CLET_LETID_GENERATOR", sequenceName="CLET_PK",  allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLET_LETID_GENERATOR")
	@Column(name="LET_ID")
	private long letId;

	private String trajanje;

	private String vreme;

	//bi-directional many-to-one association to Caerodrom
	@ManyToOne
	@JoinColumn(name="POLAZNI_AERODROM_ID")
	private Caerodrom caerodrom1;

	//bi-directional many-to-one association to Caerodrom
	@ManyToOne
	@JoinColumn(name="DOLAZNI_AERODROM_ID")
	private Caerodrom caerodrom2;

	public Clet() {
	}

	public long getLetId() {
		return this.letId;
	}

	public void setLetId(long letId) {
		this.letId = letId;
	}

	public String getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public String getVreme() {
		return this.vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Caerodrom getCaerodrom1() {
		return this.caerodrom1;
	}

	public void setCaerodrom1(Caerodrom caerodrom1) {
		this.caerodrom1 = caerodrom1;
	}

	public Caerodrom getCaerodrom2() {
		return this.caerodrom2;
	}

	public void setCaerodrom2(Caerodrom caerodrom2) {
		this.caerodrom2 = caerodrom2;
	}

	@Override
	public String toString() {
		return trajanje + " "  + vreme  + " " + caerodrom1 + " " + caerodrom2;
	}
	
	

}