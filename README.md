## SmartParking

Para clonar o repositorio:
    
    git clone https://github.com/Norbertoooo/SmartParking.git

Para executar docker compose com todos serviços (Banco, monitor, api):
    
    docker-compose -f docker-compose.yml up -d

Para iniciar smartparking-api pelo console:
    
    cd Backend\ReactiveSmartparking-api
    ./mvnw spring-bot:run

Para iniciar smartparking-monitor pelo console:
    
    cd Frontend\angular
    npm install
    npm start

Para iniciar docker compose com apenas banco e o monitor:

    docker-compose -f db-monitor up -d
    
Para criar um container da api:

    cd Backend\ReactiveSmartparking-api
    mvnw clean package docker:build
    docker run -p 8081:8081 -itd --name smartparking-api smartparking-api:1.0.0-SNAPSHOT --network="host"

Para criar 




Tecnologias usadas:

    Spring Boot
    
    Spring Web Flux
    
    Banco de dados SQL Postgres

    Angular
    
    Banco de dados NOSQL Mongodb
    
    
    
    
