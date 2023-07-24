# Cloud Foundry Workshop

## Deploy the Customer Application on Cloud Foundry with provisioned database

### Roadmap

- [ ] Make a build
- [ ] Create a manifest.yml file
  - [ ] Set name of the application
  - [ ] Set memory to 768M
  - [ ] Set disk quota to 256M
  - [ ] Set path to the location of the Jar file
  - [ ] Set buildpacks to 'java_buildpack'
  - [ ] Define instances as a variable
  - [ ] Define route as a variable
  - [ ] Define SPRING_PROFILES_ACTIVE as an environment variable
- [ ] Create vars file for each scopes
  - [ ] Set instances to 1 
  - [ ] Set route with environment based postfixes like test, stage, production
  - [ ] Set spring profiles active environment variable value for each environment
- [ ] Push the application
- [ ] Check the logs for the active profile and any errors
- [ ] Check the environment variables
- [ ] Unmap and remove default route
- [ ] Make a change in the code and deploy the application using the strategy rolling flag
- [ ] Rollback to a previous version
- [ ] (Optional) Share the database service and deploy the application to another space. 

### Tips and Tricks

* Free plan is limited to 1G memory
* Do not forget to run the commands `restart/restage` the application after a change
* Route should be defined as `routes: - route:` in the manifest.yml
* `VCAP_SERVICES` credentials are set as properties by Spring Boot automatically
* To deploy another the application to another space, remove the existing one