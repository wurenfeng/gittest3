package com.itheima.controller;

import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Items> items = itemsService.findAll();
        model.addAttribute("items",items);
        return "items";
    }
    @RequestMapping(value =  "/save")
    public String save(Items items){
        int account = itemsService.save(items);
        return "redirect:/items/list";
    }
}
