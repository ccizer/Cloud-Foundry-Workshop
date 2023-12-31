# Cloud Foundry Workshop

## Deploy the Customer Application on Cloud Foundry with provisioned database

### Roadmap

1. Make a build
2. Create a manifest.yml file
   * Set name of the application
   * Set memory to 768M
   * Set disk quota to 256M
   * Set path to the location of the Jar file
   * Set buildpacks to 'java_buildpack'
   * Define instances as a variable
   * Define route as a variable
   * Define SPRING_PROFILES_ACTIVE as an environment variable
3. Create vars file for each scopes
   * Set instances to 1 
   * Set route with environment based postfixes like test, stage, production
   * Set spring profiles active environment variable value for each environment
4. Push the application with the vars file
5. Check the logs for the active profile and any errors
6. Provision a mariadb database with free plan and then bind it to the application
7. Check the environment variables and the application details
8. Test application endpoints using postman tool or curl command on terminal
9. Run Stratos using docker and connect it to the service provider
10. Provision the Autoscaler and create a scale rule on Stratos
11. Share the database service and deploy the application to another space (!)
12. Create/map a new route and unmap/delete old one
13. Test application endpoints using postman tool or curl command on terminal again
14. (Optional) Make a change in the code and deploy the application using the strategy rolling flag
15. (Optional) Rollback to a previous version
16. Remove all resources

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

You can find the solutions in the `solution` branch of the project.