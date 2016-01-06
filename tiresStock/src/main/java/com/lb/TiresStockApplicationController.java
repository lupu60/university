package com.lb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiresStockApplicationController {



    @RequestMapping("/")
    public String root() {
        return "dsa";
    }
}
