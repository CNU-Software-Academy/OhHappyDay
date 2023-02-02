package cnu.ohd.Member;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
public class MemberVo {
    private UUID uuidId;
    private String title;
    private LocalDate dDay;
    private LocalDate createdAt;
}
