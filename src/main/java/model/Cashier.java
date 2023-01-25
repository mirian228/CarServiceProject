package model;

public class Cashier {
	private Long idCashier;
	private Long idEmployees;

	public Cashier() {

	}

	public Cashier(Long idCashier, Long idEmployees) {
		super();
		this.idCashier = idCashier;
		this.idEmployees = idEmployees;
	}

	public Long getIdCashier() {
		return idCashier;
	}

	public void setIdCashier(Long idCashier) {
		this.idCashier = idCashier;
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
		result = prime * result + ((idCashier == null) ? 0 : idCashier.hashCode());
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
		Cashier other = (Cashier) obj;
		if (idCashier == null) {
			if (other.idCashier != null)
				return false;
		} else if (!idCashier.equals(other.idCashier))
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
		return "Cashier [idCashier=" + idCashier + ", idEmployees=" + idEmployees + "]";
	}

}
