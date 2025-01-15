package server.api;

import commons.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.database.TranslationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/api/translation")
public class TranslationController {

    @Autowired
    private TranslationRepository translationRepository;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Translation> createTranslation(@RequestBody Translation translation) {
        Translation savedTranslation = translationRepository.save(translation);
        return ResponseEntity.ok(savedTranslation);
    }

    @GetMapping
    @ResponseBody
    public List<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }

    @DeleteMapping
    @ResponseBody
    public void deleteTranslation(@RequestBody Translation translation) {
        translationRepository.delete(translation);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Translation> getTranslationById(@RequestParam Long id) {
        return translationRepository.findById(id);
    }


    @GetMapping("/{language1}/{language2}")
    @ResponseBody
    public List<Translation> getTranslationsByCreator(@PathVariable String language1, @PathVariable String language2) {
        List<Translation> translations = translationRepository.findAll();
        List<Translation> translations1 = new ArrayList<>();
        for (Translation translation : translations) {
            if(translation.getTextInFirstLanguage().equals(language1) && translation.getTextInSecondLanguage().equals(language2)) {
                translations1.add(translation);
            }
        }
        return translations1;
    }

}
