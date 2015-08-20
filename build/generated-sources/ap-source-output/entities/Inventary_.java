package entities;

import entities.Billing;
import entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-20T06:11:18")
@StaticMetamodel(Inventary.class)
public class Inventary_ { 

    public static volatile SingularAttribute<Inventary, Integer> id;
    public static volatile SingularAttribute<Inventary, String> total;
    public static volatile SingularAttribute<Inventary, String> price;
    public static volatile SingularAttribute<Inventary, String> inventarycol;
    public static volatile SingularAttribute<Inventary, String> quantity;
    public static volatile SingularAttribute<Inventary, Billing> billingId;
    public static volatile SingularAttribute<Inventary, String> type;
    public static volatile SingularAttribute<Inventary, String> date;
    public static volatile SingularAttribute<Inventary, Product> productId;

}