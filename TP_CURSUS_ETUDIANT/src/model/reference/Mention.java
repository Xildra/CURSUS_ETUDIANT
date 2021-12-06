package model.reference;

public enum Mention {

    RECALE("Recalé"),
    PASSABLE("Passable"),
    AB("Assez Bien"),
    B("Bien"),
    TB("Très Bien");

    private final String  libelle;

    Mention(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
