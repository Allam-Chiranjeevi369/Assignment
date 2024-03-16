# Assignment
a basic assignment of connecting user form to database

Dependencies required :
1. Spring Data JPA
2. My SQL Driver
3. Thymeleaf
4. Spring Web
5. Lombok( first install the jar files from online ).

Spring version used = 3.2.3
Java version used = 17

Do not forget to give your database configuration in applicartion properties:
  spring.datasource.url = jdbc:mysql://localhost:3306/your_DB_name
  spring.datasource.username = your_DB_username
  spring.datasource.password = your_DB_password

  spring.jpa.hibernate.ddl-auto=update (this is to mention to create new table if not exists to store your data).

  # Set the prefix to the directory where your HTML templates are located
  spring.thymeleaf.prefix=classpath:/templates/html/
  # Set the suffix for HTML template files (optional)
  spring.thymeleaf.suffix=.html

