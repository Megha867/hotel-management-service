package com.me.user_service.entities;

import lombok.Data;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> ratings=new ArrayList<>();
	
}
