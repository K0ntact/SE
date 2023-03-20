package Tutor1;

import utils.*;

public class Person {

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    private int id;

    @DomainConstraint(type = "String", optional = false, length = 30)
    private String name;

    @DomainConstraint(type = "MobilePhone")
    private MobilePhone phone;

    public Person(int id, String name) {
        setId(id);
        setName(name);
        this.phone = null;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }
    public MobilePhone getPhone() {
        return phone;
    }

    private void setId(Integer id) {
        if (id >= 1){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("ID must be more than or equal to 1");
        }
    }

    public void setName(String name) throws IllegalArgumentException {
         /* Name must have at least 2 words seperated by a space
         ^: start of string
         [a-zA-Z]+: >=1 letters, can be consider as a word
         //s: space
         $: end of string */
        if(name.matches("^[a-zA-Z]+\\s[a-zA-Z]+$")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must have at least 2 words seperated by a space");
        }
    }
    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name);
    }
}
