package Model;

public class AttributeValue {

    private int attributeValueId;
    private int attribute;
    private String value;

    public AttributeValue(int attributeValueId, int attribute, String value) {
        this.attributeValueId = attributeValueId;
        this.attribute = attribute;
        this.value = value;
    }

    public AttributeValue() {}

    public int getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(int attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
