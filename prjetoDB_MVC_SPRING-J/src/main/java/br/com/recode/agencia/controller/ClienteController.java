package br.com.recode.agencia.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.recode.agencia.model.Cliente;
import br.com.recode.agencia.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteRepository clienteRepository;

	
	
// listagem de dados
	
   @GetMapping 
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("contato.html");


       
       List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);



       return modelAndView;
    }
    
   //chama a view cadastrar e passa objeto vazio
   
   @GetMapping("/cadastrar")
   public ModelAndView cadastrar() {
       ModelAndView modelAndView = new ModelAndView("contato");



      modelAndView.addObject("cliente", new Cliente());



      return modelAndView;
   }
   
   
   
   @PostMapping("/cadastrar")
   public ModelAndView cadastrar(Cliente cliente )throws IOException {
       

       ModelAndView modelAndView = new ModelAndView("redirect:/");
   
       clienteRepository.save(cliente);



      return modelAndView;
   }
   
 

   
   @GetMapping("/{idCliente}")
   public ModelAndView detalhar(@PathVariable Long idCliente) {
       ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");



      Cliente cliente = clienteRepository.getOne(idCliente);
       modelAndView.addObject("cliente", cliente);



      return modelAndView;
   }
   
   @GetMapping("/{idCliente}/excluir")
   public ModelAndView excluir(@PathVariable Long idCliente) {
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");



      clienteRepository.deleteById(idCliente);



      return modelAndView;
   }
   
   @GetMapping("/{idCliente}/editar")
   public ModelAndView editar(@PathVariable Long idCliente) {
       ModelAndView modelAndView = new ModelAndView("cliente/edicao");



      Cliente cliente = clienteRepository.getOne(idCliente);
       modelAndView.addObject("cliente", cliente);



      return modelAndView;
   }
   
   @PostMapping("/{idCliente}/editar")
   public ModelAndView editar(Cliente cliente) {
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");



      clienteRepository.save(cliente);



      return modelAndView;
   }

}
