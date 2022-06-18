package com.example.demo.controllers;

import com.example.demo.dto.*;
import com.example.demo.model.Oglas;
import com.example.demo.model.Osoba;
import com.example.demo.service.OglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OglasController {

    @Autowired
    OglasService oglasService;

    @GetMapping("/createOglas")
    public ModelAndView createOglasGET(){

        return new ModelAndView("createOglas", "oglasDTO", new OglasDTO());
    }

    @PostMapping("/createOglas")
    public String createOglasPOST(Model model, @ModelAttribute("oglasDTO") OglasDTO oglasDTO, HttpServletRequest request) {
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        Oglas b = oglasService.createOglas(oglasDTO, o.getIdosoba());
        if(b != null){
            model.addAttribute("createOglas", "Uspesno kreiran oglas");
            return "redirect:/listaOglasa";
        }
        else{
            model.addAttribute("poruka", "Pokusajte ponovo.");
        }
        return "redirect:/createOglas";
    }

    @GetMapping("/listaOglasa")
    public String listaOglasaGET(Model model){
        List<Oglas> listaOglasa = oglasService.getSveOglase();
        if(listaOglasa != null) {
            model.addAttribute("listaOglasa", listaOglasa);
            model.addAttribute("kupiOglasDTO", new KupiOglasDTO());//sta se ovde desava
        }
        else{
            model.addAttribute("poruka", "Greska");
        }
        return "listaOglasa";
    }

    @PostMapping("/kupiVozilo")
    public String kupiVozilo(Model model, @ModelAttribute("kupiOglasDTO")KupiOglasDTO kupiOglasDTO, HttpServletRequest request){
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        boolean kupi = oglasService.kupiVozilo(kupiOglasDTO.getIdoglas(), o.getEmail());

        if(kupi){

            model.addAttribute("poruka", "Vozilo je kupljeno.");
        }
        else{
            model.addAttribute("poruka", "Greska");
        }
        return "redirect:/listaOglasa";
    }

    @GetMapping("/izmeniListaOglasa")
    public String izmeniOglasGET(Model model, HttpServletRequest request){
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        if(o != null){
            List<Oglas> oglasiList = oglasService.listaOglasa(o.getIdosoba());
            model.addAttribute("listaOglasa", oglasiList);
        }
        else{
            model.addAttribute("poruka", "Greska. Oglas nije promenjen");
        }
        return "izmeniListaOglasa";
    }

//    @GetMapping("/izmeniOglas")
//    public String izmeniOglasGET(Model model, @ModelAttribute("izmeniOglas") IzmeniOglasDTO izmeniOglasDTO,
//                                 HttpServletRequest request){
//        int gId = izmeniOglasDTO.getIdoglas();
//        System.out.print(gId);
//        if(gId != 0){
//            model.addAttribute("izmeniOglas", new IzmeniOglasDTO());
//        }
//        else{
//            model.addAttribute("poruka", "Greska");
//        }
//        return "izmeniOglas";
//    }
//
//    @GetMapping("/izmeniOglas")
//    public ModelAndView izmeniOglasGET( Model model){
//        System.out.print(idoglas);
//        model.addAttribute("poruka", idoglas);
//        return new ModelAndView("izmeniOglas", "izmeniOglasDTO", new IzmeniOglasDTO());
//    }

    @PostMapping("/izmeniOglas")
    public String izmeniOglasPOST(Model model, @ModelAttribute("izmeniOglas") IzmeniOglasDTO izmeniOglasDTO,
                                  HttpServletRequest request, RedirectAttributes redirectAttributes){
 //       model.addAttribute("izmeniOglas", izmeniOglasDTO);
        int idOglas = Integer.parseInt(izmeniOglasDTO.getIdoglas());

        if(idOglas != 0){
            Oglas g = oglasService.izmeniOglas(izmeniOglasDTO);
            model.addAttribute("listaOglasa", g);
        }
        else{
           model.addAttribute("poruka", "Greska");
        }
 //       redirectAttributes.addFlashAttribute("akcija", "izmeniListaOglasa");
        return "redirect:/izmeniListaOglasa";

    }

    @GetMapping("/searchByMarka")
    public ModelAndView searchByMarkaGET(){
        return new ModelAndView("searchByMarka", "oglasDTO", new OglasDTO());
    }
//    @PostMapping("/searchByMarkaModel")
//    public String searchByMarkaByModelPOST(Model model, @ModelAttribute("searchByMarka")OglasDTO oglasDTO,
//                                           HttpServletRequest request){
//        List<Oglas> listaMarkaModel = oglasService.searchByMarka(oglasDTO);
//        if(listaMarkaModel != null){
//            model.addAttribute("search", listaMarkaModel);
//        }
//        else{
//            model.addAttribute("poruka", "Nema vozila");
//        }
//        return "listaOglsa";
//    }


    @GetMapping("/pretragaVozila")
    public ModelAndView pretraga(){
        return new ModelAndView("search", "pretragaVozila", new PretragaVozila());
    }

    @PostMapping("/pretragaVozila")
    public String pretragaVozila(Model model, @ModelAttribute("pretragaVozila") PretragaVozila pretragaVozila,
                                 HttpServletRequest request){
        List<PretragaVozila> search = oglasService.pretragaVozila(pretragaVozila);
        if(search != null){
            model.addAttribute("search", search);

        }
        else{
            model.addAttribute("poruka", "Greska");
        }
        return "pretragaVozila";
    }

    @GetMapping("/listaPromovisan")
    public String listaPromovisan(Model model){
        List<Oglas> promovisan = oglasService.promovisan();
        if(promovisan != null){
            model.addAttribute("listaPromovisan", promovisan);
        }
        else{
            model.addAttribute("poruka", "Nema promovisanih oglasa");
        }
        return "listaPromovisan";

    }
    @GetMapping("/searchByAutomobil")
    public String listaAutomobila(Model model, HttpServletRequest request){
        List<Oglas> listaAutomobila = oglasService.listaAutomobila();
        if(listaAutomobila != null){
            model.addAttribute("listaAutomobilia", listaAutomobila);
        }
        else{
            model.addAttribute("poruka", "Lista je prezna");
        }
        return "/listaAutomobila";

    }

    @GetMapping("/searchByKamion")
    public String listaKamiona(Model model, HttpServletRequest request){
        List<Oglas> listaKamiona = oglasService.listaKamiona();
        if(listaKamiona != null){
            model.addAttribute("listaKamiona", listaKamiona);
        }
        else{
            model.addAttribute("poruka", "Lista je prezna");
        }
        return "/listaKamiona";

    }

    @GetMapping("/searchByMotori")
    public String listaMotora(Model model, HttpServletRequest request){
        List<Oglas> listaMotora = oglasService.listaMotora();
        if(listaMotora != null){
            model.addAttribute("listaMotora", listaMotora);
        }
        else{
            model.addAttribute("poruka", "Lista je prezna");
        }
        return "/listaMotora";
    }

    @GetMapping("/pretraga")
    public ModelAndView pretragaGET(){

        return new ModelAndView("pretraga", "pretragaVozila", new PretragaVozila());
    }

    @PostMapping("/pretraga")
    public String pretraga(Model model, @ModelAttribute("pretragaVozila")PretragaVozila pretragaVozila,
                           HttpServletRequest request){

        //ovde parsiram stringove koji su stigli sa fronta
        int cenaOd=0;
        if(!pretragaVozila.getCenaStigloOd().equals("")){
            cenaOd=Integer.parseInt(pretragaVozila.getCenaStigloOd());
        }
        int cenaDo=0;
        if(!pretragaVozila.getCenaStigloDo().equals("")){
            cenaDo=Integer.parseInt(pretragaVozila.getCenaStigloDo());
        }

        List<Oglas> pretragaOglasa = oglasService.pretraga(cenaOd, cenaDo, pretragaVozila.getKriterijumPretrage());

        if(pretragaOglasa != null){
            model.addAttribute("listaOglasa", pretragaOglasa);
        }
        else{
            model.addAttribute("poruka", "Lista je prazna");
        }
        return "/listaOglasa";
    }

    @GetMapping("/pregledOglasa/{id}")
    public String pregledOglasa(Model model, @PathVariable("id")int id){

        Oglas o = oglasService.findById(id);
        List<Oglas> listaOglasa = new ArrayList<>();
        listaOglasa.add(o);
        model.addAttribute("listaOglasa", listaOglasa);

            return "/listaOglasa";

    }

    @GetMapping("/unesiEmail")
    public ModelAndView unesiEmail(){
        return new ModelAndView("unesiEmail", "zaboravljenaLozinkaDTO", new ZaboravljenaLozinkaDTO());
    }

    @PostMapping("/zaboravljenaLozinka")
    public String zaboravljenaLozinka(Model model, ZaboravljenaLozinkaDTO zaboravljenaLozinkaDTO){
        boolean b = oglasService.pronadjiOsoboPoEmailu(zaboravljenaLozinkaDTO);
        if(b){
            return null;
        }
        return null;
    }

//pitaj za ovaj controller
    @GetMapping("/resetSifre/{idstr}")
    public String resetSifre(Model model, @PathVariable("idstr")String idstr) {
    int idOsobe = Integer.parseInt(idstr);
    System.out.print(idOsobe);
    model.addAttribute("resetSifreDTO", new resetSifreDTO());
    model.addAttribute("idosoba", idOsobe);
    return "/resetSifre";
    }

    @PostMapping("/promeniSifru")
    public String promeniSifru(Model model, @ModelAttribute("resetSifreDTO")resetSifreDTO resetSifreDTO){
     if(resetSifreDTO.getPass1().equals(resetSifreDTO.getPass2())){
         boolean b = oglasService.promeniSifru(resetSifreDTO.getIdosoba(), resetSifreDTO.getPass1());
         return null;
     }
     return null;
    }




    }



