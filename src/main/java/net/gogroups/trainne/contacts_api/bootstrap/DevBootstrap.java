package net.gogroups.trainne.contacts_api.bootstrap;

import net.gogroups.trainne.contacts_api.models.Contact;
import net.gogroups.trainne.contacts_api.repositories.ContactsRepository;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ContactsRepository contactsRepository;

    @Autowired
    public DevBootstrap(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData(100);
    }

    private void initData(int count) {
        for(int i = 0; i < count; i++){
            String email = "example@example"+i+".com";
            String phone = "67" + (int)(Math.random() * 1000000 + 9999999);
            String name = "contact " + i;
            Contact contact = new Contact();
            contact.setEmail(email);
            contact.setName(name);
            contact.setPhone(phone);
            contactsRepository.save(contact);
        }
    }
}
