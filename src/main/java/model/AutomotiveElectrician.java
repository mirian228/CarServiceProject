package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AutomotiveElectrician {

	private Long idAutomotiveElectrician;

	private Long idCarServiceB;

	private Long idEmployees;
	public AutomotiveElectrician() {
	}

	public AutomotiveElectrician(Long idAutomotiveElectrician, Long idCarServiceB, Long idEmployees) {
		super();
		this.idAutomotiveElectrician = idAutomotiveElectrician;
		this.idCarServiceB = idCarServiceB;
		this.idEmployees = idEmployees;
	}


	@XmlAttribute
	public Long getIdAutomotiveElectrician() {
		return idAutomotiveElectrician;
	}

	public void setIdAutomotiveElectrician(Long idAutomotiveElectrician) {
		this.idAutomotiveElectrician = idAutomotiveElectrician;
	}
	@XmlElement
	public Long getIdCarServiceB() {
		return idCarServiceB;
	}

	public void setIdCarServiceB(Long idCarServiceB) {
		this.idCarServiceB = idCarServiceB;
	}
	@XmlElement
	public Long getIdEmployees() {
		return idEmployees;
	}

	public void setIdEmployees(Long idEmployees) {
		this.idEmployees = idEmployees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutomotiveElectrician == null) ? 0 : idAutomotiveElectrician.hashCode());
		result = prime * result + ((idCarServiceB == null) ? 0 : idCarServiceB.hashCode());
		result = prime * result + ((idEmployees == null) ? 0 : idEmployees.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutomotiveElectrician other = (AutomotiveElectrician) obj;
		if (idAutomotiveElectrician == null) {
			if (other.idAutomotiveElectrician != null)
				return false;
		} else if (!idAutomotiveElectrician.equals(other.idAutomotiveElectrician))
			return false;
		if (idCarServiceB == null) {
			if (other.idCarServiceB != null)
				return false;
		} else if (!idCarServiceB.equals(other.idCarServiceB))
			return false;
		if (idEmployees == null) {
			if (other.idEmployees != null)
				return false;
		} else if (!idEmployees.equals(other.idEmployees))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AutomotiveElectrician [idAutomotiveElectrician=" + idAutomotiveElectrician + ", idCarServiceB="
				+ idCarServiceB + ", idEmployees=" + idEmployees + "]";
	}

}