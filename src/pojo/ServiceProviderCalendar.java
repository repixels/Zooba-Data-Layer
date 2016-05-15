package pojo;
// Generated May 15, 2016 5:02:58 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ServiceProviderCalendar generated by hbm2java
 */
@Entity
@Table(name="service_provider_calendar"
    ,catalog="zooba_db"
)
public class ServiceProviderCalendar  implements java.io.Serializable {


     private Integer id;
     private Days days;
     private ServiceProvider serviceProvider;
     private Date startingHour;
     private Date endingHour;

    public ServiceProviderCalendar() {
    }

	
    public ServiceProviderCalendar(Days days, ServiceProvider serviceProvider) {
        this.days = days;
        this.serviceProvider = serviceProvider;
    }
    public ServiceProviderCalendar(Days days, ServiceProvider serviceProvider, Date startingHour, Date endingHour) {
       this.days = days;
       this.serviceProvider = serviceProvider;
       this.startingHour = startingHour;
       this.endingHour = endingHour;
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
    @JoinColumn(name="days_id", nullable=false)
    public Days getDays() {
        return this.days;
    }
    
    public void setDays(Days days) {
        this.days = days;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="service_provider_id", nullable=false)
    public ServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }
    
    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="starting_hour", length=8)
    public Date getStartingHour() {
        return this.startingHour;
    }
    
    public void setStartingHour(Date startingHour) {
        this.startingHour = startingHour;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="ending_hour", length=8)
    public Date getEndingHour() {
        return this.endingHour;
    }
    
    public void setEndingHour(Date endingHour) {
        this.endingHour = endingHour;
    }




}


