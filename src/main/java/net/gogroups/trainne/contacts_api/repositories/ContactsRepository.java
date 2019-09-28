package net.gogroups.trainne.contacts_api.repositories;

import net.gogroups.trainne.contacts_api.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends CrudRepository<Contact, Long> {
}
