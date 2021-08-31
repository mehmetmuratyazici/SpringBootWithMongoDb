package io.springlab.mongodbtuto.entity.customer;

import io.springlab.mongodbtuto.enums.Gender;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document
@AllArgsConstructor
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String surname;
	@Indexed(unique = true)	
	private String email;
    private Gender gender;
	private Address address;
    private LocalDate birthDay;
    private LocalDateTime created;
    

	public CustomerEntity(String name, String surname,String email, Gender gender, Address address, LocalDate birthDay
			) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.birthDay = birthDay;
		this.created = LocalDateTime.now();
	}


	public CustomerEntity() {
    }


    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = LocalDateTime.now();
	}


	@Override
	public String toString() {
		return "CustomerEntity [address=" + address + ", birthDay=" + birthDay + ", created=" + created + ", email="
				+ email + ", gender=" + gender + ", id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

    
	

}
