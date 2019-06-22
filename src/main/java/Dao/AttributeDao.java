package Dao;

import Model.Attribute;
import Model.AttributeValue;

import java.util.List;

public interface AttributeDao {

    List<Attribute> getAllAttributes();

    Attribute getAttribute(int id);

    List<AttributeValue> getAttributeValues(int id);

    List<AttributeValue> getProductAttributes(int productId);

}
