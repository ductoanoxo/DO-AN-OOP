package Product;

import javax.swing.text.Style;

public class Clothing extends Product {
    private String material;
    private String color;
    private String style;
    String comba =",";

    public void setStyle(String style) {
        this.style = style;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public String getStyle() {
        return style;
    }

    public Clothing() {
        super();
        material = "";
        color = "";
        style = "";
    }

    public Clothing(String productId, String productName, int price, int quantity, String material, String color, String style) {
        super(productId, productName, price, quantity);
        this.material = material;
        this.color = color;
        this.style = style;
    }
    @Override
    public void input(){
        super.input();
        System.out.print("Material :");
        material = sc.nextLine();
        System.out.print("Color :");
        color = sc.nextLine();
        System.out.print("Style :");
        style = sc.nextLine();
    }
    public void display() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return super.toString() +"Material :"+ material + comba+"Color :"+color + comba +"Style :"+style+"\n";
    }
    @Override
    public String getFileLine()
    {
        return super.getFileLine() + material + comba + color + comba +style+"\n";
    }
    public void Parse(String line)
    {
        String[] params = line.split(",");
        super.Parse(line);
        material = params[5];
        color = params[6];
        style = params[7];
    }
}

