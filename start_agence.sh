#!/bin/bash

database_url=$1
database_user=$2
database_password=$3

start_agence() {
  agence_name=$1
  agence_password=$2
  server_port=$3
  database_url=$4
  database_user=$5
  database_password=$6

  java -Dspring.datasource.url="${database_url}" \
       -Dspring.datasource.username="${database_user}" \
       -Dspring.datasource.password="${database_password}" \
       -Dserver.address=127.0.0.1 \
       -Dserver.port=${server_port} \
       -Dagence.nom="${agence_name}" \
       -Dagence.motDePasse="${agence_password}" \
       -jar agence-service-0.0.1-SNAPSHOT.jar
}

start_agence "Voyage Express" "motDePasse1" 4000 "${database_url}" "${database_user}" "${database_password}" &
sleep 5
start_agence "Super Trip" "motDePasse2" 4001 $1 $2 $3 &
sleep 5
start_agence "Footiz Agence" "motDePasse3" 4002 $1 $2 $3 &
