package com.yuen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuen.domain.Nguon;
import com.yuen.service.NguonService;

@Controller
public class NguonController {
	
	@Autowired
	private NguonService nguonService;

    @GetMapping("/album")
    public String index(Model model) {
        model.addAttribute("nguons", nguonService.findAll());
        return "nguon_list";
    }
    
    @GetMapping("/album/create")
    public String create(Model model) {
        model.addAttribute("nguon", new Nguon());
        return "nguon_form";
    }
    
    @GetMapping("/album/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("nguon", nguonService.findOne(id));
        return "nguon_form";
    }
    
    @PostMapping("/album/save")
    public String save(@Valid Nguon nguon, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "nguon_form";
        }
        nguonService.save(nguon);
        redirect.addFlashAttribute("success", "Đã lưu album !");
        return "redirect:/album";
    }
    
    @GetMapping("/album/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	nguonService.delete(id);
        redirect.addFlashAttribute("success", "Đã xóa album !");
        return "redirect:/album";
     }
    
    @GetMapping("/album/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/album";
        }
        
        model.addAttribute("nguons", nguonService.search(q));
        return "nguon_list";
    }

}
