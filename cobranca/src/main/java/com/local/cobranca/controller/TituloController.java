package com.local.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.local.cobranca.model.StatusTitulo;
import com.local.cobranca.model.Titulo;
import com.local.cobranca.repository.Titulos;
import com.local.cobranca.repository.filter.TituloFilter;
import com.local.cobranca.service.CadastroTitulosService;

@Controller
@RequestMapping("/titulos")
public class TituloController {
    
	@Autowired
	private Titulos titulos; 
	
	@Autowired
	private CadastroTitulosService cadastroTitulosService; 
	
	private static final String CADASTRO_VIEW = "CadastroTitulo";
	
	private static final String PESQUISA_VIEW = "PesquisaTitulos";		
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv =  new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());		
		return mv;
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes){		
		if(errors.hasErrors()){
			return CADASTRO_VIEW;
		}
		
		try{
			this.cadastroTitulosService.salvar(titulo);			
			attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso.");
			return "redirect:/titulos/novo";			
		} catch(IllegalArgumentException e){
			errors.rejectValue("dataVencimento", e.getMessage());
			return CADASTRO_VIEW;
		}
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView pesquisar(){
		List<Titulo> todosTitulos = this.titulos.findAll();
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		mv.addObject("todosTitulos", todosTitulos);
		return mv;
	}	
	
	@RequestMapping(value = "/filtro", method = RequestMethod.GET)
	public ModelAndView pesquisar(@ModelAttribute("filtro") TituloFilter filtro){		
		List<Titulo> todosTitulos = this.cadastroTitulosService.filtrar(filtro);		
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		mv.addObject("titulosFiltrados", todosTitulos);
		
		return mv;
	}	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo){		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}	
	
	/* OUTRA FORMA DE FAZER 
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable Long codigo){
		Titulo titulo = this.titulos.findOne(codigo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}
	*/	
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		this.cadastroTitulosService.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso.");
		return "redirect:/titulos/filtro";
	}	
	
	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo) {
		return this.cadastroTitulosService.receber(codigo);
	}	
	
	@ModelAttribute("todosStatusTitulos")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}	
}