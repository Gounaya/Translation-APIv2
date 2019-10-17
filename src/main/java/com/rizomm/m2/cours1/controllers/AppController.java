package com.rizomm.m2.cours1.controllers;

import com.rizomm.m2.cours1.entities.App;
import com.rizomm.m2.cours1.entities.Entry;
import com.rizomm.m2.cours1.entities.Translation;
import com.rizomm.m2.cours1.services.AppService;
import com.rizomm.m2.cours1.services.EntryService;
import com.rizomm.m2.cours1.services.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController()
@RequestMapping("/applications")
public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    TransService transService;

    @Autowired
    EntryService entryService;

    /**
     * Create application
     * @param app
     * @return 201,202 if everything Okey (CREATED), else ERROR.
     */
    @PostMapping
    public ResponseEntity createApp(@RequestBody @Valid App app) {
        return new ResponseEntity(appService.createApp(app), HttpStatus.CREATED);
    }

    /**
     * @return Get all Applications
     */
    @GetMapping
    public ResponseEntity getApps(){
        return ResponseEntity.ok(appService.findAll());
    }

    /**
     * CREATE TRANSLATION
     * @param id of Application
     * @param tr Translation to add it
     * @return 201,202 if everything Okey (CREATED), else ERROR.
     */
    @PostMapping(path= "/{id}/translations")
    public ResponseEntity createTranslations(@PathVariable Integer id, @RequestBody @Valid Translation tr) {
        return new ResponseEntity(transService.createTranslation(tr), HttpStatus.CREATED);
    }

    /**
     * Update the entity of the translation
     * @param id2 the id of entry
     * @param entry to add it
     */
    @PutMapping(path= "/{id0}/translations/{id1}/entries/{id2}")
    public ResponseEntity updateEntry(@PathVariable Integer id1, @PathVariable Integer id2, @RequestBody @Valid Entry entry){
        entry.setId(id2);
        Entry updateEntry = entryService.updateEntry(entry);
        return ResponseEntity.ok(updateEntry);
    }

    /**
     * Get all Entires
     * @return list of entries
     */
    @GetMapping(path = "/entries")
    public ResponseEntity getAllEntries(){
        return ResponseEntity.ok(entryService.getAllEntries());
    }

    /**
     * GET all translations
     * @return list of translations
     */
    @GetMapping(path = "/translations")
    public ResponseEntity getAllTranslations(){
        return ResponseEntity.ok(transService.getAllTranslation());
    }

    /**
     * Get entry of a translation
     * @param id2 id of the entry that we want to get it
     * @return entry
     */
    @GetMapping(path= "/{id0}/translations/{id1}/entries/{id2}")
    public ResponseEntity getEntry(@PathVariable Integer id1, @PathVariable Integer id2){
        return ResponseEntity.ok(entryService.getEntry(id1,id2));
    }

    /**
     * Delete an entry of Translation
     * @param id1 id of the translation
     * @param id2 id of entry
     * @return NOT_FOUND : if doesnt find the entry, else ACCEPTED.
     */
    @DeleteMapping(path= "/{id0}/translations/{id1}/entries/{id2}")
    public ResponseEntity deleteEntry(@PathVariable Integer id1, @PathVariable Integer id2){
        Optional<Entry> getEntry = entryService.getEntry(id1, id2);
        if (!getEntry.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            entryService.deleteEntry(id1, id2);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
    }

}
