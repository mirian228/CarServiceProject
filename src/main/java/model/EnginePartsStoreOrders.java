package model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
@XmlRootElement
public class EnginePartsStoreOrders {
	@JsonProperty("idCustomer")
	private Long idCustomer;
	@JsonProperty("idEnginePartsStore")
	private Long idEnginePartsStore;
	@JsonProperty("idOrder")
	private Long idOrder;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	@JsonProperty("orderAmount")
	private Double orderAmount;
	@JsonProperty("EnginePartsStoreOrders")
	private List<EnginePartsStoreOrders> EnginePartsStoreOrders;


	public EnginePartsStoreOrders(Long idCustomer, Long idEnginePartsStore, Long idOrder, java.util.Date orderDate,
			Double orderAmount) {
		super();
		this.idCustomer = idCustomer;
		this.idEnginePartsStore = idEnginePartsStore;
		this.idOrder = idOrder;
		this.orderDate = (Date) orderDate;
		this.orderAmount = orderAmount;
	}
	public EnginePartsStoreOrders() {
		
	}
	
	@XmlAttribute
	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	@XmlElement
	public Long getIdEnginePartsStore() {
		return idEnginePartsStore;
	}

	public void setIdEnginePartsStore(Long idEnginePartsStore) {
		this.idEnginePartsStore = idEnginePartsStore;
	}
	@XmlElement
	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	@XmlElement
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
