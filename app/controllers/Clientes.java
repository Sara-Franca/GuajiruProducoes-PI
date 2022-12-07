package controllers;

import java.util.Collections;
import java.util.List;

import models.Cliente;
import models.Status;
import play.mvc.Controller;

public class Clientes extends Controller{
	
	public static void listar() {
		String termo = params.get("termo");
		
		List<Cliente> cliente = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			cliente = Cliente.find("status = ?1", Status.PENDENTE).fetch();
		} else {
			cliente = Cliente.find("lower(nome) like ?1 OR lower(servico) like ?2 AND status = ?3", 
					"%" + termo.toLowerCase() + "%",
					"%" + termo.toLowerCase() + "%",
					Status.PENDENTE).fetch();
		}
		render(cliente, termo);
	}
	
	public static void salvar(Cliente c) {
		c.status = Status.PENDENTE;
		c.save();
		listar();
	}

	public static void form() {
		render();
	}

	public static void remover(Long id) {
		Cliente c = Cliente.findById(id);
		c.status = Status.CONCLUIDO;
		c.save();
		listar();
	}
	
	public static void editar(Long id) {
		Cliente cli = Cliente.findById(id);
		renderTemplate("Clientes/form.html", cli);
	}
	
	public static void index() {
		render();
	}

}
