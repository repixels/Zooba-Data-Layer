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
 * TrackingTypes generated by hbm2java
 */
@Entity
@Table(name="tracking_types"
    ,catalog="zooba_db"
)
public class TrackingTypes  implements java.io.Serializable {


     private Integer id;
     private TrackingData trackingData;
     private Type type;
     private String value;

    public TrackingTypes() {
    }

	
    public TrackingTypes(TrackingData trackingData, Type type) {
        this.trackingData = trackingData;
        this.type = type;
    }
    public TrackingTypes(TrackingData trackingData, Type type, String value) {
       this.trackingData = trackingData;
       this.type = type;
       this.value = value;
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
    @JoinColumn(name="tracking_data_id", nullable=false)
    public TrackingData getTrackingData() {
        return this.trackingData;
    }
    
    public void setTrackingData(TrackingData trackingData) {
        this.trackingData = trackingData;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="type_id", nullable=false)
    public Type getType() {
        return this.type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }

    
    @Column(name="value")
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}

