package a1_BI12_006;
import utils.*;
import java.lang.Math;

/**
 * @overview Represents a student
 *
 * @attributes
 * <br>
 * <pre>
 *     id           Integer
 *     name         String
 *     phoneNumber  String
 *     address      String
 * </pre>
 *
 * @object A typical student is < id, name, phoneNumber, address >
 *
 * @abstract_properties
 * mutable(id) = false | optional(id) = false | min(id) = 1 | max(id) = 1e9<br>
 * mutable(name) = true | optional(name) = false | length(name) = 50<br>
 * mutable(phoneNumber) = true | optional(phoneNumber) = false | length(phoneNumber) = 10<br>
 * mutable(address) = true | optional(address) = false | length(address) = 100<br>
 */

public class Student implements Comparable<Student>{
    private static final int S_MIN_ID = 1;
    private static final int S_MAX_ID = (int) 1e9;
    private static final int S_MAX_NAME_LENGTH = 50;
    private static final int S_MAX_PHONE_NUMBER_LENGTH = 10;
    private static final int S_MAX_ADDRESS_LENGTH = 100;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = S_MIN_ID, max = S_MAX_ID)
    private Integer id;
    @DomainConstraint(type = "String", optional = false, length = S_MAX_NAME_LENGTH)
    protected String name;
    @DomainConstraint(type = "String", optional = false, length = S_MAX_PHONE_NUMBER_LENGTH)
    protected String phoneNumber;
    @DomainConstraint(type = "String", optional = false, length = S_MAX_ADDRESS_LENGTH)
    protected String address;

    public Student(@AttrRef("id") Integer id,
                   @AttrRef("name") String name,
                   @AttrRef("phoneNumber") String phoneNumber,
                   @AttrRef("address") String address) throws NotPossibleException {
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

    /**
     * Default constructor for init other subclasses, since they have different "id" attribute.
     * When subclass is initializing, it will check the given parameters first then set the attributes.
     * Hence, we cannot use the other constructor to initialize the attributes, because we have to check the parameters first.
     * So a default constructor is needed.
     */
    public Student() {
        this.id = 0;
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
    }

    // Getters
    @DOpt(type = OptType.Observer)  @AttrRef("id")
    public Integer getId() {return id;}
    @DOpt(type = OptType.Observer)  @AttrRef("address")
    public String getAddress() {return address;}
    @DOpt(type = OptType.Observer)  @AttrRef("name")
    public String getName() {return name;}
    @DOpt(type = OptType.Observer)  @AttrRef("phoneNumber")
    public String getPhoneNumber() {return phoneNumber;}

    // Setters
    @DOpt(type = OptType.Mutator)   @AttrRef("name")
    public void setName(String name) throws NotPossibleException {
        if (!validateName(name)) {
            throw new NotPossibleException("Invalid name");
        } else {
            this.name = name;
        }
    }

    @DOpt(type = OptType.Mutator)   @AttrRef("phoneNumber")
    public void setPhoneNumber(String phoneNumber) throws NotPossibleException {
        if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("Invalid phone number");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    @DOpt(type = OptType.Mutator)   @AttrRef("address")
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
        return (id >= S_MIN_ID && id <= S_MAX_ID);
    }

    @DOpt(type = OptType.Helper)
    protected boolean validateName(String name) {
        return name.length() <= S_MAX_NAME_LENGTH;
    }

    @DOpt(type = OptType.Helper)
    protected boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() <= S_MAX_PHONE_NUMBER_LENGTH;
    }

    @DOpt(type = OptType.Helper)
    protected boolean validateAddress(String address) {
        return address.length() <= S_MAX_ADDRESS_LENGTH;
    }
}