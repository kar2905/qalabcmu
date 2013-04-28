MAIN= qalabpaper

STYPARTS= llncs.cls llncsdoc.sty

ALL= $(MAIN).tex $(TEXPARTS) $(BIBPARTS) $(FIGPARTS) $(STYPARTS) $(OTHER)

$(MAIN).pdf: $(MAIN).tex $(TEXPARTS)
	pdflatex $(MAIN).tex
#	bibtex $(MAIN)
	pdflatex $(MAIN).tex
	pdflatex $(MAIN).tex

clean:
	\rm -f *.dvi $(MAIN).ps *.bbl *.aux *.log *.blg *.toc all.tar* uu \
	*~ *.bak *.lbl *.brf $(MAIN).out
