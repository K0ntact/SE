package a1_BI12_006;

import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

public class UndergradStudent extends Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10e5, max = 10e8)
    private Integer id;

    public UndergradStudent(Integer id, String name, String phoneNumber, String address) {
        super(id, name, phoneNumber, address);
        this.id = validateId(id);
    }

    @DOpt(type = OptType.Observer)
    public Integer getId() {return id;}

    @DOpt(type = OptType.Mutator)
    public void setId(Integer id) {this.id = id;}

    @Override
    @DOpt(type = OptType.Helper)
    protected Integer validateId(Integer id) {
        while (true) {
            try {
                if (id < 10e5 || id > 10e8) {
                    throw new Exception("Invalid id");
                }
                return id;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
