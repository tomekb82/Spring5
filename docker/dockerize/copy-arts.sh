#!/usr/bin/env sh

cd "$(dirname "$0")"

cp ../../target/spring-app-1.0-SNAPSHOT.jar spring-app.jar
cp -r ../../target/dependencies .
mkdir snapshot-dependencies
mv dependencies/*-SNAPSHOT.jar snapshot-dependencies/
