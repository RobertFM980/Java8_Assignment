package stream;

public class Person {
    private String lastName;
    private String firstName;
    private String dateOfBirth;

    public Person(String lastName, String firstName, String dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }
    public int getMonth(){
        String [] separator = dateOfBirth.split("-");
        return Integer.parseInt(separator[1]);
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getName(){
        return lastName+" "+firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
