#include <ESP8266HTTPClient.h>
#include <ESP8266WiFi.h>
#include <Ultrasonic.h>
#include <ArduinoJson.h>

#define TRIGGER_PIN  4
#define ECHO_PIN     5
#define ledVermelho  14
#define ledVerde     12
#define ledAzul      13 

Ultrasonic ultrasonic(TRIGGER_PIN, ECHO_PIN);
const char* nome = "esp8266";
float estadoAnterior;

void setup() {
  Serial.begin(9600);                                  //Serial connection
  pinMode(ledAzul, OUTPUT);
  pinMode(ledVerde, OUTPUT);
  pinMode(ledVermelho, OUTPUT);
  WiFi.begin("Norte", "96427744");   //WiFi connection
  while (WiFi.status() != WL_CONNECTED) {  //Wait for the WiFI connection completion
    delay(500);
    Serial.println("Waiting for connection");
  }
}
 
void loop() {
  float distanciaEmCM;
  long microsec = ultrasonic.timing();
  distanciaEmCM = ultrasonic.convert(microsec, Ultrasonic::CM);
  Serial.print("CM: ");
  Serial.println(distanciaEmCM);
  if(distanciaEmCM <= 10){
    acendeLedVermelho();
    if(WiFi.status()== WL_CONNECTED){   //Check WiFi connection status
      
      StaticJsonBuffer<300> JSONbuffer;   //Declaring static JSON buffer
      JsonObject& JSONencoder = JSONbuffer.createObject();

      JSONencoder["nomeSensor"] = nome;
      JSONencoder["estadoVaga"] = distanciaEmCM;
      char JSONmessageBuffer[300];
      JSONencoder.prettyPrintTo(JSONmessageBuffer, sizeof(JSONmessageBuffer));
  
      HTTPClient http;    //Declare object of class HTTPClient
      http.begin("http://192.168.1.107:8081/api/monitoramento");      //Specify request destination
      http.addHeader("Content-Type", "application/json");  //Specify content-type header
      int httpCode = http.POST(JSONmessageBuffer);   //Send the request
      String payload = http.getString();                  //Get the response payload
   
      Serial.println(httpCode);   //Print HTTP return code
      Serial.println(payload);    //Print request response payload
      Serial.println(JSONmessageBuffer);
   
      http.end();  //Close connection
   
   }else{
    Serial.println("Error in WiFi connection");   
  }
  }
  if(distanciaEmCM > 10){
    acendeLedVerde();
    }
  delay(2000);
}
 
void acendeLedVermelho(){
  digitalWrite(ledAzul, LOW);
  digitalWrite(ledVerde, LOW);
  digitalWrite(ledVermelho, HIGH);
}
void acendeLedVerde(){
  digitalWrite(ledAzul, LOW);
  digitalWrite(ledVerde, HIGH);
  digitalWrite(ledVermelho, LOW);
}