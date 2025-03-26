# rpi-heartbeat
Raspberry PI / Remote device's heartbeat and health metric service
---
Collects and sends the following metrics every minute :
- Device temperature ➡️ `vcgencmd measure_temp`
- CPU Usage ➡️ `cat /proc/stats`
- Memory Usage ➡️ `cat /proc/stats`