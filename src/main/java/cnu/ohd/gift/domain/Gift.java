package cnu.ohd.gift.domain;

import cnu.ohd.Member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "gift")
@Getter @Setter
@DynamicInsert
public class Gift {

    @Id @GeneratedValue
    @Column(name="gift_id")
    private int id;

    @Column(name="member_id")
    private int memberId;
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;*/

    @Column(name="g_to")
    private String gTo;

    @Column(name = "message")
    private String message;

    @Column(name = "g_from")
    private String gFrom;

    @Column(name = "box")
    private char boxColor;

    @Column(name = "ribbon")
    private char ribbonColor;

    @Column(name = "checked")
    private int checked;


}
