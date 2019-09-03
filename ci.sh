#!/usr/bin/env bash

./gradlew clean bootJar

eval $(minikube docker-env)
docker build -t kelog/eureka-demo .

kubectl delete -f deployment.yaml
kubectl apply -f deployment.yaml
 
