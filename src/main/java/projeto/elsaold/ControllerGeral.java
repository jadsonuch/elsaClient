package projeto.elsaold;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
*/

@ManagedBean
@SessionScoped
public class ControllerGeral {

	public ControllerGeral(){
		System.out.println("Entrando no Construtor do ControllerGeral");
	}
	/*
	private List<Consulta> listaExames;
	
	private Consulta consultaSelecionada;
	
	
	public List<Consulta> getListaExames() {
		if(listaExames==null){
			LoginServiceProxy proxy = new LoginServiceProxy();			
			Consulta[] c;			
			try {				
				c = proxy.listaConsultas("k19", "k19");		
				listaExames = new ArrayList<Consulta>();
				for(Consulta i : c){
					i.setDate(i.getData().getTime());
					listaExames.add(i);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}			
		}
		return listaExames;
	}

	public void setListaExames(List<Consulta> listaExames) {
		this.listaExames = listaExames;
	}
	
	public void abrir(Consulta consulta){
		setConsultaSelecionada(consulta); 		
		System.out.println("Abrindo Exame numero X -> "+consulta.getNumero());
		System.out.println("Abrindo Exame Data X -> "+consulta.getData());				
	}
	
	public void salvarPDF(Consulta consulta){
		setConsultaSelecionada(consulta); 		
		System.out.println("Abrindo Exame numero X -> "+consulta.getNumero());
		System.out.println("Abrindo Exame Data X -> "+consulta.getData());		
		salvarPDF();
	}
	
	public void salvarPDF(){
		
		String jasper = "reports/exame.jasper";
		
		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(jasper);
		
		JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(new Consulta[]{consultaSelecionada});
		
		JasperPrint jasperPrint = null;
		
		try {
			jasperPrint = JasperFillManager.fillReport(reportPath,
					new HashMap<String, Object>(), dataSource);
		} catch (JRException e) {
			e.printStackTrace();
		}
			
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		
		String filename = "Exame";
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=" + filename + ".pdf");
		
		ServletOutputStream servletOutputStream;
		try {
			servletOutputStream = httpServletResponse
					.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					servletOutputStream);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}	
		
		FacesContext.getCurrentInstance().responseComplete();
	}		


	public Consulta getConsultaSelecionada() {
		return consultaSelecionada;
	}

	public void setConsultaSelecionada(Consulta consultaSelecionada) {
		this.consultaSelecionada = consultaSelecionada;
	}
	*/
}
