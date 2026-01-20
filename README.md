# Deal API
This application is written with Java 21 and Apache Maven 3.9.9.

Run below commands on a terminal to test the application.

1.  git clone https://github.com/arunit9/deal.git
2.  cd deal
3.  ./mvnw spring-boot:run

In order to just build and run the unit tests, execute the command: mvn clean install

The application includes the following endpoints:

## Get Deals

This API returns a list of all the available restaurant deals that are active at a specified time of day. The API will take a single parameter named timeOfDay as a string parameter.
Eg: timeOfDay = “3:00pm” will query for all active deals at 3:00pm.

If timeOfDay is not supplied, it will return all deals

http://localhost:8080/api/deals?timeOfDay=3:00pm

The API will return an array of objects containing all matching deals, that looks like this:

```
{
  "deals": [
    {
      "restaurantObjectId": "...",
      "restaurantName": "...",
      "restaurantAddress1": "...",
      "restaurantSuburb": "...",
      "restaurantOpen": "...",
      "restaurantClose": "...",
      "dealObjectId": "...",
      "discount": "...",
      "dineIn": "...",
      "lightning": "...",
      "qtyLeft": "..."
    }
  ]
}
```

## Get Peak Time Window
This API calculates the ‘peak’ time window, during which most deals are available. This API does not take any parameters.

http://localhost:8080/api/deals/peak


The API will return an object that looks like this:
```
{
  "peakTimeStart": "...",
  "peakTimeEnd": "..."
}
```
