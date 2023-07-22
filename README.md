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
        <li><a href="#deploy-the-first-app">Deploy the First App</a></li>
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

