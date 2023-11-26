import java.util.Scanner;

public class BillDetails {
    private String date;
    Shopping a = new Shopping();
    Scanner sc = new Scanner(System.in);

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public BillDetails()
    {
        date ="";
    }
    public BillDetails(String date)
    {
        this.date=date;
    }
    public void input()
    {
        System.out.println("Enter a date :");
        date = sc.nextLine();

    }
    public void displayBill()
    {
        System.out.println(this);
    }
    public String toString()
    {
        return "Date :" +date  +",";
    }
}
