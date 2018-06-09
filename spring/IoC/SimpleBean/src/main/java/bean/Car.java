package bean;

import java.util.Date;

public class Car {
    private Long id;
    private Date serviceDate;
    private Integer year;
    private String model;
    private Person owner;

    Car(){

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
