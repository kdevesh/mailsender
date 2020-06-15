package com.devesh.mailsender.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "firstname")
    @NotNull(message = "First Name cannot be empty/null")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(unique = true)
    @NotNull(message = "Email cannot be empty/null")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "hasclicked")
    private boolean hasClicked;

}
