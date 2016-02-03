package model;

/**
 * Database stored entity for managing properties across the project
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */

public class Property extends BaseEntity<String> {

    private String value;
    private String description;
    private PropertyCategory  category;

    public Property() {
    }

    public Property(String id, String value, String description, PropertyCategory category) {
        this.setId(id);
        this.value = value;
        this.description = description;
        this.category = category;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PropertyCategory getCategory() {
        return category;
    }

    public void setCategory(PropertyCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + getId() + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category.getValue() + '\'' +
                '}';
    }


}
