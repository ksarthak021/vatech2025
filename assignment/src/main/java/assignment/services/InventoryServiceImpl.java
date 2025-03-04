package assignment.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.dao.CustomerDAO;
import assignment.dao.InventoryDAO;


@Transactional(propagation = Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService {

	private InventoryDAO inventoryDAO;

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	
	@Override
	public void addInventory(Item item) {
		inventoryDAO.addInventory(item);
	}

	@Override
	public Item getInventory(int id) {
		return inventoryDAO.getInventory(id);
	}

	@Override
	public List<Item> getAll() {
		return inventoryDAO.getAll();
	}

	@Override
	public void updateInventory(Item item) {
		inventoryDAO.updateInventory(item);
	}

	@Override
	public void deleteInventory(int id) {
		inventoryDAO.deleteInventory(id);
	}

	@Override
	public void reorderItem(Item item) {
        System.out.println("️ Stock below reorder level! Reordering item: " + item.getName());
        item.setQty(item.getMaxQty()); 
        inventoryDAO.updateItem(item);
    }


	@Override
    @Transactional
    public void removeItem(int itemId, int quantity) {  
        Item item = inventoryDAO.getItem(itemId);
        if (item != null) {
            int updatedQty = item.getQty() - quantity;
            if (updatedQty < 0) {
                System.out.println("Error: Not enough quantity available to remove!");
            } else {
                item.setQty(updatedQty);
                inventoryDAO.updateItem(item);
                System.out.println(quantity + " items removed. Remaining stock: " + updatedQty);

                
                if (updatedQty < item.getReorderQty()) {
                    reorderItem(item);
                }
            }
        } else {
            System.out.println("Item not found with ID: " + itemId);
        }
    }

	

	

	

}
