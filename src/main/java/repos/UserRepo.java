package repos;

import DAO.UserCRUD;
import entity.Role;
import entity.User;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class UserRepo implements UserCRUD {

    @Override
    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> readAllUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from User").getResultList();
        session.close();
        return list;
    }

    @Override
    public List<User> readAllUsersByRole(Role role) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from User where roles = :role")
                .setParameter("role", role).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public void updateUserById(User user, String newName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createQuery("UPDATE User set name = :newName where id = :userId")
                .setParameter("newName", newName)
                .setParameter("userId", user.getId()).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUserById(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM User where id = :userId")
                .setParameter("userId", user.getId()).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addNewRoleToUser(User user, Role role) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.getTransaction();
            user.addRole(role);
            session.update(user);
            session.getTransaction().commit();
            session.close();
    }
}
