package ru.kharpukhaev.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kharpukhaev.entity.Transfer;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
}
