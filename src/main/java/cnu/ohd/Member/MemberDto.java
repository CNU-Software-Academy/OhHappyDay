package cnu.ohd.Member;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
public class MemberDto {

    private String userId;
    private String pw;

    @Override
    public String toString() {
        return "MemberDto{" +
                "userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
