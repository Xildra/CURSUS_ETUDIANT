package model.entities;

import model.reference.Mention;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Etudiant implements Admissible {

    private String mail;
    private String nom;
    private String prenom;
    private double moyenne;
    private List<Double> notes = new ArrayList<>();

    //Constructeur
    public Etudiant(String mail, String nom, String prenom) {
        this.setMail(mail);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    // GETTER ET SETTER
    public String getMail() {
        return this.mail;
    }

    public void setMail(final String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    //GETTER
    public double getMoyenne() {
        return this.moyenne;
    }

    public List<Double> getNotes() {
        return  this.notes;
    }

    public void ajouterNote(final double n){
        //TODO A CODER !!!
    }

    public void supprimerNote(final int index){
        //TODO A CODER !!!
    }

    private void calculerMoyenne(){
        //TODO a CODER !!!
    }


    @Override
    public Mention calculerMention() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(mail, etudiant.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "mail='" + mail + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                ", notes=" + notes +
                '}';
    }
}
