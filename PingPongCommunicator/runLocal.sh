#!/bin/bash
mvn clean compile
mvn exec:java -Dexec.mainClass=org.example.Main -Dexec.args="local"