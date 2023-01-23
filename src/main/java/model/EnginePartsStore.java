package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnginePartsStore {
	private Long idEnginePartsStore;
	private Long idСashier;
	private Long idPartWarehouse;
	private String partid;
	
	EnginePartsStore() {
		
	}
	
	public EnginePartsStore(Long idEnginePartsStore, Long idСashier, Long idPartWarehouse, String partid) {
		super();
		this.idEnginePartsStore = idEnginePartsStore;
		this.idСashier = idСashier;
		this.idPartWarehouse = idPartWarehouse;
		this.partid = partid;
	}

	@XmlAttribute
	public Long getIdEnginePartsStore() {
		return idEnginePartsStore;
	}

	public void setIdEnginePartsStore(Long idEnginePartsStore) {
		this.idEnginePartsStore = idEnginePartsStore;
	}
	@XmlElement
	public Long getIdСashier() {
		return idСashier;
	}

	public void setIdСashier(Long idСashier) {
		this.idСashier = idСashier;
	}
	@XmlElement
	public Long getIdPartWarehouse() {
		return idPartWarehouse;
	}

	public void setIdPartWarehouse(Long idPartWarehouse) {
		this.idPartWarehouse = idPartWarehouse;
	}
	@XmlElement
	public String getPartid() {
		return partid;
	}

	public void setPartid(String partid) {
		this.partid = partid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEnginePartsStore == null) ? 0 : idEnginePartsStore.hashCode());
		result = prime * result + ((idPartWarehouse == null) ? 0 : idPartWarehouse.hashCode());
		result = prime * result + ((idСashier == null) ? 0 : idСashier.hashCode());
		result = prime * result + ((partid == null) ? 0 : partid.hashCode());
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
		EnginePartsStore other = (EnginePartsStore) obj;
		if (idEnginePartsStore == null) {
			if (other.idEnginePartsStore != null)
				return false;
		} else if (!idEnginePartsStore.equals(other.idEnginePartsStore))
			return false;
		if (idPartWarehouse == null) {
			if (other.idPartWarehouse != null)
				return false;
		} else if (!idPartWarehouse.equals(other.idPartWarehouse))
			return false;
		if (idСashier == null) {
			if (other.idСashier != null)
				return false;
		} else if (!idСashier.equals(other.idСashier))
			return false;
		if (partid == null) {
			if (other.partid != null)
				return false;
		} else if (!partid.equals(other.partid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnginePartsStore [idEnginePartsStore=" + idEnginePartsStore + ", idСashier=" + idСashier
				+ ", idPartWarehouse=" + idPartWarehouse + ", partid=" + partid + "]";
	}

	

}
