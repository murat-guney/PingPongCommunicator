# Player Communication Project
## Overview
This project implements a simple communication system between two players, `Initiator` and `Receiver`,
using Java. It features both local and network-based communication modes,
allowing each player to operate in separate processes.

The project includes several scripts to facilitate different running configurations:

Local Mode: To run both players within the same process, execute:
./runLocal.sh

Server Mode: To start the server for network communication, execute:
./runServer.sh

Client Mode: To start the client that connects to the server, execute:
./runClient.sh

Ensure that these scripts are executable (chmod +x runLocal.sh runServer.sh runClient.sh).