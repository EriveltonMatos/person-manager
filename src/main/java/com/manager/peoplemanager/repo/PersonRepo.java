package com.manager.peoplemanager.repo;

import com.manager.peoplemanager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {

    void deletePersonById(Long id);

    Optional<Person> findPersonById(Long id);
}
