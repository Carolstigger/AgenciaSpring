package br.com.recode.agencia.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.recode.agencia.model.Compra;
import br.com.recode.agencia.repository.CompraRepository;

public class CompraController {
	
	@Autowired
    private CompraRepository compraRepository;

	
	
// listagem de dados
	
   @GetMapping ("/compra")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("compra/listar.html");


       
       List<Compra> compras = compraRepository.findAll();
        modelAndView.addObject("compras", compras);



       return modelAndView;
    }
    
   //chama a view cadastrar e passa objeto vazio
   
   @GetMapping("/cadastrar")
   public ModelAndView cadastrar() {
       ModelAndView modelAndView = new ModelAndView("compra/cadastro");



      modelAndView.addObject("compra", new Compra());



      return modelAndView;
   }
   
   
   
   @PostMapping("/cadastrar")
   public ModelAndView cadastrar(Compra compra, @RequestParam("fileCompra") MultipartFile file) throws IOException {
       

     
       
       ModelAndView modelAndView = new ModelAndView("redirect:/compra");
   
       compraRepository.save(compra);



      return modelAndView;
   }
   

    
   
   @GetMapping("/{idCompra}")
   public ModelAndView detalhar(@PathVariable Long idCompra) {
       ModelAndView modelAndView = new ModelAndView("compra/detalhar.html");



      Compra compra = compraRepository.getOne(idCompra);
       modelAndView.addObject("compra", compra);



      return modelAndView;
   }
   
   @GetMapping("/{idCompra}/excluir")
   public ModelAndView excluir(@PathVariable Long idCompra) {
       ModelAndView modelAndView = new ModelAndView("redirect:/compra");



      compraRepository.deleteById(idCompra);



      return modelAndView;
   }
   
   @GetMapping("/{idCompra}/editar")
   public ModelAndView editar(@PathVariable Long idCompra) {
       ModelAndView modelAndView = new ModelAndView("compra/edicao");



      Compra compra = compraRepository.getOne(idCompra);
       modelAndView.addObject("compra", compra);



      return modelAndView;
   }
   
   @PostMapping("/{idCompra}/editar")
   public ModelAndView editar(Compra compra) {
       ModelAndView modelAndView = new ModelAndView("redirect:/compra");



      compraRepository.save(compra);



      return modelAndView;
   }

}
