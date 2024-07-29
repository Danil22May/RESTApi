### USER MANAGMENT REST api
## URL
Server is working on 8000 port which you can configure in application.properties
## Endpoints
Get all users "users/all"<br />
Get one user "users/{id}"<br />
Create a new user "/add/user"<br />
Edit an existing user "/edit/user/{id}"<br />
Delete an existing user "/delete/user/{id}"<br />
## DB Docker image
docker run --hostname=f41b72bb7768 --env=MYSQL_ROOT_PASSWORD=password --env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin --env=GOSU_VERSION=1.17 --env=MYSQL_MAJOR=8.0 --env=MYSQL_VERSION=8.0.38-1debian12 --volume=/var/lib/mysql --network=bridge -p 3306:3306 --restart=no --runtime=runc -d mysql:8.0-debian
