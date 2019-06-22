package Controller;


import Model.Attribute;
import Model.AttributeValue;
import Service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    private AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Attribute getAttribute(@PathVariable("id") int id) {
        return attributeService.getAttribute(id);
    }

    @RequestMapping(value = "/values/{id}", method = RequestMethod.GET)
    public List<AttributeValue> getAttributeValues(@PathVariable("id") int id) {
        return attributeService.getAttributeValues(id);
    }

    @RequestMapping(value = "/inProduct/{id}", method = RequestMethod.GET)
    public List<AttributeValue> getProductAttributes(@PathVariable("id") int productId) {
        return attributeService.getProductAttributes(productId);
    }
}
