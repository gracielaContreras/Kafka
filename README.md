# kafka configuration

# Ejecutar servidores zookeeper y kafka
## Antes de iniciar los servidores se debe cambiar las ruta en el archivo:

1. **zookeeper.properties:** crear carpeta zookeeper_data en la raiz de kafka y luego en la carpeta config editar el archivo **zookeeper.properties** la ruta
    
    **dataDir: =C:\Windows\Temp\kafka_2.13-3.4.0\config\zookeeper_data**
    
2. **server.properties:** crear carpeta kafka_logs en la raiz de kafka y luego en la carpeta config editar el archivo server.properties la ruta:
    
    **log.dirs=C:\Windows\Temp\kafka_2.13-3.4.0\config\kafka_logs**
    
    además agregar lo siguiente:
    
    **offsets.topic.num.partitions=1**
    
    **default.replication.factor=1**

## Iniciar zookeeper

comando:

zookeeper-server-start.bat C:\Windows\Temp\kafka_2.13-3.4.0\config\zookeeper.properties

## Iniciar kafka

comando:

kafka-server-start.bat C:\Windows\Temp\kafka_2.13-3.4.0\config\server.properties

## Comandos
### Consultar servicio kafka

comando:

zookeeper-shell.bat localhost:2181 ls /brokers/ids

### Creamos un topic de kafka

comando:

kafka-topics.bat --bootstrap-server localhost:9092 --create --topic prueba-topic --partitions 5 --replication-factor 1

Este comando recibe los siguientes parámetros:

- bootstrap- server = Kafka server
- topic = Nombre del topic a crear
- partitions = Número de particiones
- replication- factor = Número de réplicas por broker

### Listar todos los topics de kafka
comando:

kafka-topics.bat --list --bootstrap-server localhost:9092

### Si deseas consultar cómo se definió un topic
comando:

kafka-topics.bat --describe --topic prueba-topic --bootstrap-server localhost:9092

### Crear un productor
comando:

kafka-console-producer.bat --topic prueba-topic --bootstrap-server localhost:9092

Este comando lo que hace es enviar información a kafka

### Consumir mensajes de kafka
comando:

kafka-console-consumer.bat --topic prueba-topic --from-beginning --bootstrap-server localhost:9092

Este comando en lista todos los mensajes que ha recibido

### Este comando solo muestra el nuevo mensaje que ha recibido
Comando:

kafka-console-consumer.bat --topic prueba-topic --bootstrap-server localhost:9092