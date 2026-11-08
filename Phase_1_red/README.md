aby odpalic dwie maszynki na windowsie potrzeba:
Oracle virtualboxa
vagrant 

póżniej odpalamy powershela i odpalamy te komendy poniżej, maszynki powinny sie postawić
(u mnie dziala)

problemy mialem z ustawieniem kali, poniewaz polaczenie miedzy maszynkami nie dzialalo i recznie trzeba bylo ustawic eth1


```powershell
cd sciezka do folderu phase_1_red (w nim trzeba byc)
vagrant validate
vagrant up
vagrant status
vagrant ssh kali -c "ip -br address"
vagrant ssh ubuntu -c "ip -br address"
vagrant ssh ubuntu -c "sudo docker ps"
vagrant ssh kali -c "ping -c 4 192.168.56.20"
vagrant ssh kali -c "curl -f 'http://192.168.56.20:8080/?test=hello'"
vagrant ssh ubuntu -c "sudo docker logs log4shell-demo"
```

co do samej aplikacji, to apka jest podatna na atak ktory chcemy przeprowadzic poniewaz w buildzie uzywamy tej podatnej biblioteki w odpowiedniej wersji

trzeba wyslac zapytanie typu JNDI czyli po znaku ? trzeba napisac taki kod JNDI ktory pozwoli nam uruchomić mechanizm JNDI lookup i uzyć LDAP, do zrobienia kolejne


