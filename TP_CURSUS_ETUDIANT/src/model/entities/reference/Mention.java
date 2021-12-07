package model.entities.reference;

public enum Mention {

    RECALE("Recalé", 0.0, 10.0),
    PASSABLE("Passable", 10.0, 12.0),
    AB("Assez Bien", 12.0, 14.0),
    B("Bien", 14.0, 16.0),
    TB("Très Bien", 16.0, 21.0);

    private final String  libelle;
    private final double noteMinInclus;
    private final double noteMaxExclue;

    Mention(final String libelle,final double noteMinInclus,final double noteMaxExclue) {
        this.libelle = libelle;
        this.noteMinInclus = noteMinInclus;
        this.noteMaxExclue = noteMaxExclue;
    }

    public double getNoteMinInclus() {
        return this.noteMinInclus;
    }

    public double getNoteMaxExclue() {
        return this.noteMaxExclue;
    }

    public String getLibelle() {
        return this.libelle;
    }
}
