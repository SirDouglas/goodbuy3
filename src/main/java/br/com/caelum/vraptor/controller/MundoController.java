package br.com.caelum.vraptor.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Controller;

@Controller
public class MundoController {

	
public String boasVindas() {
	return "OLá Mundo";
}

public List<String> paises() {
	List<String> list = new ArrayList<String>();
	list.add("Brasil");
	list.add("Argentina");
	list.add("EUA");
	list.add("Japão");
	list.add("Paraguai");
	return list;
	
}

public int ola() {
	return 5;
	
}
}
