#!/bin/bash

curl --request POST \
  --url http://localhost:8080/api/v1/sessao \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: bdab4e5f-c165-e178-f15c-cf85337574fc' \
  --data '{\n	"pauta": 1,\n	"duracao": 10\n}'
