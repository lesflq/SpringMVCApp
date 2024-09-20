package uk.sevastianov.springmvcapp.dao;

import org.springframework.stereotype.Component;
import uk.sevastianov.springmvcapp.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ivan", 23, "ivan@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Serhii", 36, "serhii@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Raju", 49, "raju@gmail.com"));
    }
    public List<Person> index() {
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());

    }
    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
