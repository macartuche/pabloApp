package entities;

import entities.Billing;
import entities.Product;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-29T17:37:06")
@StaticMetamodel(DetailBilling.class)
public class DetailBilling_ { 

    public static volatile SingularAttribute<DetailBilling, Integer> id;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> total;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> unitaryPrice;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> valueDiscount;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> percentageDiscount;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> quantity;
    public static volatile SingularAttribute<DetailBilling, Billing> billingId;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> valueIva;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> percentageIva;
    public static volatile SingularAttribute<DetailBilling, BigDecimal> subtotal;
    public static volatile SingularAttribute<DetailBilling, Product> productId;

}