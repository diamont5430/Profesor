package commons;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class Collection {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    @JsonManagedReference
    private List<Translation> translations = new ArrayList<>();

    private boolean isPublic;

    private String creator;

    private String firstLanguage;

    private String secondLanguage;

    public Collection() {
    }

    public Collection(String creator,String firstLanguage, String secondLanguage) {
        this.creator = creator;
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
    }

    public Collection(boolean isPublic, String creator, String firstLanguage, String secondLanguage) {
        this.isPublic = isPublic;
        this.creator = creator;
        this.firstLanguage = firstLanguage;
        this.secondLanguage = secondLanguage;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<Translation> getTranslations() {
        return translations;
    }
    public void setNotes(List<Translation> translations) {
        this.translations = translations;
    }
    public boolean isPublic() {
        return isPublic;
    }
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getFirstLanguage() {
        return firstLanguage;
    }
    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }
    public String getSecondLanguage() {
        return secondLanguage;
    }
    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    public void addTranslation(Translation translation) {
        translations.add(translation);
    }

    public void removeTranslation(Translation translation) {
        translations.remove(translation);
    }
}
