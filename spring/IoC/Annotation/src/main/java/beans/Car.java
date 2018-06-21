package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

public class Car {
    private Long id;
    private Date serviceDate;
    private Integer year;
    private String model;

    /**
     * Spring может искать бин по имени (будет искать бин с таким id).
     * Если по имени не найдется, то будет искать по типу
     *
     * Если у нас в конфиг. файле несколько бинов с одним типом, то будет Exception.
     * Необходимо связать по имени или использовать @Qualifier(value = "")
     *
     *  @Autowired - связывание происзодит только тогда, когда объект создается
     *  именно спрингом !!! (не через new)
     */
    @Autowired
    @Qualifier(value = "owner2")
    private Person owner;

    Car(){

    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", serviceDate=" + serviceDate +
                ", year=" + year +
                ", com.musicblog.model='" + model + '\'' +
                ", owner=" + owner +
                '}';
    }

    public Car(Long id, Date serviceDate, Integer year, String model, Person owner) {
        this.id = id;
        this.serviceDate = serviceDate;
        this.year = year;
        this.model = model;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
