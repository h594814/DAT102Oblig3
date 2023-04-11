package oppgaver;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		
		ansattDAO ansattDAO = new ansattDAO();
		avdelingDAO avdelingDAO = new avdelingDAO();
		/*System.out.println(ansattDAO.finnAnsattMedAnsattID(1));
		System.out.println(ansattDAO.finnAnsattMedAnsattID(2));
		System.out.println(ansattDAO.finnAnsattMedAnsattID(3));
		System.out.println(ansattDAO.sokEtterAnsattMedInitialer("lph"));
		System.out.println(ansattDAO.finnAlleAnsatte());*/
		//ansattDAO.oppdatereAnsatt(1,90000.00,"Undersjef");
		//System.out.println(ansattDAO.finnAnsattMedAnsattID(1));
		//ansattDAO.lageNyAnsatt("smr", "Sondre", "Risnes", LocalDate.of(2021, 11,06), "Sjef", 120000);
		System.out.println(ansattDAO.finnAlleAnsatte());
		//System.out.println(avdelingDAO.finnAlleAvdelinger());
		//System.out.println(avdelingDAO.finnAvdelingMedID(2));
		
		
	}

}
