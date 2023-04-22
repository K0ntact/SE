package a1_BI12_006;

import utils.*;
/**
 * @overview
 * Represents an undergraduate student, a subclass of Student
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
 * A typical undergraduate student is <id, name, phoneNumber, address>
 *
 * @abstract_properties
 * mutable(id) = false | optional(id) = false | min(id) = 1e5 | max(id) = 1e8<br>
 * mutable(name) = true | optional(name) = false | length(name) = 50<br>
 * mutable(phoneNumber) = true | optional(phoneNumber) = false | length(phoneNumber) = 10<br>
 * mutable(address) = true | optional(address) = false | length(address) = 100<br>
 */

public class UndergradStudent extends Student{
    private static final int UgS_MIN_ID = (int) 1e5;
    private static final int UgS_MAX_ID = (int) 1e8;

    /**
     * @effects
     *  initialise this as < id, name, phoneNumber, address >
     * @throws NotPossibleException
     *  if any of the preconditions are violated
     */
    public UndergradStudent(@AttrRef("id") Integer id,
                            @AttrRef("name") String name,
                            @AttrRef("phoneNumber") String phoneNumber,
                            @AttrRef("address") String address) throws NotPossibleException {
        if(!super.validateId(id)) {
            throw new NotPossibleException("Student: Invalid id");
        }

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

    // Default methods
    @Override
    public String toString() {
        return "UndergradStudent(" + id + ", " + name + ", " + phoneNumber + ", " + address + ")";
    }

    // Helper methods
    @Override
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = UgS_MIN_ID, max = UgS_MAX_ID)
    @DOpt(type = OptType.Helper)
    protected boolean validateId(int id) {
        return (id >= UgS_MIN_ID && id <= UgS_MAX_ID);
    }
}
