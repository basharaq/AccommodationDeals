# AccommodationDeals
A simple Java webapp that displays hotel information retrieved from an external REST API.

# Running the app locally
The assumption here is that you are using a Linus-based system.

1. Make sure that you have JDK and Maven installed.
You can go [here](http://www.tecmint.com/install-java-jdk-jre-in-linux/) for instructions
to download and install JDK on a Linux-based system. You can ignore the part about installing
Tomcat. This app uses embedded Tomcat so you will not need to explicitly install it.

To install maven simply type ```sudo apt-get install maven``` in your terminal.

2. Clone this repository into a suitable directory on your local machine.

3. Type ```cd AccommodationDeals```
    
4. Type ```mvn package``` to build the project using maven.
    
5. Then type ```sh target/bin/webapp``` to run the app.
    
6. Now you are ready to see the app in action. Open a web browser and go to your [localhost](http://localhost:8080/)
