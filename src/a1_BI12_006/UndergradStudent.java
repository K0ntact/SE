package a1_BI12_006;

import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

public class UndergradStudent extends Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10e5, max = 10e8)
    private Integer id;

    public UndergradStudent() {
        super();
        this.id = 0;
    }

    @DOpt(type = OptType.Observer)
    public Integer getId() {return id;}

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

    @Override
    @DOpt(type = OptType.Helper)
    protected boolean validateId(Integer id) {
        return (id >= Math.pow(10, 5) && id <= Math.pow(10, 8));
    }
}
