public class Schiff {
    private String imoNr;
    private Integer teu;
    private Integer baujahr;
    private Integer bruttoraumzahl;
    private Integer nettoraumzahl;
    private String hafen_name;

    public Schiff() {
        this.imoNr = null;
        this.teu = null;
        this.baujahr = null;
        this.bruttoraumzahl = null;
        this.nettoraumzahl = null;
        this.hafen_name = null;
    }

    public String getImoNr() {
        return imoNr;
    }

    public void setImoNr(String imoNr) {
        this.imoNr = imoNr;
    }

    public Integer getTeu() {
        return teu;
    }

    public void setTeu(String teu) {
        this.teu = Integer.valueOf(teu);
    }

    public Integer getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(String baujahr) {
        this.baujahr = Integer.valueOf (baujahr);
    }

    public Integer getBruttoraumzahl() {
        return bruttoraumzahl;
    }

    public void setBruttoraumzahl(String bruttoraumzahl) {
        this.bruttoraumzahl = Integer.valueOf (bruttoraumzahl);
    }

    public Integer getNettoraumzahl() {
        return nettoraumzahl;
    }

    public void setNettoraumzahl(String nettoraumzahl) {
        this.nettoraumzahl = Integer.valueOf (nettoraumzahl);
    }

    public String getHafen_name() {
        return hafen_name;
    }

    public void setHafen_name(String hafen_name) {
        this.hafen_name = hafen_name;
    }
}
