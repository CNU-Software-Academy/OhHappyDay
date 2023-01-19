package cnu.ohd.owner.controller;

import cnu.ohd.owner.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/signup")
    @ResponseBody
    public void saveOwner(){

    }
}
