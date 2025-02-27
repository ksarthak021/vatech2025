package hibernate1;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Long customerId;
    private String status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<LiveOrderItem> liveOrderItems;
    
    public void setLiveOrderItems(List<LiveOrderItem> liveOrderItems) {
		this.liveOrderItems = liveOrderItems;
	}
    
    public List<LiveOrderItem> getLiveOrderItems() {
		return liveOrderItems;
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}

