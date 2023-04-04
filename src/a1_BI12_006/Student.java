package a1_BI12_006;
import utils.*;
import utils.OptType;
import java.lang.Math;

public class Student implements Comparable<Student>{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 10e9)
    private Integer id;
    @DomainConstraint(type = "String", optional = false, length = 50)
    private String name;
    @DomainConstraint(type = "String", optional = false, length = 10)
    private String phoneNumber;
    @DomainConstraint(type = "String", optional = false, length = 100)
    private String address;

    public Student() {
        this.id = 0;
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
    }

    // Getters
    @DOpt(type = OptType.Observer)
    public Integer getId() {return id;}
    @DOpt(type = OptType.Observer)
    public String getAddress() {return address;}
    @DOpt(type = OptType.Observer)
    public String getName() {return name;}
    @DOpt(type = OptType.Observer)
    public String getPhoneNumber() {return phoneNumber;}

    // Setters
    @DOpt(type = OptType.Mutator)
    public void setId(Integer id) {
        try {
            if (!validateId(id)) {
                throw new Exception("Invalid id");
            } else {
                this.id = id;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DOpt(type = OptType.Mutator)
    public void setName(String name) {
        try {
            if (!validateName(name)) {
                throw new Exception("Invalid name");
            } else {
                this.name = name;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DOpt(type = OptType.Mutator)
    public void setPhoneNumber(String phoneNumber) {
        try {
            if (!validatePhoneNumber(phoneNumber)) {
                throw new Exception("Invalid phone number");
            } else {
                this.phoneNumber = phoneNumber;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DOpt(type = OptType.Mutator)
    public void setAddress(String address) {
        try {
            if (!validateAddress(address)) {
                throw new Exception("Invalid address");
            } else {
                this.address = address;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int compareTo(Student std) {
        return this.name.compareTo(std.name);
    }

    // Helper methods
    @DOpt(type = OptType.Helper)
    protected boolean validateId(Integer id) {
        return (id >= 1 && id <= Math.pow(10, 9));
    }

    @DOpt(type = OptType.Helper)
    protected boolean validateName(String name) {
        return name.length() <= 50;
    }

    @DOpt(type = OptType.Helper)
    protected boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() <= 10;
    }

    @DOpt(type = OptType.Helper)
    protected boolean validateAddress(String address) {
        return address.length() <= 100;
    }
}