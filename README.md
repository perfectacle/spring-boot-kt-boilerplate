# Build
```shell script
./gradlew clean bootBuildImage
docker-compose build # for nginx
```

# Run
## local
```shell script
./gradlew bootRun --args='--spring.profiles.active=local'
curl localhost:8080/health # ok
```

## docker-compose (nginx + spring boot)
```shell script
docker-compose up -d
curl localhost/health # ok
```

### change phase
#### dev
```shell script
docker-compose down
export SPRING_PROFILES_ACTIVE=dev
docker-compose up -d
curl localhost/health # ok
```

#### live
```shell script
docker-compose down
export SPRING_PROFILES_ACTIVE=live
docker-compose up -d
curl localhost/health # ok
```