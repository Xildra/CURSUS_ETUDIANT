package model.entities.reference;

public final class ConstantesMetier {


    public static final String ETUDIANT_NOM_NULL_EXCEPTION = "Le nom est null";
    public static final String ETUDIANT_NOM_TAILLE_EXCEPTION = "Le nom doit contenir au moins 3 caractères !";
    public static final String ETUDIANT_PRENOM_NULL_EXCEPTION = "Le prenom est null";
    public static final String ETUDIANT_PRENOM_TAILLE_EXCEPTION = "Le prenom est vide";
    public static final String ETUDIANT_MAIL_TAILLE_EXCEPTION = "Le mail doit contenir au moins 1 caracteres";
    public static final String ETUDIANT_MAIL_NULL_EXCEPTION = "Le mail ne doit pas etre null";

    public static final String ETUDIANT_NOTE_INTERVALLE_EXCEPTION = String.format("Le note doit etre comprise entre %d et %d", ConstantesMetier.NOTE_MIN, ConstantesMetier.NOTE_MAX);
    public static final double NOTE_MAX = 20d;
    public static final double NOTE_MIN = 0d;
    public static final String ETUDIANT_NOT_INDEX_EXCEPTION = "L'indice de la note est erroné";
    public static final String MENTION_EXCEPTION = "Une erreur est survenue lors du calcul de la mention";
    public static final String CURSUS_NOM_NULL_EXCEPTION = " L'attribut nom est null";
    public static final String CURSUS_NOM_LENGTH_EXCEPTION = "La taille du nom doit etre superieur a 3 caracteres !";
    public static final String CURSUS_START_DATE_EXCEPTION = "Le date de debut est de moins de 30 jours";
    public static final String CURSUS_END_DATE_EXCEPTION = "La date de fin doit etre superieur a 4 jour de la date de debut";

    private ConstantesMetier() {}
}
