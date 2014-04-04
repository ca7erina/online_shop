package dao;

import java.util.List;

import entity.CartItem;
import entity.Item;

public interface ItemDao {
	public List<Item> FindItemsByOrderId(int orderid) throws Exception ;
}
