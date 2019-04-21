package br.com.springproject.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.springproject.model.TipoContato;
import br.com.springproject.repository.TipoContatoRepository;

@Component
public class TipoContatoConverter implements Converter{

	@Autowired
	TipoContatoRepository repository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value.isEmpty()) return null;
		try {
			TipoContato tipo = repository.buscarPorId(Integer.parseInt(value));
			return tipo;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof TipoContato) {
			TipoContato tipo = (TipoContato) value;
			return tipo.getId().toString();
		}
		else {
			return null;
		}
	}
}
