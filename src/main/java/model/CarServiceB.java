package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarServiceB {
	private Long idCarServiceB;
	private Long idCar;
	private String ServiceType;

	public CarServiceB() {
		
	}
	
	
	public CarServiceB(Long idCarServiceB, Long idCar, String serviceType) {
		super();
		this.idCarServiceB = idCarServiceB;
		this.idCar = idCar;
		ServiceType = serviceType;
	}


	@XmlAttribute
	public Long getIdCarServiceB() {
		return idCarServiceB;
	}

	public void setIdCarServiceB(Long idCarServiceB) {
		this.idCarServiceB = idCarServiceB;
	}
	@XmlAttribute
	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}
	@XmlElement
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
		result = prime * result + ((idCarServiceB == null) ? 0 : idCarServiceB.hashCode());
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
		CarServiceB other = (CarServiceB) obj;
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
		if (idCarServiceB == null) {
			if (other.idCarServiceB != null)
				return false;
		} else if (!idCarServiceB.equals(other.idCarServiceB))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarServiceB [idCarServiceB=" + idCarServiceB + ", idCar=" + idCar + ", ServiceType=" + ServiceType
				+ "]";
	}
	
	

}
