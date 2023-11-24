package Person;

public class SaleAgent extends Employee {
    private int productquantity;
    String comba=",";

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }
    public SaleAgent()
    {
        super();
        productquantity=0;
    }
    public  SaleAgent(String PersonId, String PersonName,String Sex, String Address, String PhoneNumber,String Workshift, int Salary, int productquantity)
    {
        super(PersonId,PersonName,Sex,Address,PhoneNumber,Workshift,Salary);
        this.productquantity=productquantity;
    }
    public void display() {
        System.out.print(this);
    }
    @Override
    public String toString()
    {
        return super.toString() +"Product quanntity :"+ productquantity + "\n";
    }
    public void input()
    {
        super.input();
        System.out.print("Enter product quantity :");
        productquantity=sc.nextInt();
    }
    @Override
    public String getFileLine()
    {
        return super.getFileLine() + productquantity +"\n";
    }
    public void Parse(String line)
    {
        try{
            String[] params = line.split(",");
            super.Parse(line);
            productquantity = Integer.parseInt(params[7]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
