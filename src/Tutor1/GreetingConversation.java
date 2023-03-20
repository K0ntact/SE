package Tutor1;

public class GreetingConversation {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("Apple", "M-APL-012", Color.B, 2020, true);
        Person person = new Person(1, "John Doe");
        person.setPhone(phone);
        System.out.println("Person ID: " + person.getId());
        System.out.println("Person name: " + person.getName());
        System.out.println("Person phone: " + person.getPhone().getModel());
        person.greet();
    }
}
