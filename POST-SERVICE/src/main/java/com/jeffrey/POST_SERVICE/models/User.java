package com.jeffrey.POST_SERVICE.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class User  extends BaseModel {
    
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
