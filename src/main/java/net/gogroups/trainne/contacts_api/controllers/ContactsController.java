package net.gogroups.trainne.contacts_api.controllers;

import net.gogroups.trainne.contacts_api.dto.ContactDTO;
import net.gogroups.trainne.contacts_api.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactsController {
    private ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> generateContacts(){
        return ResponseEntity.ok(contactService.generate());
    }
}
