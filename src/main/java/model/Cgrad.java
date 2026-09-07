package model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the CGRAD database table.
 * 
 */
@Entity
@NamedQuery(name="Cgrad.findAll", query="SELECT c FROM Cgrad c")
public class Cgrad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CGRAD_GRADID_GENERATOR", sequenceName="CGRAD_PK", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CGRAD_GRADID_GENERATOR")
	@Column(name="GRAD_ID")
	private long gradId;

	@Column(name="GRAD_NAZIV")
	private String gradNaziv;

	//bi-directional many-to-one association to Caerodrom
	@OneToMany(mappedBy="cgrad")
	private List<Caerodrom> caerodroms;

	public Cgrad() {
		this.caerodroms = new ArrayList<>();
	}

	public long getGradId() {
		return this.gradId;
	}

	public void setGradId(long gradId) {
		this.gradId = gradId;
	}

	public String getGradNaziv() {
		return this.gradNaziv;
	}

	public void setGradNaziv(String gradNaziv) {
		this.gradNaziv = gradNaziv;
	}

	public List<Caerodrom> getCaerodroms() {
		return this.caerodroms;
	}

	public void setCaerodroms(List<Caerodrom> caerodroms) {
		this.caerodroms = caerodroms;
	}

	public Caerodrom addCaerodrom(Caerodrom caerodrom) {
		getCaerodroms().add(caerodrom);
		caerodrom.setCgrad(this);

		return caerodrom;
	}

	public Caerodrom removeCaerodrom(Caerodrom caerodrom) {
		getCaerodroms().remove(caerodrom);
		caerodrom.setCgrad(null);

		return caerodrom;
	}

	@Override
	public String toString() {
		return gradNaziv;
	}
	
	

}