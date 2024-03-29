package com.feyfree.basic.serialization;

import org.apache.commons.lang3.SerializationUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

public class PersonSerializationUtil {
    private static final String FILE_NAME = "/Users/feyfree/data";

    public  void serializePersonListToFile(List<Person> personList) throws IOException {
        File file = new File(FILE_NAME);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(personList);
        }
    }

    public  List<Person> deserializePersonListFromFile() throws URISyntaxException, IOException {
        File file = new File(FILE_NAME);
        byte[] contents = Files.readAllBytes(file.toPath());
        return SerializationUtils.deserialize(contents);
    }
}
