package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;

@Controller
public class IndexController {
	
//	Obteniendo el model

	private MiServicio servicio = new MiServicio();
//	Inyectando el model con etiqueta component
	private MiServicio servicioID;
	
	@Autowired
	@Qualifier("miServicioComplejo")
	private IServicio servicioInterface;
	
//	public IndexController(IServicio servicioInterface) {
//		this.servicioInterface = servicioInterface;
//	}
	//	Con Interface
//	@Autowired
//	public void setServicioInterface(IServicio servicioInterface) {
//		this.servicioInterface = servicioInterface;
//	}
	@GetMapping({"/sin_InyeccionDependencia"})
	public String indexSID(Model model) {
		model.addAttribute("titulo", "Consumiendo servicio sin inyección de dependecia");
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}
	@GetMapping({"/conInterface"})
	public String indexInt(Model model) {
		model.addAttribute("titulo", "Consumiendo servicio con Interface");
		model.addAttribute("objeto", servicioInterface.operacion());
		return "index";
	}
	@GetMapping({"","/","/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Consumiendo Servicio con Inyección de Dependencia");
		model.addAttribute("objeto", servicioID.operacion());
		return "index";
	}
	
	
}
