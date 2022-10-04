

package entity;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int cin ; 
	private String nom ; 
	private String prenom ; 
 
	public Employee(int i, String nom, String prenom) {
 		this.cin = i;
		this.nom = nom;
		this.prenom = prenom;
	}
	public int getCin() {
		return cin;
	}
	@XmlElement(name="cin",required=true)
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	@XmlElement(name="LastName")
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	@XmlElement(name="FirstName")
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cin, nom, prenom);
	}
	public Employee() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return cin == other.cin && Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	@Override
	public String toString() {
		return "Employee [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	



}
