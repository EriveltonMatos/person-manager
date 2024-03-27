package com.manager.peoplemanager.service;

import com.manager.peoplemanager.exception.UserNotFoundException;
import com.manager.peoplemanager.model.Person;
import com.manager.peoplemanager.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person){
        person.setPersonCode(UUID.randomUUID().toString());
        return personRepo.save(person);
    }

    public List<Person> findAllPersons() {      // listar todos
        return personRepo.findAll();
    }

    public Person updatePerson(Person person) { //atualizar
        return personRepo.save(person);
    }

    public Person findPersonById(Long id) {
        return personRepo.findPersonById(id)
                .orElseThrow(() -> new UserNotFoundException ("Usuário pelo id" + " não foi encontrado"));
    }

    public void deletePerson(Long id) {         // método para excluir
        personRepo.deletePersonById(id);
    }

}
