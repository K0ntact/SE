package a1_BI12_006;

import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;
import java.lang.Math;

/**
 * @overview Represents a postgraduate student, a type of student
 *
 * @attributes
 * id          Integer
 * name        String
 * phoneNumber String
 * address     String
 * gpa         Float
 *
 * @object A typical postgraduate student is <id, name, phoneNumber, address, gpa>
 *
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 10e8 + 1 /\ max(id) = 10e9 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 100 /\
 * mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0.0 /\ max(gpa) = 4.0
 */

public class PostgradStudent extends Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10e8 + 1, max = 10e9)
    private Integer id;
    @DomainConstraint(type = "Float", optional = false, min = 0.0f, max = 4.0f)
    private float gpa;

    public PostgradStudent(Integer id, String name, String phoneNumber, String address, float gpa) throws NotPossibleException {
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
    @DOpt(type = OptType.Observer)
    public float getGpa() {return gpa;}
    @DOpt(type = OptType.Observer)
    public Integer getId() {return id;}

    // Setters
    @DOpt(type = OptType.Mutator)
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
