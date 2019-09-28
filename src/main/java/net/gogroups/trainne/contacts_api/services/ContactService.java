package net.gogroups.trainne.contacts_api.services;

import net.gogroups.trainne.contacts_api.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    List<ContactDTO> generate();
}
