package com.enotes;

import com.enotes.entity.Notes;
import com.enotes.repository.NotesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NotesRepositoryTests {
    @Autowired
    private NotesRepository notesRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveNotesTest(){
        Notes notes= new Notes();
        notes.setTitle("priti");
        notes.setContent("preeti@gmail.com");
//        userDtls.setPassword("preeti123");
//        userDtls.setAbout("student");

        notesRepository.save(notes);

        Assertions.assertThat(notes.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getNotesTest() {
        Notes notesGet = notesRepository.findById(1).get();
        Assertions.assertThat(notesGet.getId()).isEqualTo(0);
    }

    @Test
    @Order(3)
    public void getListOfNotesTest() {
        List<Notes> notes = notesRepository.findAll();
        Assertions.assertThat(notes.size()).isGreaterThan(0);
    }

    //
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateNoteTest() {
        Notes notes = notesRepository.findById(1).get();
        notes.setContent("Mane");
        Notes noteUpdated = notesRepository.save(notes);

        Assertions.assertThat(noteUpdated.getContent()).isEqualTo("Mane");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteNoteTest() {
        Notes notes = notesRepository.findById(1).get();
        notesRepository.delete(notes);
        Notes note1 = null;
        Optional<Notes> optionalNotes = notesRepository.findNotesByContent("Mane");
        if (optionalNotes.isPresent()) {
            note1 = optionalNotes.get();
        }
        Assertions.assertThat(note1).isNull();
    }

}
