#!/bin/bash
cd $CO_EVOLUTION_DIR
latex ResultCospan.tex
dvips ResultCospan.dvi
ps2pdf ResultCospan.ps

#Cleanup:
rm *.aux
rm *.log
rm *.dvi
rm *.ps
rm *.dot
rm *.eps


