package com.espol.moderncontacts.logic;

import java.util.ListIterator;

import com.espol.moderncontacts.model.Contacto;

public class ScrollContacts {
    private Contacto initialContact;
    private ListIterator<Contacto> contactsIterator;

    public ScrollContacts() {
        initialContact = Contacto.getUserContacts().getFirst();
        contactsIterator = Contacto.getUserContacts().listIterator();
    }

    public Contacto nextContact() {
        return contactsIterator.next();
    }

    public Contacto previousContact() {
        return contactsIterator.previous();
    }

}
