package pojo;
// Generated May 23, 2016 7:59:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="zooba_db"
    , uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="phone"), @UniqueConstraint(columnNames="username")} 
)
public class User  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String email;
     private String firstName;
     private String lastName;
     private String phone;
     private String image;
     private String password;
     private Set vehicles = new HashSet(0);
     private Set vehicles_1 = new HashSet(0);

    public User() {
    }

	
    public User(String username, String email, String firstName, String password) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.password = password;
    }
    public User(String username, String email, String firstName, String lastName, String phone, String image, String password, Set vehicles, Set vehicles_1) {
       this.username = username;
       this.email = email;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phone = phone;
       this.image = image;
       this.password = password;
       this.vehicles = vehicles;
       this.vehicles_1 = vehicles_1;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="username", unique=true, nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="email", unique=true, nullable=false, length=62)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="first_name", nullable=false, length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="phone", unique=true, length=50)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="image")
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_vehicles", catalog="zooba_db", joinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="vehicle_id", nullable=false, updatable=false) })
    public Set getVehicles() {
        return this.vehicles;
    }
    
    public void setVehicles(Set vehicles) {
        this.vehicles = vehicles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set getVehicles_1() {
        return this.vehicles_1;
    }
    
    public void setVehicles_1(Set vehicles_1) {
        this.vehicles_1 = vehicles_1;
    }




}


