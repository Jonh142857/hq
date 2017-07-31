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

import com.yuen.domain.TinTuc;
import com.yuen.service.NguonService;
import com.yuen.service.TinTucService;

@Controller
public class MainController {
	
	@Autowired
	private TinTucService tintucService;
	@Autowired
	private NguonService nguonService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tintucs", tintucService.findAll());
        model.addAttribute("nguons", nguonService.findAll());
        return "index";
    }
    @GetMapping("/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/";
        }
        
        model.addAttribute("tintucs", tintucService.search(q));
        model.addAttribute("nguons", nguonService.findAll());
        return "index";
    }

}
