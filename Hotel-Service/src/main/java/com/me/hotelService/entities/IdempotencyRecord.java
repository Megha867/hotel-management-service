package com.me.hotelService.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="idempotency_records")
public class IdempotencyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String idempotencyKey;

    private int statusCode;
    private String responseBody;
}
