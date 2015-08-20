package entities;

import entities.DetailBilling;
import entities.Inventary;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-20T06:11:18")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Integer> minvalue;
    public static volatile SingularAttribute<Product, BigDecimal> saleprice;
    public static volatile SingularAttribute<Product, Integer> stock;
    public static volatile ListAttribute<Product, Inventary> inventaryList;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, BigDecimal> purchaseprice;
    public static volatile SingularAttribute<Product, Short> active;
    public static volatile SingularAttribute<Product, String> code;
    public static volatile ListAttribute<Product, DetailBilling> detailBillingList;

}