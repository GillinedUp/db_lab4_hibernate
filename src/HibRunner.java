import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class HibRunner {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Type product name and its quantity: ");
//        Product appleProduct = new Product(scan.nextLine(), scan.nextInt());
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Product appleProduct = session.get(Product.class,1);
        System.out.println(appleProduct.getProductName() + " " + appleProduct.getUnitsOnStock());
        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
