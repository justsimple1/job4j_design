package ru.job4j.serialization.xml;

import java.util.Arrays;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "house")
@XmlAccessorType(XmlAccessType.FIELD)
public class House {
    private static final long serialVersionUID = 2L;

    @XmlAttribute
    private boolean demolish;
    @XmlAttribute
    private int height;
    @XmlAttribute
    private int width;
    @XmlAttribute
    private int length;
    private Address address;

    @XmlElementWrapper(name = "numberEmptyRoomses")
    @XmlElement(name = "numberEmptyRooms")
    private int[] numberEmptyRooms;

    public House() {
    };

    public House(boolean demolish, int height, int width, int length, int[] numberEmptyRooms, Address address) {
        this.demolish = demolish;
        this.height = height;
        this.width = width;
        this.length = length;
        this.numberEmptyRooms = numberEmptyRooms;
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{"
                +  "demolish=" + demolish
                +  ", height=" + height
                + ", width=" + width
                +  ", length=" + length
                +  ", numberEmptyRooms=" + Arrays.toString(numberEmptyRooms)
                +   ", address=" + address
                +  '}';
    }
}