#!/bin/bash

set -e


APP_DIR="/opt/crunch"  
LOG_FILE="/var/log/crunch_app.log"
PID_FILE="/var/run/crunch_app.pid"

APP_DIR="/home/hamza/project/chat-app" 

if [ ! -d "$APP_DIR" ]; then
    echo "Error: Application directory $APP_DIR does not exist. Exiting."
    exit 1
fi

cd "$APP_DIR"

if ! python3 -c "import cloudinary" &>/dev/null; then
    echo "Installing Cloudinary Python package..."
    pip3 install --no-cache-dir cloudinary
else
    echo "Cloudinary Python package already installed."
fi

if [ -f "$PID_FILE" ] && kill -0 "$(cat $PID_FILE)" &>/dev/null; then
    echo "Crunch application is already running with PID $(cat $PID_FILE). Exiting."
    exit 0
fi

# Run the application
echo "Starting the Crunch Flask application..."
nohup python3 app.py > "$LOG_FILE" 2>&1 &

# Save the process ID
CRUNCH_PID=$!
echo $CRUNCH_PID > "$PID_FILE"

echo "Crunch application is running with PID $CRUNCH_PID. Logs can be found in $LOG_FILE."

