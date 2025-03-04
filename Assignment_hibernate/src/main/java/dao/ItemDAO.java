package dao;

import java.util.List;
import hibernate1.Item;

public interface ItemDAO {
    List<Item> getAllItems();
}