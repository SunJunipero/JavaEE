package bean;

import java.util.Date;

public class Person {
    private Long id;
    private String name;
    private Date birth;

    public Person(){

    }

    public Person(Long id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public static Person getPerson(){
        return new Person();
    }

    public static Person getParamPerson(Long id, String name, Date birth){
        return new Person(id, name, birth);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
