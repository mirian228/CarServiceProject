package model;

public class AutomotivePartsStore {
	private Long idAutomotivePartsStore;
	private Long idСashier;
	private Long idOrders;
	private Long idPartWarehouse;
	private String partid;

	
	public AutomotivePartsStore() {
		
	}


	public Long getIdAutomotivePartsStore() {
		return idAutomotivePartsStore;
	}


	public void setIdAutomotivePartsStore(Long idAutomotivePartsStore) {
		this.idAutomotivePartsStore = idAutomotivePartsStore;
	}


	public Long getIdСashier() {
		return idСashier;
	}


	public void setIdСashier(Long idСashier) {
		this.idСashier = idСashier;
	}


	public Long getIdPartWarehouse() {
		return idPartWarehouse;
	}


	public void setIdPartWarehouse(Long idPartWarehouse) {
		this.idPartWarehouse = idPartWarehouse;
	}


	public String getPartid() {
		return partid;
	}


	public void setPartid(String partid) {
		this.partid = partid;
	}


	public Long getIdOrders() {
		return idOrders;
	}


	public void setIdOrders(Long idOrders) {
		this.idOrders = idOrders;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutomotivePartsStore == null) ? 0 : idAutomotivePartsStore.hashCode());
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
		AutomotivePartsStore other = (AutomotivePartsStore) obj;
		if (idAutomotivePartsStore == null) {
			if (other.idAutomotivePartsStore != null)
				return false;
		} else if (!idAutomotivePartsStore.equals(other.idAutomotivePartsStore))
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
		return "AutomotivePartsStore [idAutomotivePartsStore=" + idAutomotivePartsStore + ", idСashier=" + idСashier
				+ ", idPartWarehouse=" + idPartWarehouse + ", partid=" + partid + "]";
	}
	
	
	
}
