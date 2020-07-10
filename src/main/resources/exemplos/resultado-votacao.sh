#/bin/bash

curl --request GET \
  --url http://localhost:8080/api/v1/votacao/resultado/sessao/1 \
  --header 'cache-control: no-cache' \
  --header 'postman-token: 88166812-dc44-1ac5-cd38-a6cac2c4e298'