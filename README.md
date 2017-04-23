# CookUrself

1. What is the proposed name for your Web application?
    - CookUrself
2. Who is the target audience for your Web application?
    - People want to effciently cook beautiful food by themselves 
3. What problem is it intended to solve for the target audience?
    - There are thousands of food style in the world. Different people obviously like different kind of food. The hardest thing is how to find what food the target audience really want to cook. As a result, it is necessary to let all the audience be able to interact with each other so that people can get recipes they really like to do.           
4. How will it meet the minimum project requirements?
    - Most of the content will be freely accessible without a login. People can browse the daily recommendation and search what they want as a guest. All data will be accessible through RESTful services by JSON and XML formats. Audience can also log in to interact with others or give a review or feedback for each food.
5. Why is your proposed Web application unique or creative beyond simply meeting the minimum requirements?
     - It's very important to give audience a great browsing experience. So I will develop a simply UI in order to let users easily access to everything. Also, there will some advertisement which are designed to attract more users. It's also very critical to make all the recipes included images and feedbacks be true. I will try to estimate if a recipe or review is qualified to be posted online.


## Build status


[![Build Status](https://travis-ci.org/infsci2560sp17/full-stack-web-zhaoyingpei99.svg?branch=master)](https://travis-ci.org/infsci2560sp17/full-stack-web-zhaoyingpei99)

## Changelog

[Changelog](https://github.com/infsci2560sp17/full-stack-web-zhaoyingpei99/blob/master/Changelog.md)

## Web Site

[CookUrSelf](https://fathomless-reef-11403.herokuapp.com/)

## Key Features


* Feature 1 : Users can sign up and have their own accounts
* Feature 2 : Users can add food either by themselves or choose from food lobby (published food) 
* Feature 3 : Users can add reviews, recipes and ratings for a food 

## Project Details

### Landing Page

Description : When entering welcome page, people can do: 1. Go directly to users' profile. 2. Browse lobby to see public food. 
[](http://i.imgur.com/pUAKIzc.jpg)

### User Input Form

User Inpit Form in Users' Profile.
[](http://i.imgur.com/zU42klU.png)


User Inpit Form when adding reviews.
[](http://i.imgur.com/GvwX4Zk.png)
## API

### API Method 1

    GET /public/api/publicfoods/2


#### Response

A JSON content: {"title":"Tako","cookingStyle":"Mexican","ifpublic":1,"id":2}

#### Errors

All known errors cause the resource to return HTTP error code header together with a JSON array containing at least 'status' and 'error' keys describing the source of error.

- **404 Not Found** — The photo was not found.

#### Example

##### Request

    POST /public/api/publicfoods/14

##### Parameters

    {
        "title":"Noodles",
        "cookingStyle":"Others",
        "ifpublic":1,
    }


##### JSON Response

```json
    {
        "title":"Noodles",
        "cookingStyle":"Others",
        "ifpublic":1,
    }



## Technologies Used


- [Spring Boot](https://projects.spring.io/spring-boot/) - Takes an opinionated view of building production-ready Spring applications.
- [Thymleaf](http://www.thymeleaf.org/) - Thymeleaf is a modern server-side Java template engine for both web and standalone environments.
- [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.
- [Heroku](https://www.heroku.com/) - Heroku is a cloud Platform-as-a-Service (PaaS) supporting several programming languages that is used as a web application deployment model.
- [Bootstrap](getbootstrap.com/) - Bootstrap is a free and open-source front-end web framework for designing websites and web applications.  
