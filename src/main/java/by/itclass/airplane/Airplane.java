package by.itclass.airplane;

import by.itclass.passenger.Passenger;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.List;

@Entity
@Table(name = "airplane")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String model;
    @NonNull
    private int place;
    @OneToMany(mappedBy = "airplane", fetch = FetchType.EAGER)
    private List<Passenger> passengers;
}
