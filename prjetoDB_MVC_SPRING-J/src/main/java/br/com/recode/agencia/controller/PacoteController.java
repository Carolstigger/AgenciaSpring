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

import br.com.recode.agencia.model.Pacote;
import br.com.recode.agencia.repository.PacoteRepository;

public class PacoteController {
	
	@Autowired
    private PacoteRepository pacoteRepository;

	
	
// listagem de dados
	
   @GetMapping ("/pacote")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("pacote/listar.html");


       
       List<Pacote> pacotes = pacoteRepository.findAll();
        modelAndView.addObject("pacotes", pacotes);



       return modelAndView;
    }
    
   //chama a view cadastrar e passa objeto vazio
   
   @GetMapping("/cadastrar")
   public ModelAndView cadastrar() {
       ModelAndView modelAndView = new ModelAndView("pacote/cadastro");



      modelAndView.addObject("pacote", new Pacote());



      return modelAndView;
   }
   
   
   
   @PostMapping("/cadastrar")
   public ModelAndView cadastrar(Pacote pacote, @RequestParam("filePacote") MultipartFile file) throws IOException {
       

      try {
           pacote.setImagem(file.getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       }    
       
       
       ModelAndView modelAndView = new ModelAndView("redirect:/pacote");
   
       pacoteRepository.save(pacote);



      return modelAndView;
   }
   
   // mostra imagem
   @GetMapping("/imagem/{idPacote}")
   @ResponseBody
   public byte[] exibirImagen(@PathVariable("idPacote") Long idPacote) {
       Pacote pacote = this.pacoteRepository.getOne(idPacote);
       return pacote.getImagem();
   }
   
   @GetMapping("/{idPacote}")
   public ModelAndView detalhar(@PathVariable Long idPacote) {
       ModelAndView modelAndView = new ModelAndView("pacote/detalhar.html");



      Pacote pacote = pacoteRepository.getOne(idPacote);
       modelAndView.addObject("pacote", pacote);



      return modelAndView;
   }
   
   @GetMapping("/{idPacote}/excluir")
   public ModelAndView excluir(@PathVariable Long idPacote) {
       ModelAndView modelAndView = new ModelAndView("redirect:/pacote");



     pacoteRepository.deleteById(idPacote);



      return modelAndView;
   }
   
   @GetMapping("/{idPacote}/editar")
   public ModelAndView editar(@PathVariable Long idPacote) {
       ModelAndView modelAndView = new ModelAndView("pacote/edicao");



      Pacote pacote = pacoteRepository.getOne(idPacote);
       modelAndView.addObject("pacote", pacote);



      return modelAndView;
   }
   
   @PostMapping("/{idPacote}/editar")
   public ModelAndView editar(Pacote pacote) {
       ModelAndView modelAndView = new ModelAndView("redirect:/pacote");



      pacoteRepository.save(pacote);



      return modelAndView;
   }

}
