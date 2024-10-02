package com.loopsopenapispec.api.resources.contacts;

import java.util.function.Supplier;

import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.Suppliers;
import com.loopsopenapispec.api.resources.contacts.create.CreateClient;
import com.loopsopenapispec.api.resources.contacts.customfields.CustomFieldsClient;
import com.loopsopenapispec.api.resources.contacts.delete.DeleteClient;
import com.loopsopenapispec.api.resources.contacts.find.FindClient;
import com.loopsopenapispec.api.resources.contacts.update.UpdateClient;

public class ContactsClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<CustomFieldsClient> customFields;
    protected final Supplier<FindClient> find;
    protected final Supplier<CreateClient> create;
    protected final Supplier<DeleteClient> delete;
    protected final Supplier<UpdateClient> update;

    public ContactsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.customFields = Suppliers.memoize(() -> new CustomFieldsClient(clientOptions));
        this.find = Suppliers.memoize(() -> new FindClient(clientOptions));
        this.create = Suppliers.memoize(() -> new CreateClient(clientOptions));
        this.delete = Suppliers.memoize(() -> new DeleteClient(clientOptions));
        this.update = Suppliers.memoize(() -> new UpdateClient(clientOptions));
    }

    public CustomFieldsClient customFields() {
        return this.customFields.get();
    }

    public FindClient find() {
        return this.find.get();
    }

    public CreateClient create() {
        return this.create.get();
    }

    public DeleteClient delete () {
        return this.delete.get();
    }

    public UpdateClient update() {
        return this.update.get();
    }
}