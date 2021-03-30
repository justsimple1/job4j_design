package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class House {
    private static final long serialVersionUID = 2L;
    private boolean demolish;
    private int height;
    private int width;
    private int length;
    private int[] numberEmptyRooms;
    private Address address;

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
                + "demolish=" + demolish
                + ", height=" + height
                + ", width=" + width
                + ", length=" + length
                + ", numberEmptyRooms=" + Arrays.toString(numberEmptyRooms)
                + ", address=" + address
                + '}';
    }

    public static void main(String[] args) {
       final House bigHome = new House(true, 180, 250, 350, new int[] {8, 14, 23, 51, 64, 97}, new Address("Heroes avenue", 23));

        Gson json = new GsonBuilder().create();
        System.out.println(json.toJson(bigHome));
        final String bigHomeFromJSON =
                "{"
                    + "\"demolish\":true,"
                    + "\"height\":180,"
                    + "\"width\":250,"
                    + "\"length\":350,"
                    + "\"numberEmptyRooms\":"
                    + "[8,14,23,51,64,97],"
                    + "\"address\":"
                    + "{"
                    + "\"street\":\"Heroes avenue\","
                    + "\"number\":23"
                    + "}"
                + "}";

        final House HomeFromJson = json.fromJson(bigHomeFromJSON, House.class);
        System.out.println(HomeFromJson);
    }
}
