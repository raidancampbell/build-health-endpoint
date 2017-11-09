# build-health-endpoint
A proof-of-concept for providing artifact build details in a REST endpoint.  Built with Spring Boot and Maven.
Maven is required to inject compile-time information, Spring Boot is used to make the rest server easier.

This is a proof of concept and will not work as a dependency, instead you should rip the code out and use it yourself

Sample output
----------
```
{  
   "artifact":"build-ping",
   "build_date":"2017-11-09 01:49",
   "build_env_spring_profile":"${env.SPRING_PROFILES_ACTIVE}",
   "build_spring_profile":"${spring.profiles.active}",
   "build_os_version":"10.11.6",
   "name":"build-ping",
   "description":"Provides a proof-of-concept controller for showing build details of the current project",
   "build_arch":"x86_64",
   "build_user":"aidan",
   "build_os":"Mac OS X",
   "version":"1.0-SNAPSHOT"
}
```
