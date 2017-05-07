all:
	cd srcUml && java -jar plantuml.jar -o "../uml" *
	pdflatex -synctex=1 -interaction=nonstopmode main.tex
clean:
	find . -name '*.acn ' -delete
	find . -name '*.alg' -delete
	find . -name '*.glg' -delete
	find . -name '*.glo' -delete
	find . -name '*.gls' -delete
	find . -name '*.glsdefs' -delete
	find . -name '*.ist' -delete
	find . -name '*.xdy' -delete
	find . -name '*.acr' -delete
	find . -name '*.bbl' -delete
	find . -name '*.blg' -delete
	find . -name '*.aux' -delete
	find . -name '*.dvi' -delete
	find . -name '*.log' -delete
	find . -name '*.lot' -delete
	find . -name '*.idx' -delete
	find . -name '*.toc' -delete
	find . -name '*.lof' -delete
	find . -name '*.brf' -delete
	find . -name '*.out' -delete
	find . -name '*.gz' -delete
	find . -name '.DS_Store' -delete
	find . -name 'main.run.xml' -delete
	find . -name 'main.pdf' -delete
	find srcUml/ -name '*.png' -delete
	rm -rf uml
buildUml:
	cd srcUml && java -jar plantuml.jar -o "../uml" *