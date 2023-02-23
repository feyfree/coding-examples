package com.feyfree.others;

import com.feyfree.basic.serialization.Person;
import com.feyfree.basic.serialization.PersonSerializationUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TestSerialization {
    @Test
    public void serializeAndDeserializePersonList() throws IOException, URISyntaxException {
        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("firstname1", "lastname1"));
//        personList.add(new Person("firstname2", "lastname2"));
//        personList.add(new Person("firstname3", "lastname3"));
//        personList.add(new Person("firstname4", "lastname4"));


        PersonSerializationUtil personSerializationUtil = new PersonSerializationUtil();
        personSerializationUtil.serializePersonListToFile(personList);
        List<Person> deserializedList = personSerializationUtil.deserializePersonListFromFile();

        Assert.assertEquals(4, deserializedList.size());
        Assert.assertEquals("firstname2", deserializedList.get(1).getFirstName());
    }


    @Test
    public void deserializePersonList() throws IOException, URISyntaxException {
        PersonSerializationUtil personSerializationUtil = new PersonSerializationUtil();
        personSerializationUtil.deserializePersonListFromFile();
    }
}
