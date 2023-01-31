package cnu.ohd.Member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="member")
@Getter @Setter
@DynamicInsert
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
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

    @ColumnDefault(value = "CURRENT_DATE")
    @Column(name = "created_at")
    private LocalDate createdAt;

/*    @OneToMany(mappedBy = "member")
    private List<Gift> gifts = new ArrayList<>();*/

}
