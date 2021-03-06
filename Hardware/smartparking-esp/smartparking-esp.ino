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
HTTPClient http;    //Declare object of class HTTPClient
const String nome = "Vaga-A4";
bool estadoVaga;
int intervalo = 1000;
const String url = "http://192.168.1.103:8081/api/monitoramento";
const String nomeDaRede = "Norte";
const String senhaDaRede = "96427744"; 
const float distanciaLimite = 30;

void setup() {
  Serial.begin(115200);                                  //Serial connection
  pinMode(ledAzul, OUTPUT);
  pinMode(ledVerde, OUTPUT);
  pinMode(ledVermelho, OUTPUT);
  WiFi.begin(nomeDaRede, senhaDaRede);   //WiFi connection
  while (WiFi.status() != WL_CONNECTED) {  //Wait for the WiFI connection completion
    delay(500);
    Serial.print("Conectando ao wifi: ");
    Serial.println(nomeDaRede);
  }
  Serial.println("Conexão com wifi estabelecida");
}
 
void loop() {
  float distanciaEmCM;
  long microsec = ultrasonic.timing();
  distanciaEmCM = ultrasonic.convert(microsec, Ultrasonic::CM);
  Serial.print("CM: ");
  Serial.println(distanciaEmCM);
  if(distanciaEmCM <= distanciaLimite){
    acendeLedVermelho();
    if(!estadoVaga){
      enviarEstadoDaVaga(distanciaEmCM);
      }
    estadoVaga = true;
  }
  if(distanciaEmCM > distanciaLimite){
    acendeLedVerde();
    if(estadoVaga){
      enviarEstadoDaVaga(distanciaEmCM);
      }
    estadoVaga = false;
  }
  delay(intervalo);
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
void enviarEstadoDaVaga(float distanciaEmCM){
  if(WiFi.status()== WL_CONNECTED){   //Check WiFi connection status
    StaticJsonBuffer<300> JSONbuffer;   //Declaring static JSON buffer
    JsonObject& JSONencoder = JSONbuffer.createObject();

    JSONencoder["nomeSensor"] = nome;
    JSONencoder["estadoVaga"] = distanciaEmCM;
    char JSONmessageBuffer[300];
    JSONencoder.prettyPrintTo(JSONmessageBuffer, sizeof(JSONmessageBuffer));
    
    http.begin(url);      //Specify request destination
    http.addHeader("Content-Type", "application/json");  //Specify content-type header
    int httpCode = http.POST(JSONmessageBuffer);   //Send the request
    String payload = http.getString();                  //Get the response payload
    
    Serial.print("Codigo de retorno da requisicao: ");
    Serial.println(httpCode);   //Print HTTP return code
    Serial.print("Corpo da resposta da requisicao: ");
    Serial.println(payload);    //Print request response payload
    Serial.print("Json enviado: ");
    Serial.println(JSONmessageBuffer);
 
    http.end();  //Close connection     
  }else{
    Serial.println("Erro na conexao com WiFi");   
  }
}
