package com.example.finalandroidproject;

import java.util.ArrayList;
import java.util.Collections;

public class State {
    public int selectedNoteIndex;
    public Note selectedNote;
    public ArrayList<Note> notes;

    public State(ArrayList<Note> notes, Note selectedNote, int selectedNoteIndex) {
        this.notes = notes;
        this.selectedNote = selectedNote;
        this.selectedNoteIndex = selectedNoteIndex;
    }

    public int getSelectedNoteIndex() {
        return selectedNoteIndex;
    }

    public void setSelectedNoteIndex(int selectedNoteIndex) {
        this.selectedNoteIndex = selectedNoteIndex;
    }

    public Note getSelectedNote() {
        return selectedNote;
    }

    public void setSelectedNote(Note selectedNote) {
        this.selectedNote = selectedNote;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void sort() {
        Collections.sort(notes);
    }

    public void deleteNote(int i) {
        notes.remove(i);
    }

}
