package entities;

import entities.Billing;
import entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-27T20:08:02")
@StaticMetamodel(ClientProvider.class)
public class ClientProvider_ { 

    public static volatile SingularAttribute<ClientProvider, Integer> id;
    public static volatile SingularAttribute<ClientProvider, Boolean> activeprovider;
    public static volatile SingularAttribute<ClientProvider, Boolean> client;
    public static volatile ListAttribute<ClientProvider, Billing> billingList;
    public static volatile SingularAttribute<ClientProvider, Person> personId;
    public static volatile SingularAttribute<ClientProvider, Boolean> activeclient;
    public static volatile SingularAttribute<ClientProvider, Boolean> provider;

}