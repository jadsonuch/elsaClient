package br.org.elsa.ehr.webservices.imp;

public class ParticipantExamRemoteProxy implements br.org.elsa.ehr.webservices.imp.ParticipantExamRemote {
  private String _endpoint = null;
  private br.org.elsa.ehr.webservices.imp.ParticipantExamRemote participantExamRemote = null;
  
  public ParticipantExamRemoteProxy() {
    _initParticipantExamRemoteProxy();
  }
  
  public ParticipantExamRemoteProxy(String endpoint) {
    _endpoint = endpoint;
    _initParticipantExamRemoteProxy();
  }
  
  private void _initParticipantExamRemoteProxy() {
    try {
      participantExamRemote = (new br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteServiceLocator()).getParticipantExamRemotePort();
      if (participantExamRemote != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)participantExamRemote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)participantExamRemote)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (participantExamRemote != null)
      ((javax.xml.rpc.Stub)participantExamRemote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.org.elsa.ehr.webservices.imp.ParticipantExamRemote getParticipantExamRemote() {
    if (participantExamRemote == null)
      _initParticipantExamRemoteProxy();
    return participantExamRemote;
  }
  
  public br.org.elsa.ehr.webservices.imp.ParticipantHemogramExamResult fetchParticipantHemogramExamResult(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (participantExamRemote == null)
      _initParticipantExamRemoteProxy();
    return participantExamRemote.fetchParticipantHemogramExamResult(arg0);
  }
  
  public br.org.elsa.ehr.webservices.imp.ParticipantUrineExamResult fetchParticipantUrineExamResult(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (participantExamRemote == null)
      _initParticipantExamRemoteProxy();
    return participantExamRemote.fetchParticipantUrineExamResult(arg0);
  }
  
  public br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult fetchParticipantBloodExamResult(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (participantExamRemote == null)
      _initParticipantExamRemoteProxy();
    return participantExamRemote.fetchParticipantBloodExamResult(arg0);
  }
  
  
}