package a1_BI12_006;
import utils.*;
import java.lang.Math;

/**
 * @overview Represents a postgraduate student, a type of student
 *
 * @attributes
 * <table>
 *     <tr>
 *         <td>id</td> <td>Integer</td>
 *     </tr>
 *     <tr>
 *         <td>name</td> <td>String</td>
 *     </tr>
 *     <tr>
 *         <td>phoneNumber</td> <td>String</td>
 *     </tr>
 *     <tr>
 *         <td>address</td> <td>String</td>
 *     </tr>
 *     <tr>
 *         <td>gpa</td> <td>Float</td>
 *     </tr>
 * </table>
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
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1e8 + 1, max = 1e9)
    private Integer id;
    @DomainConstraint(type = "Float", optional = false, min = 0.0f, max = 4.0f)
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
        return (id >= Math.pow(10, 8) + 1 && id <= Math.pow(10, 9));
    }

    @DOpt(type = OptType.Helper)
    protected boolean validateGpa(Float gpa) {
        return (gpa >= 0.0f && gpa <= 4.0f);
    }
}
