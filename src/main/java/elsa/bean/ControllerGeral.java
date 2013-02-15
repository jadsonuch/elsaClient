package elsa.bean;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import elsa.remotes.ParticipantBloodExamResult;
import elsa.remotes.ParticipantHemogramExamResult;
import elsa.remotes.ParticipantUrineExamResult;

import br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteProxy;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;


@ManagedBean
@SessionScoped
public class ControllerGeral {

	@ManagedProperty(value = "#{autenticadorBean}")
	private AutenticadorBean autenticadorBean;

	public ControllerGeral() {
		System.out.println("Entrando no Construtor do ControllerGeral ->");

		/*
		 * ParticipantExamRemoteProxy p = new ParticipantExamRemoteProxy();
		 * 
		 * try { br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult
		 * bloodExam = p.fetchParticipantBloodExamResult();
		 * System.out.println("name"+s.getName());
		 * System.out.println("birthdate"+s.getBirthdate()); } catch
		 * (RemoteException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	@PostConstruct
	public void init() {
		ParticipantExamRemoteProxy p = new ParticipantExamRemoteProxy();
		int idUsuario = Integer.parseInt(autenticadorBean.getUsuario());
		try {
			blood = p.fetchParticipantBloodExamResult(idUsuario);
			System.out.println("bloodExam"+blood.getImagePath());
			System.out.println("bloodExam"+blood.getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception ef) {
			ef.printStackTrace();
		}
		try {
			hemogram = p.fetchParticipantHemogramExamResult(idUsuario);
			System.out.println("hemogram"+hemogram.getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception ef) {
			ef.printStackTrace();
		}
		try {
			urine = p.fetchParticipantUrineExamResult(idUsuario);
			System.out.println("urine"+urine.getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception ef) {
			ef.printStackTrace();
		}
	}

	private br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult blood;
	private br.org.elsa.ehr.webservices.imp.ParticipantHemogramExamResult hemogram;
	private br.org.elsa.ehr.webservices.imp.ParticipantUrineExamResult urine;
	
	private ParticipantHemogramExamResult hemograma;
	private ParticipantUrineExamResult urina;
	private ParticipantBloodExamResult sangue;

	public void salvarPDFHemograma() {

		hemogram.setImagePath("logo_elsa.jpg");
		
		String jasper = "reports/resultadoHemograma.jasper";
		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(jasper);

		JRDataSource dataSource = new JRBeanArrayDataSource(
				new br.org.elsa.ehr.webservices.imp.ParticipantHemogramExamResult[] { this.hemogram });
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
			servletOutputStream = httpServletResponse.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					servletOutputStream);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}

		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void salvarPDFSangue() {

		blood.setImagePath("logo_elsa.jpg");
		String jasper = "reports/resultadoSangue.jasper";
		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(jasper);

		JRDataSource dataSource = new JRBeanArrayDataSource(
				new br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult[] { this.blood });
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
			servletOutputStream = httpServletResponse.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					servletOutputStream);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}

		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void salvarPDFUrina() {

		urine.setImagePath("logo_elsa.jpg");
		String jasper = "reports/resultadoUrina.jasper";
		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(jasper);

		JRDataSource dataSource = new JRBeanArrayDataSource(
				new br.org.elsa.ehr.webservices.imp.ParticipantUrineExamResult[] { this.urine });
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
			servletOutputStream = httpServletResponse.getOutputStream();
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

	public void setAutenticadorBean(AutenticadorBean autenticadorBean) {
		this.autenticadorBean = autenticadorBean;
	}

	public br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult getBlood() {
		return blood;
	}

	public void setBlood(
			br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult blood) {
		this.blood = blood;
	}

	public br.org.elsa.ehr.webservices.imp.ParticipantHemogramExamResult getHemogram() {
		return hemogram;
	}

	public void setHemogram(
			br.org.elsa.ehr.webservices.imp.ParticipantHemogramExamResult hemogram) {
		this.hemogram = hemogram;
	}

	public br.org.elsa.ehr.webservices.imp.ParticipantUrineExamResult getUrine() {
		return urine;
	}

	public void setUrine(
			br.org.elsa.ehr.webservices.imp.ParticipantUrineExamResult urine) {
		this.urine = urine;
	}
}
