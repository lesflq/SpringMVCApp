package uk.sevastianov.springmvcapp.dao;

import org.springframework.stereotype.Component;
import uk.sevastianov.springmvcapp.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    //    private final String
    private static int PEOPLE_COUNT;
    DbManager db = new DbManager();
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<Person> index() {

        Connection conn = db.getConnection();
        if (conn == null) {
            System.out.println("Connection is null");
            return new ArrayList<>();
        }
        List<Person> people = new ArrayList<>();
        try {
            Statement stmnt = db.getConnection().createStatement();
            String query = "SELECT * FROM person";
            ResultSet resultSet = stmnt.executeQuery(query);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person show(int id) {
        Person person = new Person();
        try {
            PreparedStatement ps =
                    db.getConnection().prepareStatement("SELECT * FROM person WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));
            person.setEmail(rs.getString("email"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person) {
        try {
            PreparedStatement preparedStatement =
                    db.getConnection().prepareStatement("INSERT INTO person (name, age, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement =
                    db.getConnection().prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?");

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement =
                    db.getConnection().prepareStatement("DELETE FROM person WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
