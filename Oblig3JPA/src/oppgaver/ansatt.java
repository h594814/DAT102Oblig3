package oppgaver;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3", name="ansatt")

public class ansatt {
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private int    ansatt_id;
		private String brukernavn;
		private String fornavn;
		private String etternavn;
		private LocalDate ansettelsesdato;
		private String stilling;
		private double   manedslonn;
		
		@ManyToOne 
		@JoinColumn(name = "avdeling") 
		private avdeling Avdeling;
		
		public int getAnsattid() {
			return ansatt_id;
		}
		
		public ansatt() {
			
		}
		
		public ansatt(int ansattid, String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesdato,
				String stilling, double maanedslonn, avdeling Avdeling) {
			
			this.ansatt_id = ansattid;
			this.brukernavn = brukernavn;
			this.fornavn = fornavn;
			this.etternavn = etternavn;
			this.ansettelsesdato = ansettelsesdato;
			this.stilling = stilling;
			this.manedslonn = maanedslonn;
			this.Avdeling = Avdeling;
		}
		
		public ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesdato,
				String stilling, double maanedslonn) {
			
			this.brukernavn = brukernavn;
			this.fornavn = fornavn;
			this.etternavn = etternavn;
			this.ansettelsesdato = ansettelsesdato;
			this.stilling = stilling;
			this.manedslonn = maanedslonn;
		}
		
		public void setAnsattid(int ansattid) {
			this.ansatt_id = ansattid;
		}
		public String getBrukernavn() {
			return brukernavn;
		}
		public void setBrukernavn(String brukernavn) {
			this.brukernavn = brukernavn;
		}
		public String getFornavn() {
			return fornavn;
		}
		public void setFornavn(String fornavn) {
			this.fornavn = fornavn;
		}
		public String getEtternavn() {
			return etternavn;
		}
		public void setEtternavn(String etternavn) {
			this.etternavn = etternavn;
		}
		public LocalDate getAnsettelsesdato() {
			return ansettelsesdato;
		}
		public void setAnsettelsesdato(LocalDate ansettelsesdato) {
			this.ansettelsesdato = ansettelsesdato;
		}
		public String getStilling() {
			return stilling;
		}
		public void setStilling(String stilling) {
			this.stilling = stilling;
		}
		public double getMaanedslonn() {
			return manedslonn;
		}
		public void setMaanedslonn(double maanedslonn) {
			this.manedslonn = maanedslonn;
		}
		
		@Override
		public String toString() {
			return "ansatt [ansattid=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn
					+ ", etternavn=" + etternavn + ", ansettelsesdato=" + ansettelsesdato + ", stilling=" + stilling
					+ ", maanedslonn=" + manedslonn + "avdeling="+ Avdeling.getNavn() +  "] \n";
		}
		
	 	
	 	

}

