package com.raul.examen.examen.Controller;


import com.raul.examen.examen.Domain.Categoria;
import com.raul.examen.examen.Domain.Libro;
import com.raul.examen.examen.Service.CategoriaService;
import com.raul.examen.examen.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    LibroService libroService;

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping("/index")
    public ModelAndView inicio(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/formularioLibro")
    public ModelAndView IngresarCategoria() {
        ModelAndView mav = new ModelAndView();
        List<Categoria> categorias = null;
        try {
            categorias = categoriaService.findAll();
            mav.addObject("categoriaL", categorias);
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.setViewName("formularioLibro");
        mav.addObject("libro", new Libro());

        mav.addObject("respuesta", "Libro guardada con exito");


        return mav;
    }



    @PostMapping("/guardarLibro")
    public ModelAndView save(@Valid @ModelAttribute Libro libro, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        if(!(result.hasErrors())) {
            try{
                libro.setFecha(date);
                libroService.save(libro);
                mav.setViewName("index");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/formularioCategoria")
    public ModelAndView ingresoCategoria(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("formularioCategoria");
        mav.addObject("categoria", new Categoria());
        mav.addObject("respuesta", "Categoria guardada con exito");

        return mav;
    }

    @PostMapping("/guardarCategoria")
    public ModelAndView save(@Valid @ModelAttribute Categoria categoria, BindingResult result) {

        ModelAndView mav = new ModelAndView();

        if(!(result.hasErrors())) {
            try{

                categoriaService.save(categoria);
                mav.setViewName("index");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/listado")
    public ModelAndView listado(){
        ModelAndView mav = new ModelAndView();
        List<Libro> libros=null;
        try{
            libros=libroService.findAll();
        }catch(Exception e){
            e.printStackTrace();

        }
        mav.addObject("libros",libros);
        mav.setViewName("listadoLibros");
        return mav;

    }


    }


