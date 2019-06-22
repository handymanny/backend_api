package Service;

import Dao.AttributeDao;
import Model.Attribute;
import Model.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private AttributeDao attributeDao;

    @Autowired
    public AttributeService (AttributeDao attributeDao) {
        this.attributeDao = attributeDao;
    }

    public List<Attribute> getAllAttributes() {
        return attributeDao.getAllAttributes();
    }

    public Attribute getAttribute(int id) {
        return attributeDao.getAttribute(id);
    }

    public List<AttributeValue> getAttributeValues(int id) {
        return attributeDao.getAttributeValues(id);
    }

    public List<AttributeValue> getProductAttributes(int productId) {
        return attributeDao.getProductAttributes(productId);
    }
}
