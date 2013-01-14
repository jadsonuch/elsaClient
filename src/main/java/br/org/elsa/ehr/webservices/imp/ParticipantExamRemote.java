/**
 * ParticipantExamRemote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.org.elsa.ehr.webservices.imp;

public interface ParticipantExamRemote extends java.rmi.Remote {
    public br.org.elsa.ehr.webservices.imp.ParticipantHemogramExamResult fetchParticipantHemogramExamResult(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public br.org.elsa.ehr.webservices.imp.ParticipantUrineExamResult fetchParticipantUrineExamResult(java.lang.Integer arg0) throws java.rmi.RemoteException;
    public br.org.elsa.ehr.webservices.imp.ParticipantBloodExamResult fetchParticipantBloodExamResult(java.lang.Integer arg0) throws java.rmi.RemoteException;
}
