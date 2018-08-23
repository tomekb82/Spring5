#!/usr/bin/env sh

cd "$(dirname "$0")"

mvn package -f ../../pom.xml -Dmaven.test.skip -Dsonar.skip -Dcheckstyle.skip

./copy-arts.sh

docker build -t spring-app .

rm -r spring-app.jar dependencies snapshot-dependencies