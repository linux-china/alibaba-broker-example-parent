job "rsocket-example-job" {
  datacenters = [
    "dc1"]
  type = "service"
  group "rsocket-example-group" {
    count = 1

    task "rsocket-responder" {
      driver = "java"
      config {
        jar_path = "rsocket-responder/target/rsocket-responder-1.0.0-SNAPSHOT.jar"
        jvm_options = [
          "-Dserver.port=0",
          "-Drsocket.brokers=tcp://10.0.0.143:9999",
          "-Xmx512m",
          "-Xms256m"]
      }
      resources {
        cpu = 500
        # MHz
        memory = 1024
        # MB
        network {
          port "http" {}
        }
      }
    }
    task "rsocket-requester" {
      driver = "java"
      config {
        jar_path = "rsocket-requester/target/rsocket-requester-1.0.0-SNAPSHOT.jar"
        jvm_options = [
          "-Dserver.port=0",
          "-Drsocket.brokers=tcp://10.0.0.143:9999",
          "-Xmx512m",
          "-Xms256m"]
      }
      resources {
        cpu = 500
        # MHz
        memory = 500
        # MB
        network {
          port "http" {}
        }
      }
    }
    restart {
      attempts = 1
    }
  }
}