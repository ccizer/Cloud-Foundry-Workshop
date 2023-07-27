# Cloud Foundry Workshop

## Deploy the Customer Application on Cloud Foundry with provisioned database

### Roadmap

1. Make a build 
   * `mvn clean install`
2. Create a manifest.yml file 
   * `see manifest.yml file`
   * Set name of the application
   * Set memory to 768M
   * Set disk quota to 256M
   * Set path to the location of the Jar file
   * Set buildpacks to 'java_buildpack'
   * Define instances as a variable
   * Define route as a variable
   * Define SPRING_PROFILES_ACTIVE as an environment variable
3. Create vars file for each scopes
   * `see customer-app_<space>.yml files`
   * Set instances to 1 
   * Set route with environment based postfixes like test, stage, production
   * Set spring profiles active environment variable value for each environment
4. Push the application with the vars file 
   * `cf push --vars-file=<vars-file.yml>`
5. Check the logs for the active profile and any errors 
   * `cf logs --recent customer-app`
6. Provision a mariadb database with free plan and then bind it to the application 
   * `cf create-service a9s-mariadb104 mariadb-single-small customer-app-db`
   * `cf bind-service customer-app customer-app-db`
7. Check the environment variables and the application detail
   * `cf env customer-app`
   * `cf app customer-app`
8. Test application endpoints using postman tool or curl command on terminal
9. (Optional) Unmap and remove default route 
   * `cf unmap-route customer-app de.a9sapp.eu --hostname <DEFAULT_ROUTE_NAME>`
   * `cf delete-route de.a9sapp.eu --hostname <DEFAULT_ROUTE_NAME>`
10. (Optional) Make a change in the code and deploy the application using the strategy rolling flag
    * `cf push --vars-file=<vars-file.yml> --strategy rolling`
11. Rollback to a previous version
    * `cf rollback customer-app --version <VERSION_NUMBER>`
12. Share the database service and deploy the application to another space (!)
    * `cf share-service customer-app-db -s staging`
    * `cf push --vars-file=customer-app_stage.yml`
    * `cf bind-service customer-app customer-app-db`
13. Run Stratos using docker and connect it to the service provider
    * `docker run -p 4443:5443 splatform/stratos:latest`
14. Provision the Autoscaler and create a rule on Stratos
    * `cf create-service autoscaler autoscaler customer-app-autoscaler`
    * `cf bind-service customer-app customer-app-autoscaler`
15. Remove all resources
    * `cf delete -r customer-app`
    * `cf delete-service -f customer-app-db`
    * `cf delete-service -f customer-app-autoscaler`

### Tips and Tricks

* Free plan is limited to 1G memory and supports only JRE8 for Java
* Do not forget to run the commands `restart/restage` the application after a change
* Route should be defined as `routes: - route:` in the manifest.yml
* `VCAP_SERVICES` credentials are set as properties by Spring Boot automatically
* (!) To deploy another the application to another space, remove the existing one
* Domain must always be set as `de.a9sapp.eu`
* Example get call: `curl customer-app-test.de.a9sapp.eu`
* Example post call: `curl -X POST customer-app-test.de.a9sapp.eu \
  -H "Content-Type: application/json" \
  -d '{"name": "Can"}' `