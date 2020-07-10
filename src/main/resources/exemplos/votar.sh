#!/bin/bash

curl --request POST \
  --url http://localhost:8080/api/v1/votacao \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: 0b7c9b44-14b7-2028-d171-ddbe3a03a23b' \
  --data '{\n	"cpfAssociado": "90385092008",\n	"voto": true,\n	"pauta": 1\n}'