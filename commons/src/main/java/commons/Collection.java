package commons;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Collection {

    @Id
    @GeneratedValue
    private long id;

    @JsonManagedReference
    @OneToMany
    private List<Translation> notes = new ArrayList<>();

    private boolean isPublic;

    private String creator;

    private String firstLanguage;

    private String secondLanguage;
}
