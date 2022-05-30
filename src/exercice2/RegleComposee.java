package exercice2;

public class RegleComposee{
    private String conclusion;
    private String[] premisse;

    public RegleComposee(String premissesComposees, String reponse) {
        this.premisse = premissesComposees.split("&");
        this.conclusion = reponse;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String[] getPremisse() {
        return premisse;
    }

    public void setPremisse(String[] premisse) {
        this.premisse = premisse;
    }
}
