package br.com.springproject.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.springproject.model.Estado;
import br.com.springproject.repository.EstadoRepository;

@Component
public class EstadoConverter implements Converter {

	@Autowired
	EstadoRepository estadoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())
			return null;
		try {
			Estado estado = estadoRepository.encontrePeloId(Integer.parseInt(value));
			return estado;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Estado) {
			Estado estado = (Estado) value;
			return estado.getId().toString();
		} else {
			return null;
		}
	}

}