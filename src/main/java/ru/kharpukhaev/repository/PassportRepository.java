package ru.kharpukhaev.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kharpukhaev.entity.Passport;

import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Long> {
    List<Passport> findByNumber(String number);
}
