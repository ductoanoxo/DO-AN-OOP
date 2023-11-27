import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CustomerList implements method {
    ArrayList<Customer> CustomerList = new ArrayList<>();
    Scanner sc = new Scanner (System.in);
    public void input()
    {
        Customer customer = new Customer();
        customer.input();
        CustomerList.add(customer);
        writeToFile("Customer.txt");
    }
    public void find()
    {
        boolean idFound = false;
        do {
            System.out.print("Enter id :");
            String id = sc.nextLine();
            for (Customer customer : CustomerList) {
                if (customer.getPersonId().equals(id)) {
                    customer.display();
                    idFound = true;
                }
            }
            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }
        }while (!idFound);
    }
    public void delete() {
        boolean idFound = false;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Customer customer : CustomerList) {
                if (customer.getPersonId().equals(id)) {
                    CustomerList.remove(customer);
                    idFound = true;
                    writeToFile("Customer.txt");
                    break; // Thoát khỏi vòng lặp khi tìm thấy ID
                }
            }

            if (!idFound) {
                System.out.println("Customer with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }

    public void add()
    {
        System.out.print("How many customer u want to add?");
        int quantity = sc.nextInt();
        for ( int i=0; i< quantity ; i++)
        {
            CustomerList.add(new Customer());
            CustomerList.get(CustomerList.size()-1).input();
        }
        writeToFile("Customer.txt");
    }
    public void editById() {
        boolean idFound = false;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Customer customer : CustomerList) {
                if (customer.getPersonId().equals(id)) {
                    customer.input();
                    idFound = true;
                    break; // Thoát khỏi vòng lặp khi tìm thấy ID
                }
            }

            if (!idFound) {
                System.out.println("Customer with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }


    public void writeToFile(String customerfile) {
        try {
            // Xóa toàn bộ nội dung của tệp cũ
            Files.write(Paths.get(customerfile), new byte[0]);
            // Ghi dữ liệu mới vào tệp
            try (FileOutputStream customerfos = new FileOutputStream(customerfile, true))
            {
                for(Customer customer : CustomerList)
                {
                    String line = customer.getFileLine() + "\n"; // Thêm ký tự xuống dòng
                    byte[] b = line.getBytes(StandardCharsets.UTF_8);
                    customerfos.write(b);
                }
                System.out.println("Data has been written to the files successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the files.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile(String customerfile) {
        try (BufferedReader cusreader = new BufferedReader(new FileReader( customerfile)))
        {
            // Read cus file
            String cusline;
            while ((cusline = cusreader.readLine()) != null) {
                if (!cusline.isEmpty()) {
                    Customer cus = new Customer();
                    cus.Parse(cusline);
                    CustomerList.add(cus);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void display()

    {
        System.out.println("------------------------------------------------------------------CUSTOMER LIST------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Customer ID", "Name", "Sex", "Address", "Phone");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        if (CustomerList.isEmpty()) {
            System.out.println("No clothing products to display.");
        } else {
            for (Customer customer : CustomerList) {
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                        customer.getPersonId(),  customer.getPersonName(),
                        customer.getSex(),  customer.getAddress(), customer.getPhoneNumber(), "");
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}