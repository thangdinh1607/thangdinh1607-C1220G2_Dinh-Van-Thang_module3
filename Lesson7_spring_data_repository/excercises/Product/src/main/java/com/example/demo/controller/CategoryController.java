package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/category-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("category/create","category",new Category());
    }
    @PostMapping("/category-create")
    public String createCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "category/create";
        }else{
            iCategoryService.save(category);
            return "redirect:/category-list";
        }

    }
    @GetMapping("/category-list")
    public ModelAndView showList(){
        return new ModelAndView("category/list","categories",iCategoryService.findAll());
    }
    @GetMapping("/category-delete/{id}")
    public ModelAndView answerDelete(@PathVariable int id){
        return new ModelAndView("category/delete","category",iCategoryService.findById(id));
    }
    @PostMapping("/category-delete")
    public String delete(@ModelAttribute Category category){
        iCategoryService.delete(category.getId());
        return "redirect:/category-list";
    }
}
