package fr.ath.kata.person;

public class PersonService {

    private PersonRepositoryImpl personRepository;

    public PersonService() {
    }

    public PersonService(PersonRepositoryImpl repository) {
        personRepository = repository;
    }


    public void save(Person person) {
        personRepository.save(person);
    }

    public int getMobSize() {
        return personRepository.findAll().size();
    }
}
