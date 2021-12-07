package model.entities;

import model.entities.exception.EtudiantException;
import model.entities.reference.ConstantesMetier;
import model.entities.reference.Mention;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Représente un étudiant. Un étudiant est admissible ou non.
 * L’identité des étudiants sera définie sur l’attribut mail.
 * Le mail sera contrôlé.
 * Le nom doit être composé d’au moins 3 caractères.
 * Le prénom ne peut pas être une chaine vide.
 * Une note doit être comprise entre 0 et 20.
 * Dans le cas de suppression d’une note, vous contrôlerez que l’indice est valide.
 */

public class Etudiant implements Admissible {

    private String mail;
    private String nom;
    private String prenom;
    private double moyenne;
    private List<Double> notes = new ArrayList<>();

    //Constructeur
    public Etudiant(String mail, String nom, String prenom) throws EtudiantException {
        this.setMail(mail);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    // GETTER ET SETTER
    public String getMail() {

        return this.mail;
    }

    /**
     * Affecte le mail de l'etudiant
     * @param mail mail de l'etudiant
     * @throws EtudiantException controle si le mail est null et si il contient au moins 1 caracteres
     */
    public void setMail(final String mail) throws EtudiantException {
        if (mail == null){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_MAIL_NULL_EXCEPTION);
        }
        if (mail.isBlank()){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_MAIL_TAILLE_EXCEPTION);
        }
        this.mail = mail;
    }

    public String getNom() {
        return this.nom;
    }

    /**
     * Affecte le nom de l'etudiant, en controlant si il est null
     * et si il a au moins 3 caracteres.
     * @param nom nom de l'etudiant.
     * @throws EtudiantException si le nom passé en parametre est null et ou contient  au moins  3 caracteres
     */
    public void setNom(final String nom)  throws EtudiantException{
        if (nom == null){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_NOM_NULL_EXCEPTION);
        }
        if (nom.trim().length() < 3){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_NOM_TAILLE_EXCEPTION);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(final String prenom) throws EtudiantException {
        if (prenom == null){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_PRENOM_NULL_EXCEPTION);
        }
        if (prenom.isBlank()){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_PRENOM_TAILLE_EXCEPTION);
        }

        this.prenom = prenom;
    }

    //GETTER
    public double getMoyenne() {
        return this.moyenne;
    }

    public List<Double> getNotes() {
        return  this.notes;
    }

    /**
     * ajout d'une note compris entre 0 et 20
     * @param n variable contenant la note
     * @throws EtudiantException test si le parametre entre est compris entre 0 et 20 si non on lève une exception
     */
    public void ajouterNote(final double n) throws EtudiantException {
        if (n < ConstantesMetier.NOTE_MIN || n > ConstantesMetier.NOTE_MAX){
            throw new EtudiantException(ConstantesMetier.ETUDIANT_NOTE_INTERVALLE_EXCEPTION);
        }
        this.notes.add(n);
    }

    /**
     * supprime la note correspondant a l'indice (index) donné
     * @param index indice de la note que l'on veut supprimer
     * @throws EtudiantException test si l'indice precisé fait partie de la list (la numerotation des indices commence a 0)
     * Exemple: l'indice de la premiere note = 0 ainsi de suite.
     */
    public void supprimerNote(final int index) throws EtudiantException {
        if (index > this.notes.size()-1 || index < 0){
           throw new EtudiantException(ConstantesMetier.ETUDIANT_NOT_INDEX_EXCEPTION);
        }
        this.notes.remove(index);
    }

    private void calculerMoyenne(){
        if (!this.notes.isEmpty()) {
            BigDecimal somme = BigDecimal.ZERO;
            for (double n : this.notes){
                somme = somme.add(BigDecimal.valueOf(n));
            }
            this.moyenne = somme.divide(BigDecimal.valueOf(this.notes.size()), RoundingMode.HALF_UP).doubleValue();
        }
        else{
            this.moyenne = 0.0;
        }


    }

    /**
     * calcul de la mention en fonction de la note
     * @return retourne la mention approprie a la note
     * @throws EtudiantException
     */
    @Override
    public Mention calculerMention() throws EtudiantException {
        for (Mention mention : Mention.values())
            if (this.getMoyenne() >= mention.getNoteMinInclus() && this.getMoyenne() < mention.getNoteMaxExclue()){
                return mention;
            }
        throw new EtudiantException(ConstantesMetier.MENTION_EXCEPTION);
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
