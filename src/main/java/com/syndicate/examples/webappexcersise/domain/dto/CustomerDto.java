package com.syndicate.examples.webappexcersise.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    Long id;
    @NotNull
    @Size(min=3, message="First Name must have at least 3 characters")
    private String firstName;
    private String lastName;
    private String email;
}
