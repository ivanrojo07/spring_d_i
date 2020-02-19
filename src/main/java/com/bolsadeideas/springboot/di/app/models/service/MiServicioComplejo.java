package com.bolsadeideas.springboot.di.app.models.service;


//@Component("miServicioComplejo")
//@Primary
public class MiServicioComplejo  implements IServicio{
	
	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante complejo...";
	}
}
