package hibernate1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String description;
	private int currentQuantity;
	private int reorderQuantity;
	private int maxQuantity;
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<LiveOrderItem> liveOrderItems;
	
	public void setLiveOrderItems(List<LiveOrderItem> liveOrderItems) {
		this.liveOrderItems = liveOrderItems;
	}
	
	public List<LiveOrderItem> getLiveOrderItems() {
		return liveOrderItems;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public int getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	
	

}
