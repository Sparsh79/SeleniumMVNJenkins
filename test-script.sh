apt install libnss

apt install libnss3-dev libgdk-pixbuf2.0-dev libgtk-3-dev libxss-dev

cd selenium
echo "starting test-script from directory: $ROOT"

mvn test
