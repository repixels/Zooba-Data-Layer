package pojo;
// Generated May 15, 2016 5:02:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Coordinates generated by hbm2java
 */
@Entity
@Table(name="coordinates"
    ,catalog="zooba_db"
)
public class Coordinates  implements java.io.Serializable {


     private Integer id;
     private Trips trips;
     private float longitude;
     private float latitude;

    public Coordinates() {
    }

    public Coordinates(Trips trips, float longitude, float latitude) {
       this.trips = trips;
       this.longitude = longitude;
       this.latitude = latitude;
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
    @JoinColumn(name="trips_id", nullable=false)
    public Trips getTrips() {
        return this.trips;
    }
    
    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    
    @Column(name="longitude", nullable=false, precision=10, scale=6)
    public float getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    
    @Column(name="latitude", nullable=false, precision=10, scale=6)
    public float getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }




}


