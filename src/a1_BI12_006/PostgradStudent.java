package a1_BI12_006;

import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

public class PostgradStudent extends Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10e8 + 1, max = 10e9)
    private Integer id;
    @DomainConstraint(type = "Float", optional = false, min = 0.0f, max = 4.0f)
    private float gpa;

    public PostgradStudent(Integer id, String name, String phoneNumber, String address, float gpa) {
        super(id, name, phoneNumber, address);
        this.id = validateId(id);
        this.gpa = validateGpa(gpa);
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @DOpt(type = OptType.Helper)
    protected Integer validateId(Integer id) {
        while (true) {
            try {
                if (id < 10e8 + 1 || id > Math.pow(10, 9)) {
                    throw new Exception("Invalid id");
                }
                return id;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @DOpt(type = OptType.Helper)
    protected Float validateGpa(Float gpa) {
        while (true) {
            try {
                if (gpa < 0.0f || gpa > 4.0f) {
                    throw new Exception("Invalid gpa");
                }
                return gpa;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
