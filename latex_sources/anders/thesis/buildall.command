#!/bin/bash
THESIS_DIR=`pwd`
echo $THESIS_DIR
mkdir ../tempdir 
cd ../tempdir
##rm *
cd $THESIS_DIR
pdflatex -output-directory ../tempdir ./thesis_main.tex
cd ../tempdir
bibtex ./thesis_main.aux
cd $THESIS_DIR
pdflatex -output-directory ../tempdir ./thesis_main.tex
pdflatex -output-directory ../tempdir ./thesis_main.tex
cp ../tempdir/thesis_main.pdf ../thesis_main.pdf
