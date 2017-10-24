cd rest-cliente && mvn clean install &&
cd ../rest-hotel && mvn clean install &&
cd ../rest-passagem && mvn clean install &&
cd ../rest-agencia && mvn clean install && 
cd .. && docker-compose up --build
