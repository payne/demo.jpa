# demo.jpa

Messing around with Spring.... 

# Tests!
Not many, but some.   Please run `gradle test`


1. `gradle bootRun`
1. Visit http://localhost:8080/h2
1. URL: `jdbc:h2:file:./h2/data`
1. Password: `password`
1. Enjoy the h2 console!


# What's next??   
1. More tests!   
2. Apply the ideas from @SheikArbaz work.   I've cloned his repo and referenced his medium articles here: https://github.com/payne/todo-service 
3. Maybe some simple https://www.thymeleaf.org/ along with the tests
4. Maybe some simple seliunium stuff

# Fun queries
1. `select a.name, m.title from actor a, movie m where a.id=5;`
2. `select a.name, m.title from actor a, movie m where m.id=3;`
