package com.json.example.util;

import com.json.example.model.Adress;
import com.json.example.model.Person;
import com.json.example.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class PersonHolder {
    public static List<Person> getPerons(){
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("Alex", "Turner", 32);
        person1.setAdress(new Adress("Chefilld", "OldStreet", 217));
        Phone cell = new Phone("cell", "8987876221");
        Phone stanc = new Phone("stanc", "310616");
        person1.addPhone(cell);
        person1.addPhone(stanc);

        persons.add(person1);

        Person person2 = new Person("Nick", "Omalley", 31);
        person2.setAdress(new Adress("Mgn", "Lenina", 735731));
        Phone cell2= new Phone("cell", "9932323131");
        Phone stanc2 = new Phone("stanc", "000333232");
        person2.addPhone(cell2);
        person2.addPhone(stanc2);
        persons.add(person2);
        return persons;

    }

}
