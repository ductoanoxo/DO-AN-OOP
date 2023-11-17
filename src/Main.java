import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose;
        ProductList productList = new ProductList();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Input");
            System.out.println("2. Output");
            System.out.println("3. Add");
            System.out.println("4. Edit by Id");
            System.out.println("5. Delete");
            System.out.println("6. Find");
            System.out.println("7. SaveFile");
            System.out.println("8. ReadFile");
            System.out.println("9. Exit");
            System.out.println("Enter your selection:");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    productList.input();
                    break;
                case 2:
                    productList.display();
                    break;
                case 3:
                    productList.add("product.txt");
                    break;
                case 4:
                    productList.editProductbyid();
                    break;
                case 5:
                    // Implement logic to delete a product
                    break;
                case 6:
                    // Implement logic to find a product
                    break;
                case 7:
                    productList.writeToFile("product.txt");
                    break;
                case 8:
                    productList.readFromFile("product.txt");
                    break;
                case 9:
                    System.out.println("Exit !!!!");
                    break;
                default:
                    System.out.println("Error! Try again");
                    break;
            }

        } while (choose != 9);
    }
}
