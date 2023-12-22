package com.example.demo.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.example.demo.model.Personel;

import java.io.IOException;

public class PersonelSerializer extends StdSerializer<Personel> {

    public PersonelSerializer() {
        this(null);
    }

    public PersonelSerializer(Class<Personel> t) {
        super(t);
    }

    @Override
    public void serialize(
            Personel personel, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {

        jsonGenerator.writeStartObject();
        if (personel != null) {
            jsonGenerator.writeNumberField("id", personel.getId());
            jsonGenerator.writeStringField("name", personel.getName());
            // Add other fields as necessary
        }
        jsonGenerator.writeEndObject();
    }
}
