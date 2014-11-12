#!/bin/bash
cd $1
latex ResultSpan.tex
dvips ResultSpan.dvi
ps2pdf ResultSpan.ps

#Cleanup:
rm *.aux
rm *.log
rm *.dvi
rm *.ps
rm *.dot
rm *.eps


