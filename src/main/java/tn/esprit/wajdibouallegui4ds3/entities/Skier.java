package tn.esprit.wajdibouallegui4ds3.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "skier", cascade = CascadeType.ALL)
    private List<Registration> registrations;

    @OneToOne(mappedBy = "skier", cascade = CascadeType.ALL, orphanRemoval = true)
    private Subscription subscription;

    @ManyToMany
    @JoinTable(
            name = "skier_piste",
            joinColumns = @JoinColumn(name = "skier_id"),
            inverseJoinColumns = @JoinColumn(name = "piste_id")
    )
    private List<Piste> pistes;
}
