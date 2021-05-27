

import config.Util;
import entity.Account;
import entity.Card;
import entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        saveClients();
//        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        System.out.println("Session created");
//
//        Transaction tx = session.beginTransaction();
//
//
//        List<Account> list =new ArrayList<>();
//
//        tx.commit();
    }

    public static void saveClients() {
        Transaction transaction = null;
        Card card = new Card("1234123");
        Account account = new Account("4132243","3245234");
//        Set<Card> setOfCard = new HashSet<>();
//        setOfCard.add(card);
//        account.setCards(setOfCard);
//        Set<Account>setOfAccount = new HashSet<>();
//        setOfAccount.add(account);
        Client client = new Client("ads","asdas","dsfsd");
//        client.setAccounts(setOfAccount);



        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
//            session.save(card);
//            session.save(account);

            transaction.commit();
            System.out.println("User с именем –   добавлен в базу данных.");
        } catch (HibernateException e) {
            System.err.println("Не удалось добавить пользователея");
        }
    }
}