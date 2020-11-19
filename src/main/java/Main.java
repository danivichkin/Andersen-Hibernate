import entity.Role;
import entity.User;
import repos.RoleRepo;
import repos.UserRepo;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserRepo userRepo = new UserRepo();
        RoleRepo roleRepo = new RoleRepo();

        User Daniil = new User("Daniil");
        User Ivan = new User("Ivan");
        User Sasha = new User("Sasha");
        User noName = new User("NoName");

        Role j1 = new Role("J1");
        Role j2 = new Role("J2");
        Role j3 = new Role("J3");
        Role M1 = new Role("M1");
        Role M2 = new Role("M2");

        userRepo.deleteUserById(Daniil);

    }
}
