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

TODO : Please list key features of your project.

* Key Feature 1
* Key Feature 2
* Key Feature N

## Project Details

### Landing Page

TODO : please provide a description of your landing page inluding a screen shot ![](https://.../image.JPG)

### User Input Form

TODO : please provide a description of at least 1 user input form including a screen shot ![](https://.../image.jpg)

## API

TODO : please provide a description of at least 1 API including a sample of request data and response data in both XML and JSON format.

### API Method 1

    POST photos/:id/tags

#### Parameters

- **id** _(required)_ — The Photo ID to add tags for.
- **tags** _(required)_ — Comma separated tags.

#### Response

A JSON or XMLobject containing the PhotoID and list of tags accepted.

#### Errors

All known errors cause the resource to return HTTP error code header together with a JSON array containing at least 'status' and 'error' keys describing the source of error.

- **404 Not Found** — The photo was not found.

#### Example

##### Request

    POST /v1/photos/123456/tags

##### Body

    tags=cute,puppy


##### JSON Response

```json
{
    "photoId": 123456,
    "tags": ["cute", "puppy"]
}
```

##### XML Response

```xml
<?xml version="1.0" encoding="UTF-8"?>
<PhotoTags>
    <photoId>123456</PhotoId>
        <tags>
            <tag>cute</tag>
            <tag>puppy</tag>
        </tags>
</PhotoTags>
```

## Technologies Used

TODO : List all technologies used in your project

- [Spring Boot](https://projects.spring.io/spring-boot/) - Takes an opinionated view of building production-ready Spring applications.
- [Thymleaf](http://www.thymeleaf.org/) - Thymeleaf is a modern server-side Java template engine for both web and standalone environments.
- [Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.