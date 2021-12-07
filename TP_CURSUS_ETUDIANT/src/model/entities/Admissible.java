package model.entities;

import model.entities.exception.EtudiantException;
import model.entities.reference.Mention;

public interface Admissible {

     Mention calculerMention() throws EtudiantException;

}
