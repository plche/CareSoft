package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends Usuario implements UsuarioCompatibleConHIPAA {
	
	// Dentro de la clase:    
    private ArrayList<String> patientNotes;
    private int physicianPIN;
	
    // PARA HACER: Constructor que tome un ID
    public Physician(Integer id) {
    	super(id);
    	patientNotes = new ArrayList<String>();
    }
    
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
    @Override
    public boolean assignPIN(int physicianPIN) {
    	setPhysicianPIN(physicianPIN);
    	return (physicianPIN >= 1000)? true : false;
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	return (physicianPIN == confirmedAuthID.intValue())? true : false;
    }
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // PARA HACER: Setters y Getters
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
    
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }

	public int getPhysicianPIN() {
		return physicianPIN;
	}

	public void setPhysicianPIN(int physicianPIN) {
		this.physicianPIN = physicianPIN;
	}
}
