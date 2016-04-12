package cane.brothers.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cane.brothers.spring.model.Item;
import cane.brothers.spring.repo.ItemRepository;

@Service
public class ItemService {
	
	  @Autowired
	  private ItemRepository repo;
	  
	
	  public List<Item> getAllItems() {
		  return repo.findAll();
	  }
	  
	  public Item addItem(Item item) {
		  item.setId(null);
		  return repo.saveAndFlush(item);
	  }
	  
	  public Item updateItem(Item item, Integer id) {
		  item.setId(id);
		  return repo.saveAndFlush(item);
	  }
	  
	  public void deleteItem(Integer id) {
		   repo.delete(id);
	  }
	  
	  public List<Item> getAllCheckedItems() {
		  return repo.findByChecked(true);
	  }

	  public List<Item> getAllUncheckedItems() {
		  return repo.findByChecked(false);
	  }
}
