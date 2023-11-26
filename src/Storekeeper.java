import java.util.*;
public class Storekeeper extends Employee {
    Scanner sc = new Scanner(System.in);
    public int getNumberofday() {
        return numberofday;
    }

    public void setNumberofday(int numberofday) {
        this.numberofday = numberofday;
    }

    private int numberofday;
    public Storekeeper()
    {
        super();
        numberofday=0;
    }
    public  Storekeeper(String PersonId, String PersonName,String Sex, String Address, String PhoneNumber,String Workshift, int Salary, int numberofday)
    {
        super(PersonId,PersonName,Sex,Address,PhoneNumber,Workshift,Salary);
        this.numberofday=numberofday;
    }
    public void input()
    {
        super.input();
        System.out.print("Enter number of day :");
        numberofday=sc.nextInt();
    }
    @Override
    public String toString()
    {
        return super.toString() +"Number of day :"+ numberofday + "\n";
    }
    public String getFileLine()
    {
        return super.getFileLine() + numberofday +"\n";
    }
    public void Parse(String line)
    {
        try{
            String[] params = line.split(",");
            super.Parse(line);
            numberofday = Integer.parseInt(params[7]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}

