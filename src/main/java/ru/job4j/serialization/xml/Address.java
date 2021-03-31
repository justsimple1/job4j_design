package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {

    @XmlAttribute
    private String street;
    @XmlAttribute
    private int number;

    public Address() {
    };

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{"
                + "street='" + street + '\''
                + ", number=" + number
                + '}';
    }
}
