#!/bin/bash
if [ $(id -u) -ne 0 ]; then
  printf "Script must be run as root. Try 'sudo $0'\n"
  exit 1
fi

# Configure management IP
MANAGEMENT_IP=$(whiptail --nocancel --inputbox "Please enter the management IP" 20 60 "192.168.0.XXX" 3>&1 1>&2 2>&3)
if [ $? -eq 0 ]; then
  sed -i "s/#MANAGEMENT_INTERFACE/iface wlan0:1 inet static/g" /etc/network/interfaces
  sed -i "s/#MANAGEMENT_IP/address $MANAGEMENT_IP/g" /etc/network/interfaces
  sed -i "s/#MANAGEMENT_NETMASK/netmask 255.255.255.0/g" /etc/network/interfaces
fi