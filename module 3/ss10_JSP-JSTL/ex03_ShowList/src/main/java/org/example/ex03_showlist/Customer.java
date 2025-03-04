package org.example.ex03_showlist;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String address;
    private String image;

    public Customer(String name, String dateOfBirth, String address, String image) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }
}
