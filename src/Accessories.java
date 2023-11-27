import java.util.Scanner;

public class Accessories extends Product {
    Scanner sc = new Scanner(System.in);
    private String type;
    private String material;
    String comba = ",";

    public Accessories()
    {
        super();
        type ="";
        material="";
    }


    public Accessories(String productName, String productId, int price, int quantity, String type, String material) {
        super(productName, productId, price, quantity);
        this.type = type;
        this.material = material;
    }

    public void setStyle(String type) {
        this.type = type;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }
    @Override
    public void input(){
        super.input();
        System.out.print("Material :");
        material = sc.nextLine();
        System.out.print("Type :");
        type = sc.nextLine();
    }

    public void display() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return super.toString() +"Material :"+ material + comba +"Type :"+type+"\n";
    }
    @Override
    public String getFileLine()
    {
        return super.getFileLine() + material + comba +type+"\n";
    }
    public void Parse(String line)
    {
        String[] params = line.split(",");
        super.Parse(line);
        material = params[5];
        type = params[6];
    }


}