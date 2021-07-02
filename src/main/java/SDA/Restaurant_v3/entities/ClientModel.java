package SDA.Restaurant_v3.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String lastName;
    private String firstName;
    private String email;
    private String password;

    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "clientModel")
    private List<CartModel> cartModelList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "clientModel")
    private List<ReservationsModel> reservationsModelList = new ArrayList<>();



    ///////


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ReservationsModel> getReservationsModelList() {
        return reservationsModelList;
    }

    public void setReservationsModelList(List<ReservationsModel> reservationsModelList) {
        this.reservationsModelList = reservationsModelList;
    }

    public List<CartModel> getCartModelList() {
        return cartModelList;
    }

    public void setCartModelList(List<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
