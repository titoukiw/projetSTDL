echo ——————————————————————
echo testMJ
echo ——————————————————————
echo nb lignes avec '->'
grep '\->' testMiniJava.egg | wc -l
echo dont 
grep '\->' testMiniJava.egg | grep '^\-\-' | wc -l
echo sont commentées

echo ——————————————————————
echo MJ
echo ——————————————————————
echo nb lignes avec '->'
grep '\->' MiniJava.egg | wc -l
echo dont 
grep '\->' MiniJava.egg | grep '^\-\-' | wc -l
echo sont commentées