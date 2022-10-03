package edu.caensup.sio.td2.exceptions;

public class OrgaNotFoundException extends RuntimeException {

	public OrgaNotFoundException(int id) {
		super("Organisation " + id + " non trouvée");
		
	}
	
}
