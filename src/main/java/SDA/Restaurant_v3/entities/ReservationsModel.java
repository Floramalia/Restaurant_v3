package SDA.Restaurant_v3.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
public class ReservationsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;

    @ManyToOne
    private ClientModel clientModel;

    @OneToMany
    private List<RestaurantTableModel> restaurantTableModelList = new ArrayList<>();

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;


    ///////


    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public List<RestaurantTableModel> getRestaurantTableModelList() {
        return restaurantTableModelList;
    }

    public void setRestaurantTableModelList(List<RestaurantTableModel> restaurantTableModelList) {
        this.restaurantTableModelList = restaurantTableModelList;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }
}
