package elsa.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class AutenticadorBean {

	private String usuario;
	private String senha;
	
	public String autentica() {		
		
		//Conecta ao webservice, e tenta autenticar os dados
		//implementacao basica = Login == Senha 
		
		/*LoginServiceProxy proxy = new LoginServiceProxy();
		boolean t = false;
		try {			
			t = proxy.login(this.usuario, this.senha);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("Boolean " + t);*/
		boolean t = false;
		t = this.usuario.equals(this.senha);
			
		FacesContext fc = FacesContext.getCurrentInstance();
		if(t){
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", this.usuario);		
			//HttpServletRequest req = (HttpServletRequest) ec.getRequest();
			//System.out.println("getContextPath -> "+ req.getContextPath());
			return "index?faces-redirect=true";
		} else {
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

	// GETTERS E SETTERS

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

}
