package com.thiranya.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {

    @RequestMapping("")
    public String renderHomepage() {
        return "homepage";
    }

    @RequestMapping("add")
    public String renderAddPage() {
        return "add";
    }

    @RequestMapping("search")
    public String renderSearchPage() {
        return "search";
    }

    @RequestMapping("update")
    public String renderUpdatePage() {
        return "update";
    }

    @RequestMapping("delete")
    public String renderDeletePage() {
        return "delete";
    }
}
