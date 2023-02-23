package cnu.ohd.Member.domain;

import cnu.ohd.gift.GiftDto;
import cnu.ohd.gift.domain.Gift;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name="member")
@Getter @Setter
@DynamicInsert
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private long id;

    @Column(name="uuid_id")
    private UUID uuidId;

    @Column(name = "title")
    private String title;

    @Column(name = "d_day")
    private LocalDate dDay;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

}
