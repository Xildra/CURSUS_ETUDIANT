package model.entities;

import model.entities.reference.ConstantesMetier;
import model.entities.reference.CursusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Cursus {

    private String nom;
    private LocalDate dateDebut;
    private  LocalDate dateFin;

    public Cursus(String nom, LocalDate dateDebut, LocalDate dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getNom() {
        return this.nom;
    }

    private void setNom(final String nom) throws CursusException {
        if (this.nom.isBlank()){
            throw new CursusException(ConstantesMetier.CURSUS_NOM_NULL_EXCEPTION);
        }
        if (this.nom.length() <3){
            throw new CursusException(ConstantesMetier.CURSUS_NOM_LENGTH_EXCEPTION);
        }
        this.nom = nom;
    }

    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(final LocalDate dateDebut) throws CursusException {
        if (!this.dateDebut.isEqual(LocalDate.now().plusDays(30))){
            throw new CursusException(ConstantesMetier.CURSUS_START_DATE_EXCEPTION);
        }
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(final LocalDate dateFin) throws CursusException {
        if (!this.dateFin.isEqual(LocalDate.now().plusDays(4))){
            throw new CursusException(ConstantesMetier.CURSUS_END_DATE_EXCEPTION);
        }
        this.dateFin = dateFin;
    }

    public List<Etudiant> ajouterEtudiant{
        //TODO A CODER
    }

    private void isEtudiantNull(Etudiant etudiant){
        //TODO A CODER
    }

    public void supprimerEtudiant(Etudiant etudiant){
        //TODO A CODER
    }

    public double calculerMoyenneCursus(){
        //TODO A CODER
    }

    public List<Etudiant> calculerClassement(){
        //TODO A CODER
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursus cursus = (Cursus) o;
        return nom.equals(cursus.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
