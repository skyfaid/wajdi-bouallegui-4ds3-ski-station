package tn.esprit.wajdibouallegui4ds3.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSub;

    private LocalDate startDate;
    private LocalDate endDate;
    private Float price;

    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSub;

    @OneToOne
    @JoinColumn(name = "skier_id", unique = true)
    private Skier skier;
}
