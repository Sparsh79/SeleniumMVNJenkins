
cd selenium

su root -c "docker-compose -f docker-compose-chrome.yml up -d --build"

sleep 15

echo "Chrome image is up, will start the execution now"

mvn test
