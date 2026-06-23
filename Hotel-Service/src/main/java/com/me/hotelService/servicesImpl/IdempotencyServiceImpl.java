package com.me.hotelService.servicesImpl;

import com.me.hotelService.entities.IdempotencyRecord;
import com.me.hotelService.repositiories.IdempotencyRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdempotencyServiceImpl {

    @Autowired
    IdempotencyRepository idempotencyRepository;

    public Optional<IdempotencyRecord> find(String key) {
        return idempotencyRepository.findByIdempotencyKey(key);
    }

    public void createIdempotencyRecord(String key, String response, int statusCode) {

        Optional<IdempotencyRecord> record = find(key);
        IdempotencyRecord newRecord = new IdempotencyRecord();

        if(record.isEmpty()) {
            newRecord.setIdempotencyKey(key);
            newRecord.setStatusCode(statusCode);
            newRecord.setResponseBody(response);
        }

        idempotencyRepository.save(newRecord);
    }
}
