package net.gogroups.trainne.contacts_api.services;

import net.gogroups.trainne.contacts_api.dto.ContactDTO;
import net.gogroups.trainne.contacts_api.models.Contact;
import net.gogroups.trainne.contacts_api.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactsRepository contactsRepository;
    @Autowired
    public ContactServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public List<ContactDTO> generate() {
        Iterable<Contact> contacts = contactsRepository.findAll();
        List<ContactDTO> contactDTOS = new ArrayList<>();
        for(Contact contact : contacts) {
            ContactDTO contactDTO = new ContactDTO();
            contactDTO.setEmail(contact.getEmail());
            contactDTO.setName(contact.getName());
            contactDTO.setId(contact.getId());
            contactDTOS.add(contactDTO);
        }
        return contactDTOS;
    }
}
