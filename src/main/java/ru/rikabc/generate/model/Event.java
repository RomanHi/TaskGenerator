package ru.rikabc.generate.model;


import java.util.Objects;

/**
 * @author Roman Khayrullin on 12.09.2018
 * @version 1.0
 */
public class Event {
    private int year;
    private int centure;
    private String name;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "year=" + year +
                ", centure=" + centure +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return year == event.year &&
                centure == event.centure &&
                Objects.equals(name, event.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(year, centure, name);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCenture() {
        return centure;
    }

    public void setCentury(int centure) {
        this.centure = centure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
