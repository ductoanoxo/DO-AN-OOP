import java.util.Scanner;

public class Customer extends Person {
    Scanner sc = new Scanner(System.in);
    public Customer()
    {
        super();
    }
    public Customer(String PersonId,String PersonName, String Sex, String Address, String PhoneNumber)
    {
        super(PersonId,PersonName,Sex,Address,PhoneNumber);
    }
    public void input() {
        super.input();
    }
    public void display() {
        System.out.print(toString());
    }
    @Override
    public String toString()
    {
       return super.toString();
    }
    public String getFileLine()
    {
       return super.getFileLine();
    }
    public void Parse(String line)
    {
        super.Parse(line);
    }

}
