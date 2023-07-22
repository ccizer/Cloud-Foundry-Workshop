<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/ccizer/Cloud-Foundry-Workshop">
    <img src="images/cloudfoundry.webp" alt="Logo" width="500" height="300">
  </a>

<h3 align="center">Cloud Foundry Workshop</h3>
  <p align="center">
    A brief introduction to Cloud Foundry  
    <br />
    <br />
    <a href="https://github.com/ccizer/Cloud-Foundry-Workshop/tree/main/workshop">Workshop</a>
    ·
    <a href="https://github.com/ccizer/Cloud-Foundry-Workshop/tree/main/resources">Resources</a>
  </p>
</div>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#what-is-cloud-foundry">What is Cloud Foundry</a></li>
    <li><a href="#prerequisites">Prerequisites</a></li>
    <li><a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#cli">The CLI</a></li>
        <li><a href="#using-cloud-foundry">Using a Cloud Foundry</a></li>
        <li><a href="#deploying-your-first-app">Deploying your First App</a></li>
     </ul>
    </li>
    <li><a href="#core-concepts">Core Concepts</a>
      <ul>
        <li><a href="#orgs-and-spaces">Orgs and Spaces</a></li>
        <li><a href="#targeting">Targeting</a></li>
        <li><a href="#scope-and-names">Scope and Names</a></li>
        <li><a href="#guids-and-renaming">GUIDs and Renaming</a></li>
        <li><a href="#deleting-app">Deleting App</a></li>
      </ul>
     </li>
  </ol>
</details>

<!-- What is Cloud Foundry -->
## What is Cloud Foundry

Cloud Foundry is an open-source platform designed to assist application development teams in building, 
testing, deploying, and scaling their applications. It offers a robust infrastructure, 
including the Kubernetes platform, developer frameworks, and a variety of application services.

Supported by tech giants like Google, IBM, Microsoft, SAP, SUSE, and VMware, Cloud Foundry is renowned for 
its remarkable user experience for developers. It streamlines the deployment process, relieving developers 
from tedious tasks, and enables them to concentrate solely on coding and delivering business results.

In essence, Cloud Foundry mitigates the complexity of managing and executing containerized workloads for developers, 
permitting them to focus on the application code and its impact on the business. 
In addition to simplifying these processes, Cloud Foundry also comes with inherent benefits such as the provision 
of containerization and packaging.

<!-- Prerequisites -->
## Prerequisites

Before you begin utilizing Cloud Foundry, there are several preliminary steps that must be completed.

* Install CF CLI
  ```sh
  brew install cf-cli@8
  ```
* Register to the Service Provider <a href="https://paas.anynines.com/">Anynines</a>
* A preferred IDE or Text Editor
* JDK8 (Optional)
* Maven (Optional)

<!-- Getting Started -->
## Getting Started

### The CLI

The cf CLI is communicating with the Cloud Foundry API, enabling developers to make requests to the API in a user-friendly way.

* Show version
  ```sh
  cf version
  ```
* Show documentation
  ```sh
  cf help
  ```
  ```sh
  cf help -a
  ```
  ```sh
  cf <command> -h
  ```
* Aliases
  ```sh
  cf -v
  ```
  
### Using a Cloud Foundry

The Cloud Foundry Command Line Interface (cf CLI) is the tool used for communicating with any instance of Cloud Foundry. 
It operates by making RESTful calls to the specific API endpoint of the Cloud Foundry instance in use.

* Setting the Endpoint
  ```sh
  cf api <API_ENDPOINT>
  ```
  ```sh
  cf api https://api.de.a9s.eu
  ```
  ```sh
  cf api
  ```
* Authentication
  ```sh
  cf login
  ```
* Logout 
  ```sh
  cf logout
  ```

### Deploying your First App

Cloud Foundry is a specially designed platform intended to enhance the developer experience by simplifying the processes of deploying and managing applications.

1. Here is my source code,
2. Run it on the cloud for me.
3. I do not care how.

* cf push command
  ```sh
  cd resources/first-push
  ```
  ```sh
  cf push
  ```
The push command, by default, searches for a manifest.yml file in the current directory and uses it to deploy the application.

```yml
applications:
  - name: first-push #This is the name of your application in Cloud Foundry.
    memory: 32M #This indicates the memory allocated for the container of each application instance.
    disk_quota: 64M #This denotes the disk space allocation for the container of each application instance.
    instances: 1 #This represents the number of instances of the application that Cloud Foundry is instructed to create.
    random-route: true #This implies that Cloud Foundry should autonomously generate a random route for application access.
    buildpacks: #This specifies the buildpack(s) to be used in containerizing your application. In this scenario, only the staticfile_buildpack is necessary.
      - staticfile_buildpack
```

<!-- Core Concepts -->
## Core Concepts

### Orgs and Spaces

Organizations (orgs) and spaces represent logical divisions within a Cloud Foundry instance. 
Orgs serve as the parent structure for spaces, and a single org can encompass multiple spaces.

Orgs are frequently used to distinguish between tenants or projects. For instance, you might want to partition your Cloud Foundry instance 
into distinct orgs for different business units. Within each org, you could create separate spaces for various stages of the lifecycle, such as development, staging, and production.

Even though the usage of orgs and spaces is mandatory in Cloud Foundry, the way in which you employ them is entirely at your discretion.

### Targeting

* Show the current target (orgs and spaces)
  ```sh
  cf target
  ```
* Change the target  
  ```sh
  cf target -o <org> -s <space>
  ```
  
### Scope and Names

In the previous segment, we deployed an application to a space. All applications are deployed within a space, and each space is associated with a specific org (you cannot directly deploy an app to an org). As you will learn later in the course, other components, such as service instances and routes, are also assigned to specific spaces. Therefore, before you can manage the resources of a space, you need to target it first.

When you used the cf push command to deploy the app, you provided a name for it (via the manifest), in this case, 'first-push'. By naming the app, you can refer to it more conveniently within Cloud Foundry. Although some commands may default to using these names (like when creating a route for your 'first-push' app), the names are primarily meant for human use. We will delve deeper into resource names later in this module.

You can retrieve details of your app by using its name with the following command:

  ```sh
  cf app first-push
  ```

Since apps are confined to a specific space, their names must be unique within that space. However, the names don't have to be unique outside of that space. Therefore, you could have an app named 'first-push' in the development, staging, and production spaces. Likewise, other users can have their own 'first-push' app within their respective spaces.

Resource names hold significant importance in Cloud Foundry. They are frequently used when executing actions with the CLI and, in certain scenarios, are set based on a default value. Consider the 'first-push' example once again. The app manifest contains `random_route: true`. This instruction tells Cloud Foundry to generate a random route for our app using the resource name.

If the random-route directive hadn't been established, a default route would have been created, which would be based on the chosen resource name. In our example, the default route would look something like `http://first-push.<mydomain.io>`.

### GUIDs and Renaming

Along with resource names, objects created in Cloud Foundry are assigned a globally unique identifier (GUID). Like resource names, an object's GUID will sometimes be passed to CLI commands. Unlike resource names, guids are globally unique.

You can rename certain objects in Cloud Foundry. When an object is renamed, the GUID does not change.

* Print app details with guid
  ```sh
  cf app first-push --guid
  ```
* Rename the app 
  ```sh
  cf rename first-push renamed-app
  ```
* GUID is still same
  ```sh
  cf app first-push --guid
  ```

### Deleting App

* Delete app command
  ```sh
  cf delete -r renamed-app
  ```

The `-r` flag tells Cloud Foundry to also delete the route.