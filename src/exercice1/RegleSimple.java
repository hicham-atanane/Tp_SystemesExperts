package exercice1;

public class RegleSimple {
    private String premisse;
    private String conclusion;
    public RegleSimple() {
    }

    public RegleSimple(String premisse, String conclusion) {
        this.premisse = premisse;
        this.conclusion = conclusion;
    }

    public String getPremisse() {
        return premisse;
    }

    public void setPremisse(String premisse) {
        this.premisse = premisse;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
