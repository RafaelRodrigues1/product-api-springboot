package br.com.exerciciosspringboot.productwebservice.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.exerciciosspringboot.productwebservice.entities.enums.OrderStatus;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private int orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL)
	private Set<OrderItem> orderItems = new HashSet<>();
	
	public Order() {}

	public Order(Instant moment, OrderStatus orderStatus, User client) {
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}
	
	public Double getTotal() {
		return orderItems.stream()
				.map(orderItem -> orderItem.getSubTotal())
				.reduce((subTotal1, subTotal2) -> subTotal1 + subTotal2).get();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(this.orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id;
	}
}
