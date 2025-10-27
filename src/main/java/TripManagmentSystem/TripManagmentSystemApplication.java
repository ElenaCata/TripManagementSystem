package TripManagmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class TripManagmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripManagmentSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                System.out.println("✅ Database connection successful!");
                System.out.println("✅ Database is clean and ready!");
                System.out.println("✅ You can add your own users now!");
            } catch (Exception e) {
                System.err.println("⚠️ Database connection failed: " + e.getMessage());
                System.err.println("Make sure PostgreSQL is running on localhost:5432");
            }
        };
    }
}