package tn.esprit.wajdibouallegui4ds3.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;

    private String namePiste;

    @Enumerated(EnumType.STRING)
    private Color color;

    private int length;
    private int slope;

    @ManyToMany(mappedBy = "pistes")
    private List<Skier> skiers;
}
