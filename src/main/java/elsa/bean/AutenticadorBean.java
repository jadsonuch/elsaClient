package elsa.bean;

import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="autenticadorBean")
@SessionScoped
public class AutenticadorBean {

	/**1088524, 5002186, 5001184, 5002768, 7074963, 7074963*/
	private HashMap<String,String> listaPessoas;
	
	public AutenticadorBean(){
		listaPessoas = new HashMap<String, String>();
		listaPessoas.put("1088524", "1088524");
		listaPessoas.put("5002186", "5002186");
		listaPessoas.put("5001184", "5001184");
		listaPessoas.put("5002768", "5002768");
		listaPessoas.put("7074963", "7074963");
	}
	
	
	private String usuario;
	private String senha;
	
	public String autentica() {			
		boolean t = false;
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			t = listaPessoas.get(this.usuario).equals(this.senha);						
			if(t){
				ExternalContext ec = fc.getExternalContext();
				HttpSession session = (HttpSession) ec.getSession(false);
				session.setAttribute("usuario", this.usuario);		
				return "index?faces-redirect=true";
			} else {
				FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
				fm.setSeverity(FacesMessage.SEVERITY_ERROR);
				fc.addMessage(null, fm);
				return "";
			}
		}catch(Exception e){
			FacesMessage fm = new FacesMessage("usuário e/ou senha inválidos");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(null, fm);
			return "";
		}
	}

	public String registraSaida() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");
		session.invalidate();						
		return "login?faces-redirect=true";
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public HashMap<String, String> getListaPessoas() {
		return listaPessoas;
	}
	
	public void setListaPessoas(HashMap<String, String> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
}
