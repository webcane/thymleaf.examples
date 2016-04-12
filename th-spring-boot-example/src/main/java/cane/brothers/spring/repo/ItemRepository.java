package cane.brothers.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cane.brothers.spring.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByChecked(boolean checked);
}
