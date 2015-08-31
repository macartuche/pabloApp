package entities;

import entities.DetailBilling;
import entities.Family;
import entities.Inventary;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T09:24:46")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, BigDecimal> minvalue;
    public static volatile SingularAttribute<Product, BigDecimal> saleprice;
    public static volatile SingularAttribute<Product, BigDecimal> stock;
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-31T10:14:26")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, BigDecimal> percentageIva;
    public static volatile SingularAttribute<Product, String> code;
>>>>>>> Stashed changes
    public static volatile ListAttribute<Product, Inventary> inventaryList;
    public static volatile SingularAttribute<Product, BigDecimal> saleprice;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Boolean> active;
    public static volatile ListAttribute<Product, DetailBilling> detailBillingList;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Integer> stock;
    public static volatile SingularAttribute<Product, Family> family;
    public static volatile SingularAttribute<Product, BigDecimal> purchaseprice;
    public static volatile SingularAttribute<Product, Integer> minvalue;

}