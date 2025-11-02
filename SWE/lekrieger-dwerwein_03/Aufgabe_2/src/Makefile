# Java Compiler und Runner
JCC = javac
JR = java

# Verzeichnis für die kompilierten Klassen
BINDIR = bin

# Compiler-Flags. -d $(BINDIR) weist den Compiler an .class-Dateien im bin-Verzeichnis abzulegen
JFLAGS = -d $(BINDIR)

# Quelldateien
SOURCES = Main.java A.java B.java

# Abgeleitete .class-Dateien aus den .java-Dateien
CLASS_FILES = $(patsubst %.java,$(BINDIR)/%.class,$(SOURCES))

# Hauptklasse, die run ausführen soll
MAIN_CLASS = Main

# .PHONY: Deklariert Ziele, die keine realen Dateien sind, verhindert Namenskonflikte
.PHONY: all build run clean version

# Standardziel; wird ausgeführt, wenn nur 'make' aufgerufen wird
.DEFAULT_GOAL = build

# führt 'version' und 'run' nacheinander aus
all: version run

# das eigentliche Kompilierungs-Ziel, es hängt von allen .class-Dateien ab
build: $(CLASS_FILES)
	@echo "Build erfolgreich abgeschlossen."

# 'run'führt die Main-Klasse aus und kompiliert die .class-Dateien
run: build
	@echo "Führe $(MAIN_CLASS) aus..."
	@$(JR) -cp $(BINDIR) $(MAIN_CLASS)

# 'clean' löscht das bin-Verzeichnis und alle kompilierten Dateien
clean:
	@echo "Räume Verzeichnis $(BINDIR) auf..."
	@rm -rf $(BINDIR)

# 'version' gibt die Java-Version aus
version:
	@echo "--- Aktuelle Java-Version ---"
	@$(JR) -version
	@echo "-----------------------------"


# $(CLASS_FILES) hängt von $(BINDIR) ab; stellt sicher, dass das Verzeichnis vor dem ersten Kompilieren erstellt wird, aber nicht bei jedem Aufruf neu getriggert wird
$(CLASS_FILES): | $(BINDIR)

$(BINDIR):
	@mkdir -p $(BINDIR)

# erklärt, wie man aus einer '%.java'-Datei (Voraussetzung) eine '$(BINDIR)/%.class'-Datei (Ziel) erstellt

$(BINDIR)/%.class: %.java
	@echo "Kompiliere $<..."
	@$(JCC) $(JFLAGS) $<
