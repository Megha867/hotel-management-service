package com.me.hotelService.repositiories;

import com.me.hotelService.entities.IdempotencyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdempotencyRepository extends JpaRepository<IdempotencyRecord, Integer> {

    Optional<IdempotencyRecord> findByIdempotencyKey(String key);
}
