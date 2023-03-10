package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
@XmlRootElement
public class SuspensionMechanic {
	@JsonProperty("idSuspensionMechanic")
	private Long idSuspensionMechanic;
	@JsonProperty("idCarServiceB")
	private Long idCarServiceB;
	@JsonProperty("idEmployees")
	private Long idEmployees;

	public SuspensionMechanic() {

	}

	public SuspensionMechanic(Long idSuspensionMechanic, Long idCarServiceB, Long idEmployees) {
		this.idSuspensionMechanic = idSuspensionMechanic;
		this.idCarServiceB = idCarServiceB;
		this.idEmployees = idEmployees;
	}
	@XmlAttribute
	public Long getIdSuspensionMechanic() {
		return idSuspensionMechanic;
	}

	public void setIdSuspensionMechanic(Long idSuspensionMechanic) {
		this.idSuspensionMechanic = idSuspensionMechanic;
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
		result = prime * result + ((idSuspensionMechanic == null) ? 0 : idSuspensionMechanic.hashCode());
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
		SuspensionMechanic other = (SuspensionMechanic) obj;
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
		if (idSuspensionMechanic == null) {
			if (other.idSuspensionMechanic != null)
				return false;
		} else if (!idSuspensionMechanic.equals(other.idSuspensionMechanic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuspensionMechanic [idSuspensionMechanic=" + idSuspensionMechanic + ", idCarServiceB=" + idCarServiceB
				+ ", idEmployees=" + idEmployees + "]";
	}

}
