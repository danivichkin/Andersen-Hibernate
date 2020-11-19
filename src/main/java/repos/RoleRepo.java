package repos;

import DAO.RoleCRUD;
import entity.Role;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class RoleRepo implements RoleCRUD {

    @Override
    public void createRole(Role role) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(role);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Role> readAllRoles() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from Role").getResultList();
        session.close();
        return list;
    }

    @Override
    public void updateById(Role role, String newRole) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createQuery("UPDATE Role set role = :newName where id = :roleId")
                .setParameter("newName", newRole)
                .setParameter("roleId", role.getId()).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(Role role) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Role where id = :roleId")
                .setParameter("roleId", role.getId()).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
