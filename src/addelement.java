
import dto.Employee;
import myconfig.connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class addelement {
    public static void insert() {
        SessionFactory sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Employee e1 = new Employee(101, "Parul", "HR", 4000000);
        s.save(e1);
        Employee e2 = new Employee(102, "Vidhi", "CS", 3000000);
        s.save(e2);
        Employee e3 = new Employee(103, "Aditya", "CEO", 6000000);
        s.save(e3);
        Employee e4 = new Employee(104, "Morris", "MR", 3000000);
        s.save(e4);
        Employee e5 = new Employee(105, "Lewis", "EC", 3000000);
        s.save(e5);
        Employee e6 = new Employee(106, "Cathy", "CS", 3000000);
        s.save(e6);
        Employee e7 = new Employee(107, "Steve", "CS", 3000000);
        s.save(e7);
        t.commit();
        s.close();
        sf.close();
    }
}
