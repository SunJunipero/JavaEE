package com.json.example.controller;

import com.json.example.model.Adress;
import com.json.example.model.Person;
import com.json.example.model.Phone;
import com.json.example.util.PersonHolder;

import java.util.List;

public class Main {
    public void toJSON(){
        List<Person> persons = PersonHolder.getPerons();

        StringBuilder builder = new StringBuilder();

        builder.append("{ persons : [ ");
        for (Person person: persons) {
            builder.append("{").
                    append("\"name\" :  ").append("\"").append(person.getFirstName()).append("\",").
                    append("\"surname\" :  ").append("\"").append(person.getLastName()).append("\",").
                    append("\"age\" :  ").append("\"").append(person.getAge()).append("\",");

            Adress adress = person.getAdress();

            builder.append("address: {").
                    append("\"city\" :  ").append("\"").append(adress.getCity()).append("\",").
                    append("\"street\" :  ").append("\"").append(adress.getStreet()).append("\",").
                    append("\"zip\" :  ").append("\"").append(adress.getZipCode()).append("},");

            List<Phone> phones = person.getPhones();
            builder.append("\"phone numbers\": [ ");

            for (Phone phone: phones) {
                builder.append("{\"type\" :  ").append("\"").append(phone.getType()).append("\",").
                        append("\"number\" :  ").append("\"").append(phone.getNumber()).append("\"},");

            }
            builder.append("]");

        }
        builder.append("]}");
        System.out.println(builder);

    }


    public static void main(String[] args)  {
        Main main = new Main();

        main.toJSON();
    }
}
