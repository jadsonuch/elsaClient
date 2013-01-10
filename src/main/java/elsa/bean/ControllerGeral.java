package elsa.bean;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import elsa.remotes.ParticipantBloodExamResult;
import elsa.remotes.ParticipantHemogramExamResult;
import elsa.remotes.ParticipantUrineExamResult;

@ManagedBean
@SessionScoped
public class ControllerGeral {

	public ControllerGeral(){					
		System.out.println("Entrando no Construtor do ControllerGeral ->");		
		hemograma = new ParticipantHemogramExamResult();
		hemograma.setImagePath("logo_elsa.jpg");
		hemograma.setName("Joao da Silva");
		hemograma.setFieldCenter("2012");
		hemograma.setRecruitmentNumber(12345);
		hemograma.setBirthdate(123456780L);
		hemograma.setFirstBsfbBeginDate(1299567800000L);
		hemograma.setEritrocitos("4.250.000");
		hemograma.setHemoglobina("14,3");
		hemograma.setHematocrito("39");
		hemograma.setVcm("90");
		hemograma.setHcm("32");
		hemograma.setChcm("38");
		hemograma.setRdw("15,7");
		hemograma.setLeucocitos("4.600");
		hemograma.setNeutrofilos("55");
		hemograma.setBastonetes("2");
		hemograma.setSegmentados("41");
		hemograma.setEosinofilos("1");
		hemograma.setBasofilos("2");
		hemograma.setLinfocitos("23");
		hemograma.setMonocitos("9");
		hemograma.setPlaquetas("170.000");
	}
	
	private ParticipantBloodExamResult sangue;
	private ParticipantHemogramExamResult hemograma;
	private ParticipantUrineExamResult urina;
	
	
	
	public void salvarPDFHemograma(){
		
		String jasper = "reports/resultadoHemograma.jasper";
		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(jasper);
				
		JRDataSource dataSource = new JRBeanArrayDataSource(new ParticipantHemogramExamResult[]{this.hemograma});		
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
	
	
	
	public ParticipantBloodExamResult getSangue() {
		return sangue;
	}
	public void setSangue(ParticipantBloodExamResult sangue) {
		this.sangue = sangue;
	}
	public ParticipantHemogramExamResult getHemograma() {
		return hemograma;
	}
	public void setHemograma(ParticipantHemogramExamResult hemograma) {
		this.hemograma = hemograma;
	}
	public ParticipantUrineExamResult getUrina() {
		return urina;
	}
	public void setUrina(ParticipantUrineExamResult urina) {
		this.urina = urina;
	}
	
	/*

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
	*/
}
