[![CircleCI](https://circleci.com/gh/MahinderChhapola/microservice-cicd-kubernetes/tree/master.svg?style=svg)](https://circleci.com/gh/MahinderChhapola/microservice-cicd-kubernetes/tree/master)
# Kubernetes CICD

## Project Overview

This is a final project of the Udacity devops programme. It includes the frontend which is deployed on the S3 and backend deployed using the aws kubernetes services. 
The application shows the basic employees portal and uses Mysql database for storage. CircleCi has been used to automate the process. SonarCloud and lint is used for code quality.
Also used the Cloudfront for distribution purpose. AWS Cloudformation is used to create S3 and update cloudfront. While the AWS EKSCTL is used for creating and managing kubernetes cluster, deployment and service.


### Project files structure and description

The project consists of-

* Angular frontend Application `angular8-crud-demo`
* Springboot backend Application `springboot-crud-api`
* CircleCi 'config.yml'
* Cloudformation scripts

