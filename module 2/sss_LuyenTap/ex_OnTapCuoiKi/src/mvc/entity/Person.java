package mvc.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Person implements Comparable<Student>, Serializable {
    private int code;
    private String name;
    private String address;

    public Person() {
    }

    public Person(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return code == person.code && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public int compareTo(Student o) {
        return this.getCode() - o.getCode();
    }
}