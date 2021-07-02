package SDA.Restaurant_v3.entities;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_table")
public class RestaurantTableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int tableNumber;


    /////


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
