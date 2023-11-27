import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class EmployeeList implements method {
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> EmployeeList = new ArrayList<>();

    public void input()
    {
        System.out.print("How many products do you want to import?");
        int quantity = sc.nextInt();
        for ( int i = 0 ; i < quantity;i++)
        {
            System.out.println("Select employee type (1: SaleAgent, 2: Storekeeper)");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    EmployeeList.add(new SaleAgent());
                    break;
                case 2 :
                    EmployeeList.add( new Storekeeper());
                    break;
                default:
                    System.out.println("Error, try againt !.");
                    i--; // Quay lại nhập lựa chọn
                    continue;
            }
            EmployeeList.get(i).input();
        }
        writeToFile("SaleAgent.txt","StoreKeeper.txt");
    }
    public boolean isMatchingfound(Employee employee, int choice  , String id  )
    {
        return  (choice == 1 && employee instanceof SaleAgent && employee.getPersonId().equals(id)) ||
                (choice == 2 && employee instanceof Storekeeper && employee.getPersonId().equals(id));
    }
    public void find() {
        int choice;

        do {
            System.out.println("What kind of employee do you want to find?");
            System.out.println("1. SaleAgent\n2. StoreKeeper");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 1 && choice != 2);

        boolean idFound;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Employee employee : EmployeeList) {
                if (isMatchingfound(employee, choice, id)) {
                    employee.display();
                    idFound = true;
                    break; // Thoát khỏi vòng lặp khi tìm thấy ID
                }
            }

            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }


    public void delete() {
        int choice;

        do {
            System.out.println("What kind of employee do you want to Delete?");
            System.out.println("1. SaleAgent\n2. StoreKeeper");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 1 && choice != 2);

        boolean idFound;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Employee employee : EmployeeList) {
                if (isMatchingfound(employee, choice, id)) {
                    EmployeeList.remove(employee);
                    System.out.println("Employee has been removed.");
                    idFound = true;
                    writeToFile("SaleAgent.txt", "StoreKeeper.txt");
                    break; // Thoát khỏi vòng lặp khi xóa nhân viên
                }
            }

            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }

    public void add()
    {
        System.out.print("How many employee you want to add?");
        int quantity = sc.nextInt();
        for (int i = 0 ; i < quantity;i++)
        {
            System.out.println("Select product type (1:SaleAgent, 2: StoreKeeper)");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    EmployeeList.add(new SaleAgent());
                    break;
                case 2:
                    EmployeeList.add(new Storekeeper());
                    break;
                default:
                    System.out.print("Error ! Try again");
                    i--;
                    continue;
            }
            EmployeeList.get(EmployeeList.size() - 1).input();
        }
        writeToFile("SaleAgent.txt","StoreKeeper.txt");
    }
    public void editbyid() {
        int choice;

        do {
            System.out.println("What kind of employee do you want to Edit?");
            System.out.println("1. SaleAgent\n2. StoreKeeper");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 1 && choice != 2);

        boolean idFound;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Employee employee : EmployeeList) {
                if (isMatchingfound(employee, choice, id)) {
                    employee.input();
                    idFound = true;
                    break;
                }
            }

            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }


    public void display() {
        System.out.println("------------------------------------------------------------------SALEAGENT LIST------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "ID", "Name", "Sex", "Address", "Phone number", "Work shift", "Salary","Product quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        if (EmployeeList.isEmpty()) {
            System.out.println("No clothing products to display.");
        } else {
            for (Employee employee : EmployeeList) {
                if (employee instanceof SaleAgent) {
                    SaleAgent saleAgent = (SaleAgent) employee;
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                            saleAgent.getPersonId(), saleAgent.getPersonName(),
                            saleAgent.getSex(), saleAgent.getAddress(), saleAgent.getPhoneNumber(),saleAgent.getWorkshift(), saleAgent.getSalary(),saleAgent.getProductquantity(), "");
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------STOREKEEPER LIST----------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "ID", "Name", "Sex", "Address", "Phone number", "Work shift", "Salary","Number of day");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

        if (EmployeeList.isEmpty()) {
            System.out.println("No accessories products to display.");
        } else {
            for (Employee employee : EmployeeList) {
                if (employee instanceof Storekeeper) {
                    Storekeeper storekeeper = (Storekeeper)employee;
                    System.out.printf("| %-15s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                            storekeeper.getPersonId(), storekeeper.getPersonName(),
                            storekeeper.getSex(), storekeeper.getAddress(),storekeeper.getPhoneNumber(),storekeeper.getWorkshift(), storekeeper.getSalary(), storekeeper.getNumberofday(),"");
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void writeToFile(String saleagentFileName, String storekeeperFileName) {
        try {
            // Xóa toàn bộ nội dung của tệp cũ
            Files.write(Paths.get(saleagentFileName), new byte[0]);
            Files.write(Paths.get(storekeeperFileName), new byte[0]);

            // Ghi dữ liệu mới vào tệp
            try (FileOutputStream saleagentfos = new FileOutputStream(saleagentFileName, true);
                 FileOutputStream storekeeperfos = new FileOutputStream(storekeeperFileName, true)) {

                for (Employee employee : EmployeeList) {
                    String line = employee.getFileLine() + "\n"; // Thêm ký tự xuống dòng
                    byte[] b = line.getBytes(StandardCharsets.UTF_8);

                    if (employee instanceof SaleAgent) {
                        saleagentfos.write(b);
                    } else if (employee instanceof Storekeeper) {
                        storekeeperfos.write(b);
                    }
                }

                System.out.println("Data has been written to the files successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the files.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file content.");
            e.printStackTrace();
        }
    }

    public void readFromFile(String saleagentFileName, String storekeeperFileName) {
        try (BufferedReader salegentReader = new BufferedReader(new FileReader(saleagentFileName));
             BufferedReader storekeeperReader = new BufferedReader(new FileReader(storekeeperFileName))) {

            // Read clothing file
            String salegentline;
            while ((salegentline = salegentReader.readLine()) != null) {
                if (!salegentline.isEmpty()) {
                    SaleAgent sa = new SaleAgent();
                    sa.Parse(salegentline);
                    EmployeeList.add(sa);
                }
            }

            // Read accessories file
            String storekeeperline;
            while ((storekeeperline = storekeeperReader.readLine()) != null) {
                if (!storekeeperline.isEmpty()) {
                    Storekeeper st = new Storekeeper();
                    st.Parse(storekeeperline);
                    EmployeeList.add(st);
                }
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
