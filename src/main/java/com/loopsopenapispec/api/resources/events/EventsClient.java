package com.loopsopenapispec.api.resources.events;

import java.util.function.Supplier;

import com.loopsopenapispec.api.core.ClientOptions;
import com.loopsopenapispec.api.core.Suppliers;
import com.loopsopenapispec.api.resources.events.send.SendClient;

public class EventsClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<SendClient> send;

    public EventsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.send = Suppliers.memoize(() -> new SendClient(clientOptions));
    }

    public SendClient send() {
        return this.send.get();
    }
}