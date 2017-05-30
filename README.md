#  IoT Healthcare backend
## Bitbucket pipelines will deploy master branch to Production and develop/features branches to Integration

# Production URL: https://iothealthcare.herokuapp.com
# Integration URL: https://intiothealthcare.herokuapp.com

## About



# Prerequisite
* jdk
* nodejs

## Build the project
```sh
git clone
npm install
./gradlew clen build
```
## Run the project
```sh
git clone
npm install
./gradlew clen build run
```

## Workenv
```sh
install eclipse
install eclipse buildship
install node
npm install -g grunt-cli
npm install -g bower
```

## SonarQube
```sh
install docker
install sonarqube container
generate your token
```

```sh
 gradlew clean build sonarqube -Dsonar.host.url=http://localhost:<port> -Dsonar.token=<token>
```