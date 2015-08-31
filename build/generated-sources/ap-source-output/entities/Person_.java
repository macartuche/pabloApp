package entities;

import entities.ClientProvider;
import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T09:24:46")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T10:14:26")
>>>>>>> Stashed changes
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile ListAttribute<Person, Users> usersList;
    public static volatile SingularAttribute<Person, String> names;
    public static volatile SingularAttribute<Person, String> address;
    public static volatile SingularAttribute<Person, String> passport;
    public static volatile SingularAttribute<Person, String> phone;
    public static volatile SingularAttribute<Person, String> sex;
    public static volatile SingularAttribute<Person, String> photo;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile ListAttribute<Person, ClientProvider> clientProviderList;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, String> lastname;

}