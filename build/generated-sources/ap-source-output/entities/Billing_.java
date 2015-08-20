package entities;

import entities.ClientProvider;
import entities.DetailBilling;
import entities.Inventary;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-20T06:11:18")
@StaticMetamodel(Billing.class)
public class Billing_ { 

    public static volatile SingularAttribute<Billing, Integer> id;
    public static volatile SingularAttribute<Billing, BigDecimal> total;
    public static volatile ListAttribute<Billing, Inventary> inventaryList;
    public static volatile SingularAttribute<Billing, String> type;
    public static volatile SingularAttribute<Billing, BigDecimal> subtotal;
    public static volatile SingularAttribute<Billing, BigDecimal> taxes;
    public static volatile ListAttribute<Billing, DetailBilling> detailBillingList;
    public static volatile SingularAttribute<Billing, ClientProvider> clientProviderid;

}