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
public class TinTucController {
	
	@Autowired
	private TinTucService tintucService;
	@Autowired
	private NguonService nguonService;

    @GetMapping("/hinh")
    public String index(Model model) {
        model.addAttribute("tintucs", tintucService.findAll());
        model.addAttribute("nguons", nguonService.findAll());
        return "tintuc_list";
    }
    
    @GetMapping("/hinh/create")
    public String create(Model model) {
        model.addAttribute("tintuc", new TinTuc());
        model.addAttribute("nguons", nguonService.findAll());
        return "tintuc_form";
    }
    
    @GetMapping("/hinh/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("tintuc", tintucService.findOne(id));
        model.addAttribute("nguons", nguonService.findAll());
        return "tintuc_form";
    }
    
    @PostMapping("/hinh/save")
    public String save(@Valid TinTuc tintuc, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "tintuc_form";
        }
        tintucService.save(tintuc);
        redirect.addFlashAttribute("success", "Đã lưu hình ảnh !");
        return "redirect:/hinh";
    }
    
    @GetMapping("/hinh/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	tintucService.delete(id);
        redirect.addFlashAttribute("success", "Đã xóa hình ảnh !");
        return "redirect:/hinh";
     }
    
    @GetMapping("/hinh/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/hinh";
        }
        
        model.addAttribute("tintucs", tintucService.search(q));
        model.addAttribute("nguons", nguonService.findAll());
        return "tintuc_list";
    }

}
