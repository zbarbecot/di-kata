package fr.ath.kata.person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    private List<Person> persons = new ArrayList<>();

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public List<Person> findAll() {
        return persons;
    }
}
