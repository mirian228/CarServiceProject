package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PartWarehouse {
	private Long idPartWarehouse;
	private String partId;
	private String partName;
	private String partNumber;
	private int partquantity;
	private String producer;
	private int releaseyear;

	public PartWarehouse() {
	
	}

	public PartWarehouse(Long idPartWarehouse, String partId, String partName, String partNumber, int partquantity,
			String producer, int releaseyear) {
		super();
		this.idPartWarehouse = idPartWarehouse;
		this.partId = partId;
		this.partName = partName;
		this.partNumber = partNumber;
		this.partquantity = partquantity;
		this.producer = producer;
		this.releaseyear = releaseyear;
	}
	@XmlAttribute
	public Long getIdPartWarehouse() {
		return idPartWarehouse;
	}

	public void setIdPartWarehouse(Long idPartWarehouse) {
		this.idPartWarehouse = idPartWarehouse;
	}
	@XmlElement
	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}
	@XmlElement
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	@XmlElement
	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	@XmlElement
	public int getPartquantity() {
		return partquantity;
	}

	public void setPartquantity(int partquantity) {
		this.partquantity = partquantity;
	}
	@XmlElement
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	@XmlElement
	public int getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPartWarehouse == null) ? 0 : idPartWarehouse.hashCode());
		result = prime * result + ((partId == null) ? 0 : partId.hashCode());
		result = prime * result + ((partName == null) ? 0 : partName.hashCode());
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result + partquantity;
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + releaseyear;
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
		PartWarehouse other = (PartWarehouse) obj;
		if (idPartWarehouse == null) {
			if (other.idPartWarehouse != null)
				return false;
		} else if (!idPartWarehouse.equals(other.idPartWarehouse))
			return false;
		if (partId == null) {
			if (other.partId != null)
				return false;
		} else if (!partId.equals(other.partId))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		if (partquantity != other.partquantity)
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (releaseyear != other.releaseyear)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartWarehouse [idPartWarehouse=" + idPartWarehouse + ", partId=" + partId + ", partName=" + partName
				+ ", partNumber=" + partNumber + ", partquantity=" + partquantity + ", producer=" + producer
				+ ", releaseyear=" + releaseyear + "]";
	}



}
