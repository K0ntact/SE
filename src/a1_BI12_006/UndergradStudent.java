package a1_BI12_006;

import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview Represents an undergraduate student, a subclass of Student
 *
 * @attributes
 * id          Integer
 * name        String
 * phoneNumber String
 * address     String
 *
 * @object A typical undergraduate student is <id, name, phoneNumber, address>
 *
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 10e5 /\ max(id) = 10e8 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 * mutable(address) = true /\ optional(address) = false /\ length(address) = 100
 */

public class UndergradStudent extends Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10e5, max = 10e8)
    private Integer id;

    public UndergradStudent(Integer id, String name, String phoneNumber, String address) throws NotPossibleException {
        if (!validateId(id)) {
            throw new NotPossibleException("UndergradStudent: Invalid id");
        }
        if (!validateName(name)) {
            throw new NotPossibleException("UndergradStudent: Invalid name");
        }
        if (!validatePhoneNumber(phoneNumber)) {
            throw new NotPossibleException("UndergradStudent: Invalid phone number");
        }
        if (!validateAddress(address)) {
            throw new NotPossibleException("UndergradStudent: Invalid address");
        }

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @DOpt(type = OptType.Observer)
    public Integer getId() {return id;}

    @Override
    @DOpt(type = OptType.Helper)
    protected boolean validateId(Integer id) {
        return (id >= Math.pow(10, 5) && id <= Math.pow(10, 8));
    }
}
