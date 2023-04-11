package oppgaver;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3", name="avdeling")

public class avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdeling_id;
	private String navn;
	
	@OneToOne
	@JoinColumn(name = "sjef_id")
	private ansatt sjef_id;
	
	
		@OneToMany(mappedBy = "Avdeling", fetch = FetchType.EAGER, cascade = CascadeType.ALL,
		           orphanRemoval = true)
		@JoinColumn
		private List<ansatt> ansatte;

		public String getNavn() {
			return navn;
		}

		public ansatt getAvdelingsleder() {
			return sjef_id;
		}

		public int getId() {
			return avdeling_id;
		}

		public List<ansatt> getAnsatte() {
			return ansatte;
		}

		@Override
		public String toString() {
			String s = "Avdeling:\t" + navn + "\n\tId:\t" + avdeling_id + "\n\tAvdelingsleder:\t" +
			           sjef_id.getFornavn() + " " + sjef_id.getEtternavn() +
			           "\nAvdelingsmedlemmer:\n";
			for (ansatt a : ansatte) {
				s += a.toString() + "\n";
			}
			return s;
		}
}
