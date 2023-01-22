package model;

import java.sql.Date;
import java.util.Objects;

public class EnginePartsStoreOrders {
	private Long idCustomer;
	private Long idEnginePartsStore;
	private Long idOrder;
	private Date orderDate;
	private Double orderAmount;
	
	
	public EnginePartsStoreOrders() {
		
	}


	public Long getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}


	public Long getIdEnginePartsStore() {
		return idEnginePartsStore;
	}


	public void setIdEnginePartsStore(Long idEnginePartsStore) {
		this.idEnginePartsStore = idEnginePartsStore;
	}


	public Long getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Double getOrderAmount() {
		return orderAmount;
	}


	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idCustomer, idEnginePartsStore, idOrder, orderAmount, orderDate);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnginePartsStoreOrders other = (EnginePartsStoreOrders) obj;
		return Objects.equals(idCustomer, other.idCustomer)
				&& Objects.equals(idEnginePartsStore, other.idEnginePartsStore)
				&& Objects.equals(idOrder, other.idOrder) && Objects.equals(orderAmount, other.orderAmount)
				&& Objects.equals(orderDate, other.orderDate);
	}


	@Override
	public String toString() {
		return "EnginePartsStoreOrders [idCustomer=" + idCustomer + ", idEnginePartsStore=" + idEnginePartsStore
				+ ", idOrder=" + idOrder + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount + "]";
	}
	
	
	
}
