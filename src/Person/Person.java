package Person;

import java.util.*;

public class Person {
    private String PersonId;
    private String PersonName;
    private String Sex;
    private String Address;
    private String PhoneNumber;
    String comba =",";
    Scanner sc = new Scanner(System.in);
    public Person()
    {
        PersonId ="";
        PersonName ="";
        Sex ="";
        Address ="";
       PhoneNumber ="";
    }
    public Person(String PersonId,String PersonName, String Sex, String Address, String PhoneNumber)
    {
        this.PersonId=PersonId;
        this.PersonName =PersonName;
        this.Sex=Sex;
        this.Address=Address;
        this.PhoneNumber=PhoneNumber;
    }
    public void setPersonId(String personId) {
        PersonId = personId;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    public String getPersonId() {
        return PersonId;
    }

    public String getPersonName() {
        return PersonName;
    }

    public String getSex() {
        return Sex;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void input() {
        System.out.print("Person ID: ");
        PersonId= sc.nextLine();
        System.out.print("Person name: ");
        PersonName = sc.nextLine();
        System.out.print("Sex: ");
        Sex = sc.nextLine();
        System.out.print("Address: ");
        Address = sc.nextLine();
        System.out.print("Phone number :");
        PhoneNumber = sc.nextLine();
    }
    public void display() {
        System.out.print(this);
    }
    @Override
    public String toString()
    {
        return "Id :" + PersonName +comba+"Name :" + PersonName+comba+"Sex :" + Sex +comba+"Address :" +Address +comba+"Phone number :"+PhoneNumber+comba;
    }
    public String getFileLine()
    {
        return  PersonId +comba+ PersonName+comba+ Sex +comba+Address +comba+PhoneNumber+comba;
    }
    public void Parse(String line)
    {
        try {
            String[] params = line.split(",");
            PersonId = params[0];
            PersonName = params[1];
            Sex = (params[2]);
            Address = (params[3]);
            PhoneNumber = params[4];
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
        }finally {

        }
    }
}
