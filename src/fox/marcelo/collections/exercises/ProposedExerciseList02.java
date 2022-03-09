package fox.marcelo.collections.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProposedExerciseList02 {
    public static void main(String[] args) {

        /*
         * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime.
         * As perguntas são:
         * 1. Telefonou para a vítima?
         * 2. Esteve no local do crime?
         * 3. Mora perto da vítima?
         * 4. Devia para a vítima?
         * 5. Já trabalhou com a vítima?
         *
         * Se a pessoa responde positivamente a 2 questões ela deve ser classificada como "SUSPEITA",
         * entre 3 e 4 "CÚMPLICE" e 5 como "ASSASSINA".
         *
         * Caso contrário, será classificada como "INOCENTE".
         * */

        Scanner scannerIn = new Scanner(System.in);
        List<String> interviewAnswers = new ArrayList<>();
        String answer;

        System.out.println("Responda essas Perguntas com S - SIM ou N - NÃO");

        System.out.println("Telefonou para a vítima?");
        answer = scannerIn.nextLine();
        interviewAnswers.add(answer);

        System.out.println("Esteve no local do crime?");
        answer = scannerIn.nextLine();
        interviewAnswers.add(answer);

        System.out.println("Mora perto da vítima?");
        answer = scannerIn.nextLine();
        interviewAnswers.add(answer);

        System.out.println("Devia para a vítima?");
        answer = scannerIn.nextLine();
        interviewAnswers.add(answer);

        System.out.println("Já trabalhou com a vítima?");
        answer = scannerIn.nextLine();
        interviewAnswers.add(answer);

        int countYes = 0;
        for (String answers :
                interviewAnswers) {
            if (answers.equalsIgnoreCase("S")) {
                countYes++;
            }
        }

        switch (countYes) {
            case 0:
            case 1:
                System.out.println("INOCENTE");
                break;
            case 2:
                System.out.println("SUSPEITA");
                break;
            case 3:
            case 4:
                System.out.println("CÚMPLICE");
                break;
            default:
                System.out.println("ASSASSINO");
        }
    }
}
