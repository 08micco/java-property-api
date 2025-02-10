package com.mikkel.property;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Property property = new Property("Kollegievej 2B", "Apartment", "Mikkel Wissing", 100000.00);
        PropertyRepository repository = new PropertyRepository();

        repository.addProperty(property);
        List<Property> properties = repository.getAllProperties();
        System.out.println("Property added with id  " + property.getId() + " and address " + property.getAddress());
        for (Property p : properties) {
            System.out.println(p.getId() + p.getAddress());
        }
        Property propertyNew = new Property("Kollegievej 2B 8 4", "Apartment", "Mikkel Wissing", 100000.00);
        repository.updateProperty(1l, propertyNew);
        
        System.out.println("Property checked with id " + repository.getPropertyById(1l).getId() + " and address " + repository.getPropertyById(1l).getAddress());

        repository.removeProperty(1l);

        List<Property> propertiesNew = repository.getAllProperties();
        System.out.println("Property removed with id 1. New properties:");
        for (Property p : propertiesNew) {
            System.out.println(p.getId() + p.getAddress());
        }
    }
}
