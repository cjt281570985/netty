package com.cjt.netty.thrift;

import com.cjt.thrift.generated.Person;
import com.cjt.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {


    public static void main(String[] args) {

        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("-------------------------");

            Person person1 = new Person();
            person1.setUsername("李四");
            person1.setAge(25);
            person1.setMarried(true);

            client.savePerson(person1);
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage(), ex);
        }finally {
            transport.close();
        }


    }
}
