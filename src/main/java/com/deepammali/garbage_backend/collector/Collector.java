package com.deepammali.garbage_backend.collector;

import com.deepammali.garbage_backend.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collectors")
public class Collector {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String contactNumber;

    private String profilePictureUrl;
    private String address;
    private String city;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Collector(String name, String email, String password, String contactNumber, String profilePictureUrl,
            String address, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.profilePictureUrl = profilePictureUrl;
        this.address = address;
        this.city = city;
    }
}
