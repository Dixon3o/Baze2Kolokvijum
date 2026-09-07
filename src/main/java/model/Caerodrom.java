package model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the CAERODROM database table.
 * 
 */
@Entity
@NamedQuery(name="Caerodrom.findAll", query="SELECT c FROM Caerodrom c")
public class Caerodrom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAERODROM_AERODROMID_GENERATOR", sequenceName="CAERODROM_PK", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAERODROM_AERODROMID_GENERATOR")
	@Column(name="AERODROM_ID")
	private long aerodromId;

	private String naziv;

	private String skracenica;

	//bi-directional many-to-one association to Cgrad
	@ManyToOne
	@JoinColumn(name="GRAD_GRAD_ID")
	private Cgrad cgrad;

	//bi-directional many-to-one association to Clet
	@OneToMany(mappedBy="caerodrom1")
	private List<Clet> clets1;

	//bi-directional many-to-one association to Clet
	@OneToMany(mappedBy="caerodrom2")
	private List<Clet> clets2;

	public Caerodrom() {
		this.clets1 = new ArrayList<>();
		this.clets2 = new ArrayList<>();
	}

	public long getAerodromId() {
		return this.aerodromId;
	}

	public void setAerodromId(long aerodromId) {
		this.aerodromId = aerodromId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkracenica() {
		return this.skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}

	public Cgrad getCgrad() {
		return this.cgrad;
	}

	public void setCgrad(Cgrad cgrad) {
		this.cgrad = cgrad;
	}

	public List<Clet> getClets1() {
		return this.clets1;
	}

	public void setClets1(List<Clet> clets1) {
		this.clets1 = clets1;
	}

	public Clet addClets1(Clet clets1) {
		getClets1().add(clets1);
		clets1.setCaerodrom1(this);

		return clets1;
	}

	public Clet removeClets1(Clet clets1) {
		getClets1().remove(clets1);
		clets1.setCaerodrom1(null);

		return clets1;
	}

	public List<Clet> getClets2() {
		return this.clets2;
	}

	public void setClets2(List<Clet> clets2) {
		this.clets2 = clets2;
	}

	public Clet addClets2(Clet clets2) {
		getClets2().add(clets2);
		clets2.setCaerodrom2(this);

		return clets2;
	}

	public Clet removeClets2(Clet clets2) {
		getClets2().remove(clets2);
		clets2.setCaerodrom2(null);

		return clets2;
	}

	@Override
	public String toString() {
		return naziv + " " + skracenica;
	}
	
	

}