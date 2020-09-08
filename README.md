# Promotion Engine
Promotion engine implementation Spring boot project

## Solution

Rules, item and respective prices and item and their quantities in checkout basket are sent. <br />
A response is received which states the total calculated price after applying the promotion.


## Build & Run

### Prerequisite
1. Java 8
2. Maven

### Commands

This is a Maven project and can be built by using - 
```bash
mvn clean install
```
Go to /target and you will find jar created by the name pengine-1.0.0.jar

To run the jar file -
```bash
java -jar pengine-1.0.0.jar
```

### Request
```
POST http://localhost:8080/calculate
```
```json
{
  "rules": [
    {
      "rulePrice": 130,
      "ruleItems": [
        {
          "skuId": "A",
          "count": 3
        }
      ]
    },
    {
      "rulePrice": 45,
      "ruleItems": [
        {
          "skuId": "B",
          "count": 2
        }
      ]
    },
    {
      "rulePrice": 30,
      "ruleItems": [
        {
          "skuId": "C",
          "count": 1
        },
        {
          "skuId": "D",
          "count": 1
        }
      ]
    }
  ],
  "priceMap": {
    "A": 50,
    "B": 30,
    "C": 20,
    "D": 15
  },
  "itemQuantityMap": {
    "A": 5,
    "B": 5,
    "C": 1
  }
}
```

### Response
```json
{
    "totalPrice": 370
}
```

### Special notes
To change quantity, please change the respective item quanttities in the "itemQuantityMap" of the sample input JSON
