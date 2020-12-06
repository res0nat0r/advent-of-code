clean:
  for x in p*; do cd $x; lein clean; cd ..; done

run:
  for x in p*; do cd $x; lein run; cd ..; done
