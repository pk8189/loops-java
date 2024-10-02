package com.loopsopenapispec.api;

import java.util.function.Supplier;

import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.Suppliers;
import com.loopsopenapispec.api.resources.contacts.ContactsClient;
import com.loopsopenapispec.api.resources.events.EventsClient;
import com.loopsopenapispec.api.resources.transactional.TransactionalClient;

public class Client {
    protected final ClientOptions clientOptions;
    protected final Supplier<ContactsClient> contacts;
    protected final Supplier<EventsClient> events;
    protected final Supplier<TransactionalClient> transactional;

    public Client(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.contacts = Suppliers.memoize(() -> new ContactsClient(clientOptions));
        this.events = Suppliers.memoize(() -> new EventsClient(clientOptions));
        this.transactional = Suppliers.memoize(() -> new TransactionalClient(clientOptions));
    }

    public ContactsClient contacts() {
        return this.contacts.get();
    }

    public EventsClient events() {
        return this.events.get();
    }

    public TransactionalClient transactional() {
        return this.transactional.get();
    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

}