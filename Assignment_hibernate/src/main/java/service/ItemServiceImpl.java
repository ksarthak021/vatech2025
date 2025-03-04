package service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hibernate1.Item;
import dao.ItemDAO;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Transactional
    @Override
    public List<Item> getItems() {
        return itemDAO.getAllItems();
    }
}
