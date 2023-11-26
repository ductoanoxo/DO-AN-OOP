public  class Employee extends Person {
    public String getWorkshift() {
        return Workshift;
    }

    public void setWorkshift(String workshift) {
        Workshift = workshift;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
     private String comba=",";
    private String Workshift;
    private int Salary;
    public Employee()
    {
        super();
        Workshift="";
        Salary =0;
    }
    public Employee(String PersonId, String PersonName,String Sex, String Address, String PhoneNumber,String Workshift, int Salary )
    {
        super(PersonId,PersonName,Sex,Address,PhoneNumber);
        this.Workshift=Workshift;
        this.Salary=Salary;
    }
    public void input()
    {
        super.input();
        System.out.print("Enter the shift :");
        Workshift = sc.nextLine();
        System.out.print("Enter the salary :");
        Salary = sc.nextInt();
    }

    public void display() {
        System.out.print(this);
    }
    @Override
    public String toString()
    {
        return super.toString() +"Work shift :"+ Workshift + comba+"Salary :"+ Salary + "\n";
    }
    @Override
    public String getFileLine()
    {
        return super.getFileLine() + Workshift + comba + Salary + comba;
    }
    public void Parse(String line)
    {
        try{
            super.Parse(line);
            String[] params = line.split(",");
            Workshift = params[5];
            Salary = Integer.parseInt(params[6]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
