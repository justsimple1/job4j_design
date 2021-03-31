package ru.job4j.serialization.json;


import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {
    private static final long serialVersionUID = 2L;
    private boolean demolish;
    private int height;
    private int width;
    private int length;
    private int[] numberEmptyRooms;
    private Address address;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isDemolish() {
        return demolish;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int[] getNumberEmptyRooms() {
        return numberEmptyRooms;
    }

    public Address getAddress() {
        return address;
    }

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

       JSONObject jsonAddress = new JSONObject("{"
               + "\"street\":\"Heroes avenue\","
               + "\"number\":23"
               + "}");

       List<Integer> list = new ArrayList<>();
        for (Integer num: bigHome.getNumberEmptyRooms()) {
            list.add(num);
        }
       JSONObject jsonEmptyRooms = new JSONObject(list);

       JSONObject jsonObject = new JSONObject();
       jsonObject.put("demolish", bigHome.isDemolish());
       jsonObject.put("height", bigHome.getHeight());
       jsonObject.put("width", bigHome.getWidth());
       jsonObject.put("length", bigHome.getLength());
       jsonObject.put("emptyRooms", jsonEmptyRooms);
       jsonObject.put("address", jsonAddress);

       System.out.println(jsonObject.toString());
       System.out.println(new JSONObject(bigHome));

    }
}
