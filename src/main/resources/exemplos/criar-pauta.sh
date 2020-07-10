#!/bin/bash

curl --request POST \
  --url http://localhost:8080/api/v1/pauta \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: 38b5e240-e35d-0258-11f4-bf9a50cc208d' \
  --data '{\n	"descricao": "Reuniões On-line"\n}'