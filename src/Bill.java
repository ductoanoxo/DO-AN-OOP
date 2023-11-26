public class Bill extends BillDetails {
    private String employeeId;
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Shopping getShopping() {
        return shopping;
    }

    public void setShopping(Shopping shopping) {
        this.shopping = shopping;
    }

    private String productid;
    Shopping shopping = new Shopping();

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    private String producttype;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }


    public Bill()
    {
        super();
        employeeId ="";
        productid = "";
    }
    public Bill(String employeeId, String productid)
    {
        this.employeeId =employeeId;
        this.productid = productid;
    }
    public void input()
    {
        super.input();
        System.out.print("Enter employee id :");
        employeeId = sc.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + "Employee Id :" + employeeId +","+"Product type :" +producttype +"," +"Product id :" +productid +"\n";
    }

    public void DisplayBill()
    {
        System.out.println(this);
    }
}
