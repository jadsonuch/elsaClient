/**
 * ParticipantExamRemoteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.org.elsa.ehr.webservices.imp;

public class ParticipantExamRemoteServiceLocator extends org.apache.axis.client.Service implements br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteService {

    public ParticipantExamRemoteServiceLocator() {
    }


    public ParticipantExamRemoteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ParticipantExamRemoteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ParticipantExamRemotePort
    private java.lang.String ParticipantExamRemotePort_address = "http://143.54.31.36:8080/ehr/ParticipantExamService";

    public java.lang.String getParticipantExamRemotePortAddress() {
        return ParticipantExamRemotePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ParticipantExamRemotePortWSDDServiceName = "ParticipantExamRemotePort";

    public java.lang.String getParticipantExamRemotePortWSDDServiceName() {
        return ParticipantExamRemotePortWSDDServiceName;
    }

    public void setParticipantExamRemotePortWSDDServiceName(java.lang.String name) {
        ParticipantExamRemotePortWSDDServiceName = name;
    }

    public br.org.elsa.ehr.webservices.imp.ParticipantExamRemote getParticipantExamRemotePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ParticipantExamRemotePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getParticipantExamRemotePort(endpoint);
    }

    public br.org.elsa.ehr.webservices.imp.ParticipantExamRemote getParticipantExamRemotePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteServiceSoapBindingStub _stub = new br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getParticipantExamRemotePortWSDDServiceName());
            _stub.setUsername("jadson");
            _stub.setPassword("!12@service@21!");            
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setParticipantExamRemotePortEndpointAddress(java.lang.String address) {
        ParticipantExamRemotePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.org.elsa.ehr.webservices.imp.ParticipantExamRemote.class.isAssignableFrom(serviceEndpointInterface)) {
                br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteServiceSoapBindingStub _stub = new br.org.elsa.ehr.webservices.imp.ParticipantExamRemoteServiceSoapBindingStub(new java.net.URL(ParticipantExamRemotePort_address), this);
                _stub.setPortName(getParticipantExamRemotePortWSDDServiceName());
                _stub.setUsername("jadson");
                _stub.setPassword("!12@service@21!");
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ParticipantExamRemotePort".equals(inputPortName)) {
            return getParticipantExamRemotePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            ((org.apache.axis.client.Stub) _stub).setUsername("jadson");
            ((org.apache.axis.client.Stub) _stub).setPassword("!12@service@21!");
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://imp.webservices.ehr.elsa.org.br/", "ParticipantExamRemoteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://imp.webservices.ehr.elsa.org.br/", "ParticipantExamRemotePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ParticipantExamRemotePort".equals(portName)) {
            setParticipantExamRemotePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
