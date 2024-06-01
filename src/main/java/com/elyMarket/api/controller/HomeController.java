package com.elyMarket.api.controller;

import com.elyMarket.api.model.Producto;
import com.elyMarket.api.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private  final Logger log= LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private ProductoService productoService;


    @GetMapping("")
    public String home(Model model){
        model.addAttribute("productos",productoService.findAll());
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id,Model model){
        log.info("id producto enviado como parámetro {}",id);
        Producto producto=new Producto();
        Optional<Producto> optionalProducto= productoService.get(id);
        producto=optionalProducto.get();

        model.addAttribute("producto",producto);

        return "usuario/productoHome";
    }
}