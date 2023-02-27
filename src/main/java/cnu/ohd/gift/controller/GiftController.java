package cnu.ohd.gift.controller;

import cnu.ohd.gift.GiftDto;
import cnu.ohd.gift.domain.Gift;
import cnu.ohd.gift.service.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GiftController {

    private final GiftService giftService;

    @PostMapping("/api/write/{uuidId}")
    @ResponseBody
    public long saveGift(@PathVariable("uuidId") UUID uuidId, @RequestBody GiftDto form) {
//        log.info("Make Gift info -> gTo: {}, Message: {}, gFrom: {}, box: {}, ribbon: {}", form.getGto(), form.getMessage(), form.getGfrom(), form.getBoxColor(), form.getRibbonColor());

        Gift gift = giftService.create(uuidId, form.getGto(), form.getMessage(), form.getGfrom(), form.getBoxColor(), form.getRibbonColor());
        long giftId = giftService.join(gift);

        return giftId;
    }

    @PatchMapping("/api/checked/{giftId}")
    @ResponseBody
    public void checkedGift(@PathVariable("giftId") long giftId) {
        giftService.changeGift(giftId);
    }
}
