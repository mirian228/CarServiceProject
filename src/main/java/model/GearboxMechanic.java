package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GearboxMechanic {
	private Long idGearboxMechanic;
	private Long idCarServiceB;
	private Long idEmployees;

	public GearboxMechanic() {

	}

	public GearboxMechanic(Long idGearboxMechanic, Long idCarServiceB, Long idEmployees) {
		super();
		this.idGearboxMechanic = idGearboxMechanic;
		this.idCarServiceB = idCarServiceB;
		this.idEmployees = idEmployees;
	}

	@XmlAttribute
	public Long getIdGearboxMechanic() {
		return idGearboxMechanic;
	}

	public void setIdGearboxMechanic(Long idGearboxMechanic) {
		this.idGearboxMechanic = idGearboxMechanic;
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
		result = prime * result + ((idCarServiceB == null) ? 0 : idCarServiceB.hashCode());
		result = prime * result + ((idEmployees == null) ? 0 : idEmployees.hashCode());
		result = prime * result + ((idGearboxMechanic == null) ? 0 : idGearboxMechanic.hashCode());
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
		GearboxMechanic other = (GearboxMechanic) obj;
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
		if (idGearboxMechanic == null) {
			if (other.idGearboxMechanic != null)
				return false;
		} else if (!idGearboxMechanic.equals(other.idGearboxMechanic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GearboxMechanic [idGearboxMechanic=" + idGearboxMechanic + ", idCarServiceB=" + idCarServiceB
				+ ", idEmployees=" + idEmployees + "]";
	}

}
