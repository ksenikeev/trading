
### список образов
`docker images`

### удаление образа
`docker rmi container_name`

docker run ubuntu
docker run -i ubuntu - присоединение консоли
docker run -it ubuntu - присоединение консоли с терминалом
docker run -d -it ubuntu - отсоединение от контейнера без его остановки (Ctrl-P-Q)
docker attach 8abb1b4a6886 - присоединится к терминалу контейнера

docker ps - список активных контейнеров

docker stop 8abb1b4a6886


Переадресовать открытый порт контейнера на порт основной операционной системы-хоста в
общем случае можно так:
docker run -p [порт основной хост-системы]:[открытый порт контейнера] [\имя образа]

docker run -d -p 8888:80 nginx


Сборка образа
docker build . -t java-hello


Адресация 

172.17.0.0/16 (255.255.0.0)

Запись адреса в /etc/hosts

docker run -td -h guju <image name>

### Собственная статическая адресация
docker network create --subnet=172.18.0.0/16 my_custom_network

docker run --network my_custom_network --ip 172.18.0.2 -d my_image

### Состояние контейнера
docker inspect 6111677b6642



