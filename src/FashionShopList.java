import java.util.*;
public class FashionShopList {
    Scanner sc = new Scanner(System.in);
    EmployeeList employeeList = new EmployeeList();
    ProductList productList = new ProductList();
    CustomerList customerList = new CustomerList();
    Shopping shopping = new Shopping();
    int choose;
    int choice;
    public void readall() {
        employeeList.readFromFile("SaleAgent.txt", "StoreKeeper.txt");
        productList.readFromFile("Clothing.txt", "Accessories.txt");
        customerList.readFromFile("Customer.txt");
        employeeList.display();
        productList.display();
        customerList.display();
    }
    public void menu()
    {
        do {
            System.out.println("Who do you want to access");
            System.out.println("1. Admin");
            System.out.println("2. Employee");
            System.out.println("3. Customer");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuEmployee();
                    break;
                case 3:
                    shopping.menushop();
                    choice = 3; // Update choice to exit the loop
                    break;
                case 4:
                    System.out.println("Exit !!!!");
                    break;
                default:
                    System.out.println("Error, try again!");
                    continue;
            }
        } while (choice != 4);
    }
    public void menuAdmin()
    { readall();
        do {
            System.out.println("1. Input");
            System.out.println("2. Display");
            System.out.println("3. Add");
            System.out.println("4. Edit by Id");
            System.out.println("5. Delete");
            System.out.println("6. Find");
            System.out.println("7. Exit");
            System.out.println("Enter your selection:");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("1. Employee");
                    System.out.println("2. Product");
                    choice = sc.nextInt();
                    if ( choice == 1) {
                        employeeList.input();
                    }
                    else {
                        productList.input();
                    }
                    break;
                case 2:
                    productList.display();
                    employeeList.display();
                    break;
                case 3:
                    System.out.println("1. Add employee");
                    System.out.println("2. Add product");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                           employeeList.add();
                            break;
                        case 2:
                            productList.add();
                            break;
                        default:
                            System.out.println("Error, try againt !.");
                            continue;
                    }
                    break;
                case 4:
                    System.out.println("1. Edit employee");
                    System.out.println("2. Edit product");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            employeeList.editbyid();
                            break;
                        case 2:
                            productList.editbyid();
                            break;
                        default:
                            System.out.println("Error, try againt !.");
                            continue;
                    }
                    break;
                case 5:
                    System.out.println("1. Delete employee");
                    System.out.println("2. Delete product");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            employeeList.delete();
                            break;
                        case 2:
                            productList.delete();
                            break;
                        default:
                            System.out.println("Error, try againt !.");
                            continue;
                    }
                    break;
                case 6:
                    System.out.println("1. Find employee");
                    System.out.println("2. Find product");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            employeeList.find();
                            break;
                        case 2:
                            productList.find();
                            break;
                        default:
                            System.out.println("Error, try againt !.");
                            continue;
                    }
                    break;

                case 7:
                    System.out.println("Exit !!!!");
                    break;
                default:
                    System.out.println("Error! Try again");
                    break;
            }

        } while (choose != 7);
    }
    public void menuEmployee()
    {
        do {
            System.out.println("1. Input ");
            System.out.println("2. Output ");
            System.out.println("3. Add");
            System.out.println("4. Edit by Id");
            System.out.println("5. Delete");
            System.out.println("6. Find");
            System.out.println("7. Exit");
            System.out.println("Enter your selection:");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("1. Customer");
                    System.out.println("2. Product");
                    choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            customerList.input();
                            break;
                        case 2:
                            productList.input();
                            break;
                        default:
                            System.out.println("Error, try againt !.");
                            continue;
                    }
                    break;
                case 2:
                    productList.display();
                    break;
                case 3:
                    productList.add();
                    break;
                case 4:
                    productList.editbyid();
                    break;
                case 5:
                    productList.delete();
                    break;
                case 6:
                    productList.find();
                    break;

                case 7:
                    System.out.println("Exit !!!!");
                    break;
                default:
                    System.out.println("Error! Try again");
                    break;
            }
        } while (choose != 7);
    }
}



