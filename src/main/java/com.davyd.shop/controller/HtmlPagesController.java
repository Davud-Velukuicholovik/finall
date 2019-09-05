package com.davyd.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPagesController {
    @RequestMapping("/admin")
    public String adminCategories() {
        return "category.html";
    }
}
