package commons;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Translation {

    @Id
    @GeneratedValue
    public long id;


    public String textInFirstLanguage;
    public String textInSecondLanguage;

    public Translation(String textInFirstLanguage, String textInSecondLanguage) {
        this.textInFirstLanguage = textInFirstLanguage;
        this.textInSecondLanguage = textInSecondLanguage;
    }

    public Translation() {

    }

    public String getTextInFirstLanguage() {
        return textInFirstLanguage;
    }
    public void setTextInFirstLanguage(String textInFirstLanguage) {
        this.textInFirstLanguage = textInFirstLanguage;
    }
    public String getTextInSecondLanguage() {
        return textInSecondLanguage;
    }
    public void setTextInSecondLanguage(String textInSecondLanguage) {
        this.textInSecondLanguage = textInSecondLanguage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
