import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CustomerList {
    ArrayList<Customer> CustomerList = new ArrayList<>();
    Scanner sc = new Scanner (System.in);
    public void input()
    {
        System.out.print("How many customer u want to add?");
        int quantity = sc.nextInt();
        for ( int i=0; i< quantity ; i++)
        {
            CustomerList.add(new Customer());
            CustomerList.get(i).input();
        }
    }
    public void find()
    {
        System.out.print("Enter id :");
        String id = sc.nextLine();
        for (Customer customer : CustomerList)
        {
            if (customer.getPersonId().equals(id))
            {
                customer.display();
            }
        }
    }
    public void Delete()
    {
        System.out.print("Enter id :");
        String id = sc.nextLine();
        for (Customer customer : CustomerList)
        {
            if (customer.getPersonId().equals(id))
            {
                CustomerList.remove(customer);
            }
        }
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
    }
    public void editById()
    {
        System.out.print("Enter id :");
        String id = sc.nextLine();
        for (Customer customer : CustomerList)
        {
            customer.input();
        }
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
}