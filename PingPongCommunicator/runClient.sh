#!/bin/bash
# Projeyi temizler ve derler
mvn clean compile

# PlayerClient sınıfını çalıştırır
mvn exec:java -Dexec.mainClass=org.example.PlayerClient