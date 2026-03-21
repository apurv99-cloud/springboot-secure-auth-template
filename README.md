#  Spring Boot Secure Authentication Template

A production-ready authentication system built using **Spring Boot** and **Spring Security**, featuring custom authentication flow, database integration, and secure password handling using **BCrypt**.

---

##  Features

*  Custom Authentication using Spring Security
*  Database-based user authentication (JPA)
*  Custom `UserDetailsService` implementation
*  `UserPrincipal` adapter for Spring Security
*  Secure password hashing with **BCrypt**
*  Custom `SecurityFilterChain` configuration
*  HTTP Basic Authentication (for testing)
*  Stateless session management

---

##  Tech Stack

* Java 17+
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL / H2 Database

---

##  Project Structure

```
src/main/java/com/example/demo
│
├── Configuration/
│   └── SecurityConfig.java
│
├── Models/
│   ├── User.java
│   └── UserPrincipal.java
│
├── Dao/
│   └── UserRepo.java
│
├── Service/
│   └── MyUserDetailsService.java
│
└── Controller/
    └── (Your Controllers)
```

---

##  Authentication Flow

1. Client sends request with credentials
2. Spring Security intercepts the request
3. `AuthenticationProvider` is triggered
4. `UserDetailsService` fetches user from database
5. User is converted into `UserPrincipal`
6. Password is validated using BCrypt
7. Access is granted or denied

---

##  Configuration Highlights

###  Authentication Provider

```java
@Bean
public AuthenticationProvider authProvider() {
    DaoAuthenticationProvider provider =
        new DaoAuthenticationProvider(userDetailsService);

    provider.setPasswordEncoder(new BCryptPasswordEncoder());
    return provider;
}
```

---

###  Security Filter Chain

```java
http.csrf(csrf -> csrf.disable());

http.authorizeHttpRequests(auth -> auth
    .anyRequest().authenticated()
);

http.httpBasic(Customizer.withDefaults());

http.sessionManagement(session ->
    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
);
```

---

##  Testing

Use **Postman** or browser with HTTP Basic Auth:

```
Username: your_username
Password: your_password
```

---

##  Important Notes

*  Do NOT use `NoOpPasswordEncoder` in production
*  Always store passwords using BCrypt
*  This project is designed as a **base template** for secure backend systems

---

##  Future Enhancements

*  JWT Authentication
*  Role-Based Access Control (ADMIN / USER)
*  OAuth2 (Google Login)
*  Logging & Monitoring
*  API Gateway Integration

---

##  Contribution

Feel free to fork this repository and enhance it with advanced security features.

---

##  Support

If you found this useful, give it a ⭐ and share it!

---

##  Author

**Apurv Sinha**
