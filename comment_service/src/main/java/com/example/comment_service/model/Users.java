// Exemple : Post.java
package com.example.comment_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
   

    
}
