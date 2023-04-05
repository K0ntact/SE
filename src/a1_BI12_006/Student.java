package a1_BI12_006;
import utils.*;
import utils.OptType;
import java.lang.Math;

/**
 * @overview Represents a student
 *
 * @attributes
 * id          Integer
 * name        String
 * phoneNumber String
 * address     String
 *
 * @object A typical student is <id, name, phoneNumber, address>
 *
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 10e9 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 100
 */

public class Student implements Comparable<Student>{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 10e9)
    private Integer id;
    @DomainConstraint(type = "String", optional = false, length = 50)
    protected String name;
    @DomainConstraint(type = "String", optional = false, length = 10)
    protected String phoneNumber;
    @DomainConstraint(type = "String", optional = false, length = 100)
    protected String address;

    public Student(Integer id, String name, String phoneNumber, String address) throws NotPossibleException {
        if (!validateId(id)) {
            throw new NotPossibleException("Student: Invalid id");
        }
        if (!validateName(name)) {
            throw new NotPossibleException("Student: Invalid name");
        }
        if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("Student: Invalid phone number");
        }
        if (!validateAddress(address)) {
            throw new NotPossibleException("Student: Invalid address");
        }

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

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
    public void setName(String name) throws NotPossibleException {
        if (!validateName(name)) {
            throw new NotPossibleException("Invalid name");
        } else {
            this.name = name;
        }
    }

    @DOpt(type = OptType.Mutator)
    public void setPhoneNumber(String phoneNumber) throws NotPossibleException {
        if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("Invalid phone number");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    @DOpt(type = OptType.Mutator)
    public void setAddress(String address) throws NotPossibleException {
        if (!validateAddress(address)) {
            throw new NotPossibleException("Invalid address");
        } else {
            this.address = address;
        }
    }

    @Override
    @DOpt(type = OptType.Other)
    public int compareTo(Student std) {
        return this.name.compareTo(std.getName());
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