package cnu.ohd.gift.domain;

import cnu.ohd.Member.domain.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "gift")
@Getter @Setter
@DynamicInsert
public class Gift {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gift_id")
    private long giftId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @Column(name="gto")
    private String gTo;

    @Column(name = "message")
    private String message;

    @Column(name = "gfrom")
    private String gFrom;

    @Column(name = "box")
    private char boxColor;

    @Column(name = "ribbon")
    private int ribbonColor;

    @ColumnDefault("0")
    @Column(name = "checked")
    private int checked;


}
