package pojo;
// Generated May 15, 2016 5:02:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Model generated by hbm2java
 */
@Entity
@Table(name="model"
    ,catalog="zooba_db"
    , uniqueConstraints = {@UniqueConstraint(columnNames="name"), @UniqueConstraint(columnNames="nice_name")} 
)
public class Model  implements java.io.Serializable {


     private Integer id;
     private Make make;
     private String name;
     private String niceName;
     private Set<VehicleModel> vehicleModels = new HashSet<VehicleModel>(0);

    public Model() {
    }

	
    public Model(Make make, String name, String niceName) {
        this.make = make;
        this.name = name;
        this.niceName = niceName;
    }
    public Model(Make make, String name, String niceName, Set<VehicleModel> vehicleModels) {
       this.make = make;
       this.name = name;
       this.niceName = niceName;
       this.vehicleModels = vehicleModels;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="make_id", nullable=false)
    public Make getMake() {
        return this.make;
    }
    
    public void setMake(Make make) {
        this.make = make;
    }

    
    @Column(name="name", unique=true, nullable=false, length=150)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="nice_name", unique=true, nullable=false, length=150)
    public String getNiceName() {
        return this.niceName;
    }
    
    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="model")
    public Set<VehicleModel> getVehicleModels() {
        return this.vehicleModels;
    }
    
    public void setVehicleModels(Set<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
    }




}

