package cnu.ohd.Member;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class MemberDto {

    private long id;
    private UUID uuidId;
    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dDay;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

}
