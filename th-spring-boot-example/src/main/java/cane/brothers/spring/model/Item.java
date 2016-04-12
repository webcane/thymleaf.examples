package cane.brothers.spring.model;

import javax.persistence.*;


@Entity
public class Item {
	
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ITEM_ID")
  private Integer id;
  
  @Column
  private boolean checked;
  
  @Column
  private String description;
  
  /**
   * Default constructor
   */
  protected Item() {
  }
  
  /**
   * Constructor
   */
  public Item(boolean checked, String description) {
	  this.checked = checked;
	  this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
