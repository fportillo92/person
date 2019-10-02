package com.person.repository;

import com.person.model.GeneralSequenceNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedSequenceNumberRepository extends CrudRepository<GeneralSequenceNumber, Long> {
}
