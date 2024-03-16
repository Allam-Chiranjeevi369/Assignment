package com.assessment.userForm.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_form")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "name", nullable = false)
	private String userName;
	
	@Column(name = "mail", unique = true, nullable = false)
	private String userMail;
	
	@Column(name = "d_o_b", nullable = false)
	private LocalDate dateOfBirth;

}
