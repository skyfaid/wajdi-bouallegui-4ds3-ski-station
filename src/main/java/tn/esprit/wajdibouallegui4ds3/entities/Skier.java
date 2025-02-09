package tn.esprit.wajdibouallegui4ds3.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;
}
