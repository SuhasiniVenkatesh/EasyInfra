#!/bin/bash
#### Author: Adithya B, Asst. Prof. Dept of CSE ####
#### Created Date: 15/05/2016        ####


#### Create Output folder Structures ####
OutPutFolder=$HOME/EasyInfraOutputFolder
mkdir $OutPutFolder
while read line
do
	junctionName=`echo $line | cut -d ',' -f 1`
	mkdir $OutPutFolder"/"$junctionName
	
	lattitute=`echo $line | cut -d ',' -f 2`
	longitude=`echo $line |cut -d ',' -f 3`
	sh mapGenerator.sh $lattitute $longitude $junctionName
done<junctions.txt	


#### Create map.html ####

