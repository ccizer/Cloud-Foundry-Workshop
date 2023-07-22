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

