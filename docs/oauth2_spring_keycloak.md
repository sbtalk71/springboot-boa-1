# OAuth2 Login Using Spring Boot and Keycloak

## Prerequisites
- Java 17 or later
- Spring Boot 3.x
- Keycloak 22 or later
- Maven or Gradle
- Docker (optional for running Keycloak)

## Step 1a: Set Up Keycloak
1. **Download and Run Keycloak (with Docker)**
   ```sh
   docker run -d -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev
   ```
   **Alternatively download Keycloak and run**
   a. Download Keycloak .ZIP file and extract in a suitable folder.
   b. go to keycloak/bin foilder and run the following command to start keyclaok
   kc.bat start-dev (**WIndows**)
   kc.sh start-dev (** macOS or *ux platform**)
    
2. **Access Keycloak Admin Console**  
   Navigate to `http://localhost:8080/admin` and log in using `admin/admin`.
3. **Create a Realm**
   - Click `Create Realm`, name it `myrealm`, and save.
4. **Create a Client**
   - Go to `Clients` → `Create`
   - Client ID: `spring-boot-client`
   - Client Authentication: `ON` (**IMPORTANT**)
   - Root URL: `http://localhost:8081` (** Your Spring boot host and port**)
   - Valid Redirect URIs: `http://localhost:8081/*`
   - Save the client.
5. **Create a User**
   - Navigate to `Users` → `Add User`
   - Fill in details and save.
   - Go to `Credentials` and set a password.

## Step 2: Configure Spring Boot Application
1. **Create a Spring Boot Project**
   
   CReate a Spring Boot Project with oauth2 client, web and Security dependencies
    
2. **Add Dependencies** to `pom.xml`
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-oauth2-client</artifactId>
   </dependency>
    ```
3. **Configure `application.yml`**
 ```yml
   server:
     port: 8081

   spring:
     security:
       oauth2:
         client:
           registration:
             keycloak:
               client-id: spring-boot-client
               client-secret: <CLIENT_SECRET>
               scope: openid
               authorization-grant-type: authorization_code
               redirect-uri: "{baseUrl}/login/oauth2/code/keycloak"
           provider:
             keycloak:
               issuer-uri: http://localhost:8080/realms/myrealm
   ```

## Step 3: Implement Security Configuration
1. **Create `SecurityConfig` class**
  ```java
   @Configuration
   @EnableWebSecurity
   public class SecurityConfig {
       @Bean
       public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests(auth -> auth
                   .requestMatchers("/").permitAll()
                   .anyRequest().authenticated()
               )
               .oauth2Login();
           return http.build();
       }
   }
 ```   

## Step 4: Run the Application
```sh
mvn spring-boot:run
```
OR 
run from your IDE
 

## Step 5: Test the OAuth2 Login
1. Open `http://localhost:8081`
2. Click the login button and authenticate with Keycloak credentials.
3. After successful login, you will be redirected to your app.

## Conclusion
You have successfully integrated Keycloak with Spring Boot for OAuth2 login. You can further enhance it by adding role-based access control and JWT authentication.
