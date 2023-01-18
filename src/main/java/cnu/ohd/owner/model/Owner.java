package cnu.ohd.owner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="owner")
@Getter
@Setter
public class Owner {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID uuidId;
    private String userId;
    private String pw;
    private String room;
    private LocalDate dDay;
    private LocalDate createdAt;

}
