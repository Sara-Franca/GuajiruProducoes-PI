package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;


@Entity
public class Cliente extends Model{
	
	public String nome;
	public String email;
	public String phone;
	public String servico;
	public String areaAtuacao;
	
	public void cliente(){
		status = Status.PENDENTE;
	}
	
	@Enumerated(EnumType.STRING)
	public Status status;

}
