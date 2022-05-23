package exercice2;

public class RegleComposee{
    private String conclusion;
    private String[] premisse;

    public RegleComposee(String premissesComposees, String reponse) {

        int count = 0;
        for (int i = 0; i < premissesComposees.length(); i++) {
            if (premissesComposees.charAt(i) == '&') {
                count++;
            }
        }
        this.premisse = premissesComposees.split("&",count);
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
