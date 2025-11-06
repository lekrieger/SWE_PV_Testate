class UniversitySystem {

    private ExamEvaluatorInterface evaluator;

    public UniversitySystem() {

        // Die Klasse 'ExamEvaluator' ist weg, stattdessen hier die anonyme innere Klasse:
        this.evaluator = new ExamEvaluatorInterface() { // Anonym, da Klasse keinen eigenen Namen hat
            
            @Override 
            public int evaluate(int score) {
                // Logik von vorher
                if (score >= 50) {
                    return 1; // Bestanden
                } else {
                    return 0; // Nicht bestanden
                }
            }
        }; // Semikolon wichtig
    }

    public void printResult(int studentScore) {
        int result = evaluator.evaluate(studentScore);
        if (result == 1) {
            System.out.println("Der Student hat bestanden.");
        } else {
            System.out.println("Der Student ist durchgefallen.");
        }
    }
    
    public static void main(String[] args) {

        UniversitySystem system = new UniversitySystem();
        system.printResult(65); // Testfall für "bestanden"
        system.printResult(45); // Testfall für "nicht bestanden"
    }
}