package ru.kharpukhaev.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kharpukhaev.entity.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByName(String name);
}
