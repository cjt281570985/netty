package com.cjt.netty.thrift;

import com.cjt.thrift.generated.DataException;
import com.cjt.thrift.generated.Person;
import com.cjt.thrift.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface{

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("getPersonByUsername username: " + username);

        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("savePerson Param: ");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
