package a1_BI12_006;
import utils.*;
import java.lang.Math;

/**
 * @overview Represents a postgraduate student, a subclass of Student
 *
 * @attributes
 * <br>
 * <pre>
 *     id           Integer
 *     name         String
 *     phoneNumber  String
 *     address      String
 *     gpa          Float
 * </pre>
 *
 * @object A typical postgraduate student is <id, name, phoneNumber, address, gpa>
 *
 * @abstract_properties
 * mutable(id) = false | optional(id) = false | min(id) = 1e8 + 1 | max(id) = 1e9<br>
 * mutable(name) = true | optional(name) = false | length(name) = 50<br>
 * mutable(phoneNumber) = true | optional(phoneNumber) = false | length(phoneNumber) = 10<br>
 * mutable(address) = true | optional(address) = false | length(address) = 100<br>
 * mutable(gpa) = true | optional(gpa) = false | min(gpa) = 0.0 | max(gpa) = 4.0<br>
 */

public class PostgradStudent extends Student{
    private static final int PgS_MIN_ID = (int) (1e8 + 1);
    private static final int PgS_MAX_ID = (int) 1e9;
    private static final float MIN_GPA = 0.0f;
    private static final float MAX_GPA = 4.0f;


    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = PgS_MIN_ID, max = PgS_MAX_ID)
    private Integer id;
    @DomainConstraint(type = "Float", optional = false, min = MIN_GPA, max = MAX_GPA)
    private float gpa;

    public PostgradStudent(@AttrRef("id") Integer id,
                           @AttrRef("name") String name,
                           @AttrRef("phoneNumber") String phoneNumber,
                           @AttrRef("address") String address,
                           @AttrRef("gpa") Float gpa) throws NotPossibleException {
        if (!validateId(id)) {
            throw new NotPossibleException("PostgradStudent: Invalid id");
        }
        if (!validateName(name)) {
            throw new NotPossibleException("PostgradStudent: Invalid name");
        }
        if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("PostgradStudent: Invalid phone number");
        }
        if (!validateAddress(address)) {
            throw new NotPossibleException("PostgradStudent: Invalid address");
        }
        if (!validateGpa(gpa)) {
            throw new NotPossibleException("PostgradStudent: Invalid gpa");
        }

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gpa = gpa;
    }

    // Getters
    @DOpt(type = OptType.Observer)  @AttrRef("gpa")
    public float getGpa() {return gpa;}
    @DOpt(type = OptType.Observer)  @AttrRef("id")
    public Integer getId() {return id;}

    // Setters
    @DOpt(type = OptType.Mutator)   @AttrRef("gpa")
    public void setGpa(float gpa) {
        try {
            if (!validateGpa(gpa)) {
                throw new Exception("Invalid gpa");
            } else {
                this.gpa = gpa;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Helper methods
    @Override
    @DOpt(type = OptType.Helper)
    protected boolean validateId(Integer id) {
        return (id >= PgS_MIN_ID && id <= PgS_MAX_ID);
    }

    @DOpt(type = OptType.Helper)
    protected boolean validateGpa(Float gpa) {
        return (gpa >= MIN_GPA && gpa <= MAX_GPA);
    }
}
