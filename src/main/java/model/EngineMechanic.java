package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EngineMechanic {
	@JsonProperty("idEngineMechanic")
	private Long idEngineMechanic;
	@JsonProperty("idCarServiceA")
	private Long idCarServiceA;
	@JsonProperty("idEmployees")
	private Long idEmployees;

	public EngineMechanic() {
	}

	public EngineMechanic(Long idEngineMechanic, Long idCarServiceA, Long idEmployees) {
		super();
		this.idEngineMechanic = idEngineMechanic;
		this.idCarServiceA = idCarServiceA;
		this.idEmployees = idEmployees;
	}

	public Long getIdEngineMechanic() {
		return idEngineMechanic;
	}

	public void setIdEngineMechanic(Long idEngineMechanic) {
		this.idEngineMechanic = idEngineMechanic;
	}

	public Long getIdCarServiceA() {
		return idCarServiceA;
	}

	public void setIdCarServiceA(Long idCarServiceA) {
		this.idCarServiceA = idCarServiceA;
	}

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
		result = prime * result + ((idCarServiceA == null) ? 0 : idCarServiceA.hashCode());
		result = prime * result + ((idEmployees == null) ? 0 : idEmployees.hashCode());
		result = prime * result + ((idEngineMechanic == null) ? 0 : idEngineMechanic.hashCode());
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
		EngineMechanic other = (EngineMechanic) obj;
		if (idCarServiceA == null) {
			if (other.idCarServiceA != null)
				return false;
		} else if (!idCarServiceA.equals(other.idCarServiceA))
			return false;
		if (idEmployees == null) {
			if (other.idEmployees != null)
				return false;
		} else if (!idEmployees.equals(other.idEmployees))
			return false;
		if (idEngineMechanic == null) {
			if (other.idEngineMechanic != null)
				return false;
		} else if (!idEngineMechanic.equals(other.idEngineMechanic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EngineMechanic [idEngineMechanic=" + idEngineMechanic + ", idCarServiceA=" + idCarServiceA
				+ ", idEmployees=" + idEmployees + "]";
	}

}
