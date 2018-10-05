package edu.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "song")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Song {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "duration")
    private int duration;

    @XmlElement(name = "id")
    //@XmlAttribute
    private int id;

    public Song() {
    }

    public Song(String name, int duration, int id) {
        this.name = name;
        this.duration = duration;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", id=" + id +
                '}';
    }
}
