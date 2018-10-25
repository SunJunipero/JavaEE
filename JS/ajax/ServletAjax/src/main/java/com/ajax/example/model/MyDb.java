package com.ajax.example.model;

import java.util.ArrayList;
import java.util.List;

public class MyDb {

    static List<City> cities = new ArrayList<City>();

    static {
        cities.add(new City("Spb", "Russia"));
        cities.add(new City("Moscow", "Russia"));
        cities.add(new City("Pskov", "Russia"));

        cities.add(new City("Ny", "USA"));
        cities.add(new City("LA", "USA"));
        cities.add(new City("Boston", "USA"));

        cities.add(new City("Barcelona", "Spain"));
        cities.add(new City("Madrid", "Spain"));
        cities.add(new City("Valencia", "Spain"));
    }

    static public List<String> getCitiesByCountry(String country){
        ArrayList<String> c = new ArrayList<String>();
        for (City city : MyDb.cities) {
            if (city.getCountry().equals(country)) {
                c.add(city.getName());
            }
        }
        return c;
    }


    static class City{
        private String country;
        private String name;

        public City(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    }

}
