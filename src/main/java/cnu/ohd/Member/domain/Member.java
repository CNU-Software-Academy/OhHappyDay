package cnu.ohd.Member.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenerationTime;

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

    @Column(name = "title")
    private String title;

    @Column(name = "dDay")
    private LocalDate dDay;


    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

}
