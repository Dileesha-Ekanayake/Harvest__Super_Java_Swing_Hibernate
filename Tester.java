import java.util.List;

public class Tester {
    public static void main(String[] args) {

        List<Employee> emplist = EmployeeDao.getAll();

        for (Employee emp : emplist) {
            System.out.print(emp.getName() + "\t");
            System.out.print(emp.getNic() + "\t");
            System.out.print(emp.getDob() + "\t");
            System.out.print(emp.getMobile() + "\t");
            System.out.print(emp.getEmail() + "\t");
            System.out.print(emp.getGender().getName() + "\t");
            System.out.print(emp.getDesignation().getName() + "\t");
            System.out.print(emp.getStatusEmployee().getName() + "\t");
            System.out.println(" ");

        }

        // List<Employee> emplist2 = EmployeeDao.getAllByNameGender("D", GenderDao.getById(1));

        // for (Employee emp : emplist2) {
        //     System.out.print(emp.getName() + "\t");
        //     System.out.print(emp.getNic() + "\t");
        //     System.out.print(emp.getDob() + "\t");
        //     System.out.print(emp.getMobile() + "\t");
        //     System.out.print(emp.getEmail() + "\t");
        //     System.out.print(emp.getGender().getName() + "\t");
        //     System.out.print(emp.getDesignation().getName() + "\t");
        //     System.out.print(emp.getStatusEmployee().getName() + "\t");
        //     System.out.println(" ");

        // }
    }
}