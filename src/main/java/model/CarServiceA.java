package model;

public class CarServiceA {
	private Long idCarServiceA;
	private Long idCar;
	private String ServiceType;

	public CarServiceA() {

	}

	public CarServiceA(Long idCarServiceA, Long idCar, String serviceType) {
		super();
		this.idCarServiceA = idCarServiceA;
		this.idCar = idCar;
		ServiceType = serviceType;
	}

	public Long getIdCarServiceA() {
		return idCarServiceA;
	}

	public void setIdCarServiceA(Long idCarServiceA) {
		this.idCarServiceA = idCarServiceA;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ServiceType == null) ? 0 : ServiceType.hashCode());
		result = prime * result + ((idCar == null) ? 0 : idCar.hashCode());
		result = prime * result + ((idCarServiceA == null) ? 0 : idCarServiceA.hashCode());
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
		CarServiceA other = (CarServiceA) obj;
		if (ServiceType == null) {
			if (other.ServiceType != null)
				return false;
		} else if (!ServiceType.equals(other.ServiceType))
			return false;
		if (idCar == null) {
			if (other.idCar != null)
				return false;
		} else if (!idCar.equals(other.idCar))
			return false;
		if (idCarServiceA == null) {
			if (other.idCarServiceA != null)
				return false;
		} else if (!idCarServiceA.equals(other.idCarServiceA))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarServiceA [idCarServiceA=" + idCarServiceA + ", idCar=" + idCar + ", ServiceType=" + ServiceType
				+ "]";
	}

}
