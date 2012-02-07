#!/bin/bash
cd $CO_EVOLUTION_DIR
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


