
import dto.Employee;
import java.util.List;
import myconfig.connection;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import static org.hibernate.criterion.Order.desc;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HQL {
    public static SessionFactory sf;
    public static void AvgSalary() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.avg("salary"));
        c.setProjection(p);
        List l = c.list();
        System.out.println(l);
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void showSingleCol() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.property("id"));
        c.setProjection(p);
        List l = c.list();
        System.out.println(l);
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void showManyCol() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.property("id"));
        p.add(Projections.property("name"));
        p.add(Projections.property("salary"));
        c.setProjection(p);
        List<Object[]> l = c.list();
        for (Object x[]: l) {
            System.out.println(x[0]+" : "+x[1]+" : "+x[2]);
        }
        t.commit();
        s.close();
        sf.close();
    }
   
    public static void showWhere() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.property("name"));
        p.add(Projections.property("department"));
        c.setProjection(p);
        c.add(Restrictions.gt("salary", 3000000.0f));
        List<Object[]> l = c.list();
        for (Object x[]: l) {
            System.out.println(x[0]+" : "+x[1]);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void sumPrice() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.sum("salary"));
        c.setProjection(p);
        List l = c.list();
        System.out.println(l);
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void Orderby() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.property("id"));
        p.add(Projections.property("name"));
        p.add(Projections.property("department"));
        c.setProjection(p);
        c.addOrder(Order.desc("id"));
        List<Object[]> l = c.list();
        for (Object x[]: l) {
            System.out.println(x[0]+" : "+x[1]+" : "+x[2]);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void Like() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.property("id"));
        p.add(Projections.property("name"));
        p.add(Projections.property("department"));
        c.setProjection(p);
        c.add(Restrictions.like("name", "%a%"));
        List<Object[]> l = c.list();
        for (Object x[]: l) {
            System.out.println(x[0]+" : "+x[1]+" : "+x[2]);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void Groupby() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Criteria c = s.createCriteria(Employee.class);
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("salary"));
        p.add(Projections.property("id"));
        p.add(Projections.property("name"));
        c.setProjection(p);
        List<Object[]> l = c.list();
        for (Object x[]: l) {
            System.out.println(x[0]+" : "+x[1]+" : "+x[2]);
        }
        t.commit();
        s.close();
        sf.close();
    }
}
