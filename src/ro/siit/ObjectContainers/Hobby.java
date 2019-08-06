package ro.siit.ObjectContainers;

import java.util.ArrayList;

public class Hobby {
    String nameOfHobby;
    int frequency;
    ArrayList<String> address;

    public Hobby(String nameOfHobby, int frequency, ArrayList<String> address) {
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "nameOfHobby='" + nameOfHobby + '\'' +
                ", frequency=" + frequency +
                ", address=" + address +
                '}';
    }

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }


}
