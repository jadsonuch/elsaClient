package elsa.teste;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TesteBean {

	public String getGreeting() {
		return "Hello World!";
	}
}
