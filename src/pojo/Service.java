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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Service generated by hbm2java
 */
@Entity
@Table(name="service"
    ,catalog="zooba_db"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class Service  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<ServiceProviderServices> serviceProviderServiceses = new HashSet<ServiceProviderServices>(0);
     private Set<Type> types = new HashSet<Type>(0);

    public Service() {
    }

	
    public Service(String name) {
        this.name = name;
    }
    public Service(String name, Set<ServiceProviderServices> serviceProviderServiceses, Set<Type> types) {
       this.name = name;
       this.serviceProviderServiceses = serviceProviderServiceses;
       this.types = types;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", unique=true, nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="service")
    public Set<ServiceProviderServices> getServiceProviderServiceses() {
        return this.serviceProviderServiceses;
    }
    
    public void setServiceProviderServiceses(Set<ServiceProviderServices> serviceProviderServiceses) {
        this.serviceProviderServiceses = serviceProviderServiceses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="service")
    public Set<Type> getTypes() {
        return this.types;
    }
    
    public void setTypes(Set<Type> types) {
        this.types = types;
    }




}


