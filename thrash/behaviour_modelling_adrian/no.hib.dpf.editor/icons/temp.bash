#!/bin/bash
for file in *.png
do
 filename="${file}"
 temp=${filename%.*}
 `inkscape -e="${temp}_16.png" -w 16 -h 16 -z ${filename}`
mv "${temp}.png" "${temp}_32.png"
#`inkscape -e=\"${temp}_.png\" -w 32 -h 32 -z ${filename}`
done

