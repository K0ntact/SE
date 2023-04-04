package a1_BI12_006;

import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;
import java.lang.Math;


public class PostgradStudent extends Student{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 10e8 + 1, max = 10e9)
    private Integer id;
    @DomainConstraint(type = "Float", optional = false, min = 0.0f, max = 4.0f)
    private float gpa;

    public PostgradStudent() {
        super();
        this.id = 0;
        this.gpa = 0;
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
    @DOpt(type = OptType.Mutator)
    public void setId(Integer id) {this.id = id;}

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
