package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class Car {

	private Long idCar;
	private Long idCustomer;
	private String vin;
	private String make;
	private String model;
	private String bodytype;
	private int productionYear;
	private String engineCapacity;
	private String fuelType;
	private String exteriorColor;
	@JsonProperty("Cars")
	private List<Car> Cars;

	public Car() {

	}

	public Car(Long idCar, Long idCustomer, String vin, String make, String model, String bodytype, int productionYear,
			String engineCapacity, String fuelType, String exteriorColor) {
		super();
		this.idCar = idCar;
		this.idCustomer = idCustomer;
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.bodytype = bodytype;
		this.productionYear = productionYear;
		this.engineCapacity = engineCapacity;
		this.fuelType = fuelType;
		this.exteriorColor = exteriorColor;
	}

	public List<Car> getCars() {
		return Cars;
	}

	public void setCars(List<Car> cars) {
		Cars = cars;
	}

	@XmlAttribute
	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	@XmlAttribute
	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	@XmlElement
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@XmlElement
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@XmlElement
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement
	public String getBodytype() {
		return bodytype;
	}

	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}

	@XmlElement
	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	@XmlElement
	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@XmlElement
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@XmlElement
	public String getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodytype == null) ? 0 : bodytype.hashCode());
		result = prime * result + ((engineCapacity == null) ? 0 : engineCapacity.hashCode());
		result = prime * result + ((exteriorColor == null) ? 0 : exteriorColor.hashCode());
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + ((idCar == null) ? 0 : idCar.hashCode());
		result = prime * result + ((idCustomer == null) ? 0 : idCustomer.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + productionYear;
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
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
		Car other = (Car) obj;
		if (bodytype == null) {
			if (other.bodytype != null)
				return false;
		} else if (!bodytype.equals(other.bodytype))
			return false;
		if (engineCapacity == null) {
			if (other.engineCapacity != null)
				return false;
		} else if (!engineCapacity.equals(other.engineCapacity))
			return false;
		if (exteriorColor == null) {
			if (other.exteriorColor != null)
				return false;
		} else if (!exteriorColor.equals(other.exteriorColor))
			return false;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (idCar == null) {
			if (other.idCar != null)
				return false;
		} else if (!idCar.equals(other.idCar))
			return false;
		if (idCustomer == null) {
			if (other.idCustomer != null)
				return false;
		} else if (!idCustomer.equals(other.idCustomer))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (productionYear != other.productionYear)
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [idCar=" + idCar + ", idCustomer=" + idCustomer + ", vin=" + vin + ", make=" + make + ", model="
				+ model + ", bodytype=" + bodytype + ", productionYear=" + productionYear + ", engineCapacity="
				+ engineCapacity + ", fuelType=" + fuelType + ", exteriorColor=" + exteriorColor + "]";
	}

}
