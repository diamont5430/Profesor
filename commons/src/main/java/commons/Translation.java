package commons;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Translation {

    @Id
    @GeneratedValue
    public long id;


    private String textInFirstLanguage;
    private String textInSecondLanguage;

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

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translation that = (Translation) o;
        if(this.id != that.id) return false;
        if (!Objects.equals(textInFirstLanguage, that.textInFirstLanguage)) return false;
        return Objects.equals(textInSecondLanguage, that.textInSecondLanguage);
    }
}
