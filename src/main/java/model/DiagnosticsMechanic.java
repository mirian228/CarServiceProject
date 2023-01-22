package model;

public class DiagnosticsMechanic {
	private Long idDiagnosticsMechanic;
	private Long idCarServiceA;
	private Long idEmployees;

	public DiagnosticsMechanic() {
	
	}

	public Long getIdDiagnosticsMechanic() {
		return idDiagnosticsMechanic;
	}

	public void setIdDiagnosticsMechanic(Long idDiagnosticsMechanic) {
		this.idDiagnosticsMechanic = idDiagnosticsMechanic;
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
		result = prime * result + ((idDiagnosticsMechanic == null) ? 0 : idDiagnosticsMechanic.hashCode());
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
		DiagnosticsMechanic other = (DiagnosticsMechanic) obj;
		if (idCarServiceA == null) {
			if (other.idCarServiceA != null)
				return false;
		} else if (!idCarServiceA.equals(other.idCarServiceA))
			return false;
		if (idDiagnosticsMechanic == null) {
			if (other.idDiagnosticsMechanic != null)
				return false;
		} else if (!idDiagnosticsMechanic.equals(other.idDiagnosticsMechanic))
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
		return "DiagnosticsMechanic [idDiagnosticsMechanic=" + idDiagnosticsMechanic + ", idCarServiceA="
				+ idCarServiceA + ", idEmployees=" + idEmployees + "]";
	}



}
