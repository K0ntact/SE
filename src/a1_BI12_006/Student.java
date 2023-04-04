package a1_BI12_006;
import utils.*;
import utils.OptType;

public class Student implements Comparable<Student>{
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 10e9)
    private Integer id;
    @DomainConstraint(type = "String", optional = false, length = 50)
    private String name;
    @DomainConstraint(type = "String", optional = false, length = 10)
    private String phoneNumber;
    @DomainConstraint(type = "String", optional = false, length = 100)
    private String address;

    public Student(Integer id, String name, String phoneNumber, String address) {
        this.id = validateId(id);
        this.name = validateName(name);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.address = validateAddress(address);
    }

    @DOpt(type = OptType.Observer)
    public Integer getId() {return id;}
    @DOpt(type = OptType.Observer)
    public String getAddress() {return address;}
    @DOpt(type = OptType.Observer)
    public String getName() {return name;}
    @DOpt(type = OptType.Observer)
    public String getPhoneNumber() {return phoneNumber;}

    @DOpt(type = OptType.Mutator)
    public void setAddress(String address) {this.address = address;}
    @DOpt(type = OptType.Mutator)
    public void setName(String name) {this.name = name;}
    @DOpt(type = OptType.Mutator)
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    @DOpt(type = OptType.Mutator)
    public void setId(Integer id) {this.id = id;}

    @Override
    public int compareTo(Student std) {
        return this.name.compareTo(std.name);
    }

    @DOpt(type = OptType.Helper)
    private Integer validateId(Integer id) {
        while (true) {
            try {
                if (id < 1 || id > Math.pow(10, 9)) {
                    throw new Exception("Invalid id");
                }
                return id;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid id: ");
                id = Integer.parseInt(System.console().readLine());
            }
        }
    }

    @DOpt(type = OptType.Helper)
    private String validateName(String name) {
        while (true) {
            try {
                if (name.length() > 50) {
                    throw new Exception("Invalid name");
                }
                return name;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid name: ");
                name = System.console().readLine();
            }
        }
    }

    @DOpt(type = OptType.Helper)
    private String validatePhoneNumber(String phoneNumber) {
        while (true) {
            try {
                if (phoneNumber.length() > 10) {
                    throw new Exception("Invalid phone number");
                }
                return phoneNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid phone number: ");
                phoneNumber = System.console().readLine();
            }
        }
    }

    @DOpt(type = OptType.Helper)
    private String validateAddress(String address) {
        while (true) {
            try {
                if (address.length() > 100) {
                    throw new Exception("Invalid address");
                }
                return address;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a valid address: ");
                address = System.console().readLine();
            }
        }
    }
}