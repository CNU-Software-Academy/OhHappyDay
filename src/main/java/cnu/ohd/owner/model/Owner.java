package cnu.ohd.owner.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="owner")
@Getter
@Setter
@DynamicInsert
public class Owner {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="uuid_id")
    private UUID uuidId;

    @Column(name="user_id")
    private String userId;

    @Column(name = "pw")
    private String pw;

    @Column(name = "room")
    private String room;

    @Column(name = "dDay")
    private LocalDate dDay;

    @Column(name = "crated_at")
    private LocalDate createdAt;

}
