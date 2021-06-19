# Welcome! 
This is the country-listing restcountries.eu/v2 wrapper-service 
which gets all countries from the `restcountries.eu/rest/v2/all` endpoint,
list all the countries sorting the results in ascending order based on either `name`, `region`,
`population` or `area`, choosing to sort by `space` will make the program not sort by any order, just the order the 
response is loaded into the domain of this program.

Note, all countries' populations is formated in amount of millions (for countries with a population of less than 
`0.0` million, the program will display this in lesser decimals, like `0.03` and so on, this has no purpose, other 
than to make the results a bit more interesting). 

After listing of the result, the program will output the average population (in millions) based on all countries 
which is has more than `0.0` million people

Lastly the program will output both the smallest and biggest country based on area in square kilometers,
where the smallest country is Gibraltar and the Biggest is the Russian federation.

One cool thing i learned while doing this task is that Bouvet and Heard islands does not belong to any region in 
this world (at least according to the restcountries-api).

## Getting up and running

Build the project - compiling the whole module from scratch
```shell
mvn clean install
```
Run the project in terminal
```shell
// in the same dir-level as the project POM
mvn exec:java
```

or just press play in intellij.
