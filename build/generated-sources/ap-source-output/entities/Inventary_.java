package entities;

import entities.Billing;
import entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T09:24:46")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T10:14:26")
>>>>>>> Stashed changes
@StaticMetamodel(Inventary.class)
public class Inventary_ { 

    public static volatile SingularAttribute<Inventary, String> date;
    public static volatile SingularAttribute<Inventary, String> total;
    public static volatile SingularAttribute<Inventary, String> quantity;
    public static volatile SingularAttribute<Inventary, Billing> billingId;
    public static volatile SingularAttribute<Inventary, Product> productId;
    public static volatile SingularAttribute<Inventary, String> price;
    public static volatile SingularAttribute<Inventary, String> inventarycol;
    public static volatile SingularAttribute<Inventary, Integer> id;
    public static volatile SingularAttribute<Inventary, String> type;

}