package entities;

import entities.Billing;
import entities.Product;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-20T06:11:18")
@StaticMetamodel(DetailBilling.class)
public class DetailBilling_ { 

    public static volatile SingularAttribute<DetailBilling, Integer> id;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> total;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> unitaryPrice;
    public static volatile SingularAttribute<DetailBilling, Date> dateauthorization;
    public static volatile SingularAttribute<DetailBilling, String> autorizationCode;
    public static volatile SingularAttribute<DetailBilling, Integer> quantity;
    public static volatile SingularAttribute<DetailBilling, Billing> billingId;
    public static volatile SingularAttribute<DetailBilling, Date> date;
    public static volatile SingularAttribute<DetailBilling, Product> productId;

}