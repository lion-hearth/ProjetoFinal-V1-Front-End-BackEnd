package com.als.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class SugestaoController {

    @GetMapping
    public ModelAndView getList() {
        ModelAndView mv = new ModelAndView("front/index"); // ou "index" dependendo da estrutura
        return mv;
    }
}
