package a1_BI12_006;

import utils.*;

/**
 * @overview
 * Represents a student
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
 * @object
 * A typical student is < id, name, phoneNumber, address >
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
    protected int id;
    @DomainConstraint(type = "String", optional = false, length = S_MAX_NAME_LENGTH)
    protected String name;
    @DomainConstraint(type = "String", optional = false, length = S_MAX_PHONE_NUMBER_LENGTH)
    protected String phoneNumber;
    @DomainConstraint(type = "String", optional = false, length = S_MAX_ADDRESS_LENGTH)
    protected String address;

    /**
     * Constructor
     * @effects
     *  initialise this with < id, name, phoneNumber, address >
     * @throws NotPossibleException
     *  if any of the given parameters is invalid
     */
    public Student(@AttrRef("id") int id,
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
    /**
     * @effects
     *  return <tt>this.id</tt>
     */
    @DOpt(type = OptType.Observer)  @AttrRef("id")
    public int getId() {return id;}

    /**
     * @effects
     *  return <tt>this.address</tt>
     */
    @DOpt(type = OptType.Observer)  @AttrRef("address")
    public String getAddress() {return address;}

    /**
     * @effects
     *  return <tt>this.name</tt>
     */
    @DOpt(type = OptType.Observer)  @AttrRef("name")
    public String getName() {return name;}

    /**
     * @effects
     *  return <tt>this.phoneNumber</tt>
     */
    @DOpt(type = OptType.Observer)  @AttrRef("phoneNumber")
    public String getPhoneNumber() {return phoneNumber;}


    // Setters
    /**
     * @effects
     * <pre>
     * if id is not valid
     *      return false
     * else
     *      set this.id = id and return true
     * </pre>
     */
    @DOpt(type = OptType.Mutator)   @AttrRef("name")
    public boolean setName(String name) {
        if (!validateName(name)) {
            return false;
        } else {
            this.name = name;
            return true;
        }
    }

    /**
     * @effects
     * <pre>
     * if phoneNumber is not valid
     *      return false
     * else
     *      set this.phoneNumber = phoneNumber and return true
     * </pre>
     */
    @DOpt(type = OptType.Mutator)   @AttrRef("phoneNumber")
    public boolean setPhoneNumber(String phoneNumber) {
        if (!validatePhoneNumber(phoneNumber)) {
            return false;
        } else {
            this.phoneNumber = phoneNumber;
            return true;
        }
    }

    /**
     * @effects
     * <pre>
     * if address is not valid
     *      return false
     * else
     *      set this.address = address and return true
     * </pre>
     */
    @DOpt(type = OptType.Mutator)   @AttrRef("address")
    public boolean setAddress(String address) {
        if (!validateAddress(address)) {
            return false;
        } else {
            this.address = address;
            return true;
        }
    }


    // Default methods
    /**
     * @param std the object to be compared.
     * @effects
     * Compare current Student object with the given Student object by name.
     */
    @Override
    @DOpt(type = OptType.Default)
    public int compareTo(Student std) {
        return this.name.compareTo(std.getName());
    }

    /**
     * @effects
     * <pre>
     * if this satisfies rep invariant
     *      return true
     * else
     *      return false
     * </pre>
     */
    public boolean repOK() {
        return validateId(id)
                && validateName(name)
                && validatePhoneNumber(phoneNumber)
                && validateAddress(address);
    }

    @Override
    public String toString() {
        return "Student(" + id + ", " + name + ", " + phoneNumber + ", " + address + ")";
    }


    // Helper methods
    /**
     * @param id the id to be checked
     * @effects
     * <pre>
     * if id is valid
     *      return true
     * else
     *      return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateId(int id) {
        return (id >= S_MIN_ID && id <= S_MAX_ID);
    }

    /**
     * @param name the name to be validated
     * @effects
     * <pre>
     * if name is valid
     *      return true
     * else
     *      return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateName(String name) {
        if (name==null || name.length()==0) {
            return false;
        }
        return name.length() <= S_MAX_NAME_LENGTH;
    }

    /**
     * @param phoneNumber the phone number to be validated.
     * @effects
     * <pre>
     * if phoneNumber is valid
     *      return true
     * else
     *      return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    protected boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber==null || phoneNumber.length()==0) {
            return false;
        }
        return phoneNumber.length() <= S_MAX_PHONE_NUMBER_LENGTH;
    }

    /**
     * @param address the address to be validated.
     * @effects
     * <pre>
     * if address is valid
     *      return true
     * else
     *      return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    protected boolean validateAddress(String address) {
        if (address==null || address.length()==0) {
            return false;
        }
        return address.length() <= S_MAX_ADDRESS_LENGTH;
    }
}