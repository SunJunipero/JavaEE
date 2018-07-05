package com.json.example.controller;

import com.json.example.model.Adress;
import com.json.example.model.Person;
import com.json.example.model.Phone;
import com.json.example.util.PersonHolder;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/persons")
public class ManualJSONServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    public void toJSON(){
        List<Person> persons = PersonHolder.getPerons();

        StringBuilder builder = new StringBuilder();

        builder.append("{ persons : [ ");
        for (Person person: persons) {
            builder.append("{").
                    append("'name' :  ").append("'").append(person.getFirstName()).append("',").
                    append("'surname' :  ").append("'").append(person.getLastName()).append("',").
                    append("'age' :  ").append("'").append(person.getAge()).append("',");

            Adress adress = person.getAdress();

            builder.append("address: {").
                    append("'city' :  ").append("'").append(adress.getCity()).append("',").
                    append("'street' :  ").append("'").append(adress.getStreet()).append("',").
                    append("'zip' :  ").append("'").append(adress.getZipCode()).append("},");

            List<Phone> phones = person.getPhones();
            builder.append("'phone numbers': [ ");

            for (Phone phone: phones) {
                builder.append("{'type' :  ").append("'").append(phone.getType()).append("',").
                        append("'number' :  ").append("'").append(phone.getNumber()).append("'},");

            }
            builder.append("]");

        }
        builder.append("]}");
        System.out.println(builder);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(PersonHolder.getPerons());

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(s);
        writer.flush();
        writer.close();


    }
}
