# eureka-demo

This is a very simple project that demonstrates client-side load balancing with Spring Boot, Eureka and Kubernetes. It contains 3 microservices:

* Eureka server
* gateway service, which proxies requests and balances the load
* single-threaded worker service, which simiulates expensive request via `Thread.sleep`

If you happen to have Minikube and Apache Benchmark installed, you can play with it:

* `minikube start`
* `./ci.sh`
* `ab -c 10 -n 1000 $(minikube ip):31000/sleep/100`
* `kubectl scale deployment worker --replicas=2`
* repeat `ab` test


and observe, that increasing the number of instances makes the total time smaller.
