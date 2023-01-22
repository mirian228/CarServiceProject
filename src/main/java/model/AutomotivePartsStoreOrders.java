package model;

import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import jaxb.DateAdapter;
@XmlRootElement
public class AutomotivePartsStoreOrders {
	private Long idCustomer;
	private Long idAutomotivePartsStore;
	private Long idOrder;
	private Date orderDate;
	private Double orderAmount;
	
	
	public AutomotivePartsStoreOrders() {
		
	}


	public AutomotivePartsStoreOrders(Long idCustomer, Long idAutomotivePartsStore, Long idOrder, Date orderDate,
			Double orderAmount) {
		super();
		this.idCustomer = idCustomer;
		this.idAutomotivePartsStore = idAutomotivePartsStore;
		this.idOrder = idOrder;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}

	@XmlAttribute
	public Long getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	@XmlAttribute
	public Long getIdAutomotivePartsStore() {
		return idAutomotivePartsStore;
	}


	public void setIdAutomotivePartsStore(Long idAutomotivePartsStore) {
		this.idAutomotivePartsStore = idAutomotivePartsStore;
	}

	@XmlAttribute
	public Long getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	@XmlElement
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@XmlElement
	public Double getOrderAmount() {
		return orderAmount;
	}


	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idAutomotivePartsStore, idCustomer, idOrder, orderAmount, orderDate);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutomotivePartsStoreOrders other = (AutomotivePartsStoreOrders) obj;
		return Objects.equals(idAutomotivePartsStore, other.idAutomotivePartsStore)
				&& Objects.equals(idCustomer, other.idCustomer) && Objects.equals(idOrder, other.idOrder)
				&& Objects.equals(orderAmount, other.orderAmount) && Objects.equals(orderDate, other.orderDate);
	}


	@Override
	public String toString() {
		return "AutomotivePartsStoreOrders [idCustomer=" + idCustomer + ", idAutomotivePartsStore="
				+ idAutomotivePartsStore + ", idOrder=" + idOrder + ", orderDate=" + orderDate + ", orderAmount="
				+ orderAmount + "]";
	}
	
	
	
	
	
}
