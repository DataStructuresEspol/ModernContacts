package com.espol.moderncontacts.logic;

import com.espol.moderncontacts.model.Contacto;

public class ScrollContacts {
    private int currentContactIndex;
    private Contacto currentObservedContact;
    private final int size;

    public ScrollContacts() {
        currentObservedContact = Contacto.getUserContacts().getFirst();
        currentContactIndex = 0;
        size = Contacto.getUserContacts().size();
    }

    public void nextContact() {
        if (currentContactIndex+1 >= size) {
            currentContactIndex = 0;
            currentObservedContact = Contacto.getUserContacts().getFirst();
        }
        else {
            currentContactIndex++;
            currentObservedContact = Contacto.getUserContacts().get(currentContactIndex);
        }
    }

    public void previousContact() {
        if (currentContactIndex-1 < 0) {
            currentContactIndex = size - 1;
            currentObservedContact = Contacto.getUserContacts().getLast();
        }
        else {
            currentContactIndex--;
            currentObservedContact = Contacto.getUserContacts().get(currentContactIndex);
        }
    }

    public Contacto getCurrentObservedContact() {
        return currentObservedContact;
    }
}
