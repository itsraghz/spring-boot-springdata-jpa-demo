package com.example.springdatajpademo;

import com.example.springdatajpademo.entity.Employee;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    /**
     * <p>
     *     A class level <tt>list</tt> to track the employees across
     *     a different set of <tt>Runner</tt> instances for the
     *     dependent, conditional evaluation
     * </p>
     */
    static List<Employee> employeeList = new ArrayList<>();

    /**
     * <p>
     *     A flag to facilitate the set of <tt>Runner</tt> instances
     *     which use the <tt>Order</tt> annotation to control the
     *     Order of execution.
     * </p>
     */
    public static final boolean isOrderAnnotationEnabled = false;

    /**
     * <p>
     *     A flag to facilitate the set of <tt>Runner</tt> instances
     *     which use the <tt>Ordered</tt> Interface to control the
     *     Order of execution.
     * </p>
     */
    public static final boolean isOrderedInterfaceEnabled = true;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    /**
     * <p>
     *     A method to insert four sample employees into the Database.
     * </p>
     * @param repository The <tt>EmployeeRepository</tt> to carry out the database operations.
     */
    public static void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }

    //TODO The @Order annotation is not of any good use when I use the anonymous instances of the Runner Beans
    //TODO The execution is fine as long as I have a different/unique method name for each but the order is not making sense
   /* @Bean
    //@Order(2)
    public CommandLineRunner run0(EmployeeRepository repository) {
        return (args -> {
            employeeList = (List<Employee>) repository.findAll();
            System.out.println(employeeList);
        });
    }

    @Bean
    //@Order(3)
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args -> {
            if(employeeList.size()>0) {
                System.out.println("The Employee DB has the tables and data in it already!");
                return;
            }
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
        });
    }

    @Bean
    //@Order(1)
    public CommandLineRunner run2(EmployeeRepository repository) {
        return (args -> {
            System.out.println(repository.findEmployeesByLastnameContaining(" "));
        });
    }*/

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(List<Employee> employeeList) {
        SpringDataJpaDemoApplication.employeeList = employeeList;
    }
}
