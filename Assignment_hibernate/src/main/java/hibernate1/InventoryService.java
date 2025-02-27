package hibernate1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private ItemDAO itemDAO;

    public void addItem(Item item) {
        itemDAO.save(item);
    }

    public void removeItem(Item item) {
        itemDAO.delete(item);
    }

    public void reorderItem(Item item) {
        if (item.getCurrentQuantity() < item.getReorderQuantity()) {
            item.setCurrentQuantity(item.getMaxQuantity());
            itemDAO.save(item);
        }
    }
}

