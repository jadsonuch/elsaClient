package br.org.elsa.ehr.webservices.imp;

import java.rmi.RemoteException;

public class MainTest {

	public static void main(String[] args){
		System.out.println("blsh");
		
		ParticipantExamRemoteProxy p = new ParticipantExamRemoteProxy();
		
		try {
			ParticipantBloodExamResult s = p.fetchParticipantBloodExamResult(1);
			System.out.println("s"+s);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
