# Heroku Demo w/ Java 11, SpringBoot & MySQL Config

## Getting Started
This assumes that you have Git installed, created a [Heroku Account](https://signup.heroku.com/) and followed the instructions in the [Heroku Java tutorial](https://devcenter.heroku.com/articles/getting-started-with-java) to [install the Heroku CLI](https://devcenter.heroku.com/articles/getting-started-with-java#set-up).

Once you have that done, you can clone this repository and follow along to deploy a very basic Spring Rest Webservice.

## Structure & Requirements
Heroku applications are different from local Spring Boot applications in that they have a couple of extra requirements.

If you look at the contents of the top level of your repository you should see the following files:

```
HerokuDemo>> ls
  CreateTable.sql
  README.md
  pom.xml
  system.properties
  Procfile
  imgs
  src
```

Most of those should look familiar, but the `Procfile` & `system.properties` files are likely new to you.

### [Procfile](https://devcenter.heroku.com/articles/procfile)

> Our Procfile's contents:
```
web: java $JAVA_OPTS -jar target/*.jar  
web: java $JAVA_OPTS -Dserver.port=$PORT -jar target/*.jar  
```

The [Procfile](https://devcenter.heroku.com/articles/procfile) is a plaintext file that Heroku uses to specify the commands that will run on start up of your app. Heroku is smart enough to realize that a `pom.xml` file means that this is a java app, but the Procfile is needed to tell it that this is a java _web_ app, and it needs to execute the runnable java jar and bind it to the web port so that it can interact over HTTP.

### [system.properties](https://devcenter.heroku.com/articles/java-support#specifying-a-java-version)

> Our system.properties contents:
```
java.runtime.version=11
```

We're using our system.properties to bind our deploy to a particular java version (in this case 11) one of the many versions of java that [Heroku supports](https://devcenter.heroku.com/articles/java-support).

### Normal Java things
The other file contents should be familiar.

- `CreateTable.sql`
  - Just a sql creation script to set up a table when we have our database allocated via Heroku.
- `README.md`
  - What you're reading now!
- `pom.xml`
  - Maven's project object model. This is what Heroku uses to know how to build your app, & download the correct dependencies.
- `src`
  - The folder with all the actual code (and other property files)
- `imgs`
  - A folder with the images for this readme.

## Setting up the App

Make sure you have this locally cloned, and you have logged into git and heroku (super easy, just navigate to the repo, and use heroku login - it should pop up a browser window for you to authorize the CLI's login).

### Logging Into Heroku CLI
1. In your cloned repo `heroku login`
![imgs/HerokuLogin_CLIPrompt.png]
1. Press enter to accept browser popup & login...
![imgs/HerokuLogin_Browser.png]
1. Return to logged in CLI.
![imgs/HerokuLogin_CLISuccess.png]
