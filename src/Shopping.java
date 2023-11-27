import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {
    private int choice;
    ArrayList<Product> shoppingList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
        ProductList productList = new ProductList();

    ArrayList<Bill>billList = new ArrayList<>();
    CustomerList customerList = new CustomerList();
    public void readshop()
    {
        productList.readFromFile("Clothing.txt","Accessories.txt");
        productList.display();
    }

    public void menushop()
    {readshop();
        do {
            System.out.println("Welcome to my fashion shop <3");
            System.out.println("1. Buy");
            System.out.println("2. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    buy();
                    break;
                case 2:
                    System.out.println("Exit !!!!");
                    break;
                default:
                    System.out.println("Error, try again!.");
                    continue;
            }
        } while (choice != 2);

    }
    public void displayShoppingList() {
        System.out.println("Shopping List:");
        // Clothing List
        System.out.println("------------------------------------------------------------------CLOTHING LIST------------------------------------------------------------------");
        boolean clothingFound = false;
        for (Product product : shoppingList) {
            if (product instanceof Clothing) {
                System.out.println("  " + product);
                clothingFound = true;
            }
        }
        if (!clothingFound) {
            System.out.println("  No clothing in the shopping list");
        }

        // Accessories List
        System.out.println("------------------------------------------------------------------ACCESSORIES LIST------------------------------------------------------------------");
        boolean accessoriesFound = false;
        for (Product product : shoppingList) {
            if (product instanceof Accessories) {
                System.out.println("  " + product);
                accessoriesFound = true;
            }
        }
        if (!accessoriesFound) {
            System.out.println("  No accessories in the shopping list");
        }
    }

    public void buy() {
        boolean continueShopping = true;

        do {
            System.out.println("What product do you want to buy?");
            System.out.println("1. Clothing");
            System.out.println("2. Accessories");
            System.out.println("3. Exit!");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    buyClothing();
                    break;
                case 2:
                    buyAccessories();
                    break;
                case 3:
                    System.out.println("Exit !!!!");
                    continueShopping = false;
                    break;
                default:
                    System.out.println("Error, try again!.");
            }

            // Check if the user wants to continue shopping
            if (continueShopping) {
                System.out.print("Do you want to continue shopping? (yes/no): ");
                String continueChoice = sc.next().toLowerCase();
                if (continueChoice.equals("no")) {
                    continueShopping = false;
                    customerList.input();
                    createBill();
                    DisplayBill();
                    System.out.println("Thank you for shopping!");
                }
            }
        } while (continueShopping);
    }

    public void buyClothing() {
        sc.nextLine();
        System.out.print("Enter id product: ");
        String id = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        boolean productFound = false;

        for (Product product : productList.ProductList) {

            if (product.getProductId().equals(id) && product instanceof Clothing) {
                int updatedQuantity = product.getQuantity() - quantity;
                if (updatedQuantity >= 0) {
                    if (!shoppingList.contains(product)) {
                        product.setQuantity(updatedQuantity);
                        shoppingList.add(product);
                        System.out.println("Clothing added to the shopping list.");
                    } else {
                        System.out.println("This clothing is already in the shopping list.");
                    }
                } else {
                    System.out.println("Not enough stock available for the selected clothing.");
                }
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            System.out.println("Clothing not found with the provided ID.");
        }
    }

    public void buyAccessories() {
        sc.nextLine();
        System.out.print("Enter id product: ");
        String id = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        boolean productFound = false;
        for (Product product : productList.ProductList) {
            if (product.getProductId().equals(id) && product instanceof Accessories) {
                int updatedQuantity = product.getQuantity() - quantity;
                if (updatedQuantity >= 0) {
                    if (!shoppingList.contains(product)) {
                        product.setQuantity(updatedQuantity);
                        shoppingList.add(product);
                        System.out.println("Accessories added to the shopping list.");
                    } else {
                        System.out.println("These accessories are already in the shopping list.");
                    }
                } else {
                    System.out.println("Not enough stock available for the selected accessories.");
                }
                //productFound = true;
                break;
            }
        }

        if (!productFound) {
            System.out.println("Accessories not found with the provided ID.");
        }
    }
    public void createBill() {
        Bill bill = new Bill();
        bill.input();
        for (Product product: shoppingList) {
            String productId = product.getProductId();
            int quantity = product.getQuantity();
            if (product instanceof Clothing) {
                // Lấy thông tin từ mỗi phần tử
                String producttype ="Clothing";
                // Thêm thông tin vào đối tượng Bill


                String employeeId = bill.getEmployeeId();
                bill.setEmployeeId(employeeId);
                bill.setProductid(String.valueOf(productId));
                bill.setProducttype(producttype);
                bill.setQuantity(String.valueOf(quantity));

                // Thêm đối tượng Bill vào danh sách hoặc làm điều gì đó khác với nó
                billList.add(bill);
            }
            else
            {
                // Lấy thông tin từ mỗi phần tử
                String producttype ="Accessories";
                // Thêm thông tin vào đối tượng Bill
                String employeeId = bill.getEmployeeId();
                bill.setEmployeeId(employeeId);
                bill.setProductid(String.valueOf(productId));
                bill.setProducttype(producttype);
                bill.setQuantity(String.valueOf(quantity));

                // Thêm đối tượng Bill vào danh sách hoặc làm điều gì đó khác với nó
                billList.add(bill);
            }
        }
    }


    public void DisplayBill()
    {
        System.out.println("------------------------------------------------------------------Bill LIST------------------------------------------------------------------");
        for ( Bill bill : billList)
        {
            bill.displayBill();
        }
    }



}