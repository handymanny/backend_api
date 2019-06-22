# Backend Api ( Turing Challenge )
This is my first project I am commiting to github, on here I am creating a backend api from a given database.

## Creation progress

### Day 1
* On the first day of creation:
     - Reasearched the scope of the project and started to plan expected outcome
	 - Started creating models for the projects ( Pojo )
	 - Created the databse connection
	      - Created some of the repositories ( DataAccess ) objects
		  - Created the methods to communicate and pass the data to next method
	 - Created some of the Controller, Dao and service objects for:
	      - Department
		  - Category


### Day 2
* On the second day of creation:
	 - Reasearched the propper implementaion for the bearer token
	 - Included the json webtokens library inside my project for securirty
	 - Created a few more controller, dao and service objects for:
		 - Product
		 - Attribute
	 - Had my first problem with the program when I was creating the method that would return all products
		 - I was trying to figure out how to return the propper object that would match the desired output
		 - Tested out all of the endpoints to make sure I was getting desired response
		 - I was able to fix this by changing this:
```java
public List<Product> getAllProducts(int page, int limit, int descLength) {
        page = page -1;
        if (page > 0) {page = (page * limit);}

        return productDao.getAllProducts(page, limit, descLength);
}

// To this

public String getAllProducts(int page, int limit, int descLength) {
        page = page -1;
        if (page > 0) {page = (page * limit);}

        List<Product> products = productDao.getAllProducts(page, limit, descLength);
        Integer count = getProductCount();
        return convertObjects(products, count);
}
```