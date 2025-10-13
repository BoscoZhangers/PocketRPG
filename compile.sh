#!/bin/bash

echo "Running the compile script..."
cd ~/Desktop/ICS4U1
javac -cp .:arc.jar RPG.java
cd ~/Desktop/PokemonRPG
cp ~/Desktop/ICS4U1/RPG.class .

echo "Successfully compiled and moved binary RPG.class into current directory."

