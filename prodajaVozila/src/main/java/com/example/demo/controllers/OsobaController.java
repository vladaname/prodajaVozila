package com.example.demo.controllers;

import com.example.demo.dto.OglasDTO;
import com.example.demo.dto.OsobaDTO;
import com.example.demo.model.Osoba;
import com.example.demo.service.OsobaService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OsobaController {

    private final static String AKCIJA_KREIRAJ = "createOglas";
    private final static String AKCIJA_IZMENI = "izmeniListaOglasa";

    @Autowired
    OsobaService osobaService;

    @GetMapping("/createOsoba")
    public ModelAndView createOsobaGET(){
        return new ModelAndView("createOsoba", "osobaDTO", new OsobaDTO());
    }

    @PostMapping("/createOsoba")
    public String createOsobaPOST(Model model, @ModelAttribute("osobaDTO") OsobaDTO osobaDTO, HttpServletRequest request,
                                  RedirectAttributes redirectAttributes){
        boolean b = osobaService.createOsoba(osobaDTO);
        if(b){
            model.addAttribute("poruka", "Osoba je kreriana");
        }
        else{
            model.addAttribute("poruka", "Grska. Pokusjate ponovo");
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login", "osobaDTO", new OsobaDTO());

    }
    @PostMapping("/login")
    public String loginPOST(Model model, @ModelAttribute("osobaDTO") OsobaDTO osobaDTO, HttpServletRequest request){
        Osoba login = osobaService.login(osobaDTO);
        if(login != null){
            request.getSession().setAttribute("korisnik", login);
                    return "createIzmeni";
        }
        else{
            model.addAttribute("poruka", "Greska!");
            return "login";
        }
    }

    @GetMapping("/kreiraj")
    public String kreiraj(Model model, @RequestParam(value = "akcija")String akcija, RedirectAttributes redirectAttributes){
        model.addAttribute("name", akcija);

        if(akcija.equals(AKCIJA_KREIRAJ)){
            redirectAttributes.addFlashAttribute("oglasDTO", new OglasDTO());
            return "redirect:/createOglas";
        }
        else if(akcija.equals(AKCIJA_IZMENI)){
            return "redirect:/izmeniListaOglasa";
        }
        return null;
    }


}
