Welche Platform? 
- GitHub

Wie ist die Pipelpine aufgebaut?
- Eigentlich: Aufruf bei jeder Änderung in der main branch - HIER: Bei jeder Änderung
- Ein primärer Job: build_und_test
- working directory lässt alle Befehle im richtigen Pfad ausführen
- Folgende Schritte werden ausgeführt:
    1. Code wird aus dem Repository geholt
    2. Java (JDK 25) wird auf dem Server installiert
    3. Java wird kompiliert
    4. Main wird ausgeführt

Was passiert bei einem push?
Bei jedem Push führt die Pipeline den Test aus.
Hierbei wird Main aufgerufen und bei einem Fehler, in dem Fall wenn 5+7!=12, wird System.exit(1) ausgeführt, was von der Pipeline als Fehler erkannt wird.