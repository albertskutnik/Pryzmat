Opis projektu

symulacja cyberataku Log4Shell
środowisko: 2 maszyny wirtualne:
kali linux - atakujacy (Nmap, python)
ubuntu server - ofiara (java, podatna biblioteka Log4j, serwer dokumentow)


1. Active Scanning: Vulnerability Scanning
ID: T1595.002
https://attack.mitre.org/techniques/T1595/002/

opis: skanujemy serwer Nmap,  identyfikujemy działającą aplikacje java i sprawdzamy czy jest podatność na CVE-2021-44228(Log4Shell) (podatnośc znaleziona tutaj: https://attack.mitre.org/techniques/T1190/)


2. Exploit Public-Facing Application
ID: T1190
https://attack.mitre.org/techniques/T1190/

wykorzystujemy Log4Shell do wykonania kodu na serwerze


3. Data from Local System
ID: T1005
https://attack.mitre.org/techniques/T1005/

po uzyskaniu dostępu zbieramy fikcyjnie przygotowane pliki

4. Exfiltration Over Alternative Protocol: Exfiltration Over Unencrypted Non-C2 Protocol
ID: T1048.003
https://attack.mitre.org/techniques/T1048/003/

przesyłamy dane na maszyne kali

teraz technicznie atak sie zakończył ale jeszcze przygotować trzeba też logi z ataku:

5. Exploit Public-Facing Application – multi-signal correlation (request → error → post-exploit process/egress)
ID: DET0080
https://attack.mitre.org/detectionstrategies/DET0080/

monitorujemy ruch sieciowy żadania http i procesy

6. aktualizujemy software i ponownie wykonujemy atak i patrzymy co sie dzieje.


