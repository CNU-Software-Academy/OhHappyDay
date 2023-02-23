package cnu.ohd.gift;

import lombok.Getter;

@Getter
public class GiftDto {
    private long giftId;
    private long memberId;
    private String gto;
    private String message;
    private String gfrom;
    private char boxColor;
    private char ribbonColor;
    private int checked;
}
