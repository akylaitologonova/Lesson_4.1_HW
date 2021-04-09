package com.company;

import java.util.Random;

public class Main {
    public static int[] heroesHealth = {270, 280, 250};
    public static String[] heroesNames = {"Lu Kang", "Jax", "Scorpion"};
    public static int[] heroesStrike = {20, 15, 25};

    public static String Medic = "Medic";
    public static int medicHealth = 400;
    public static String toHealHeroes = "";


    public static String bossName = "Shao Kahn";
    public static int bossHealth = 700;
    public static int bossStrike = 50;

    public static String superStrike = "";

    public static int roundNumber = 0;


    public static void main(String[] args) {
        // write your code here
        printStatistics();
        System.out.println("------Thе game started---------");


        while (!isGameFinished()) {
            round();
        }

    }

    public static void round() {
        roundNumber++;
        System.out.println("----------------Round " + roundNumber + "---------------------");
        System.out.println("Super Strike " + superStrike);
        superStrike = getSuperStrikeHero();
        toHealHeroes = toHeal();
        bossHits();
        heroesHits();
        setHeroesHealth();
        printStatistics();
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!! + Mortal Kombat is finished!");
            return true;
        }
        boolean allHeroesDead = true;

        for (int heroHealth : heroesHealth) {
            if (heroHealth > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println(bossName + "Won!!! Mortal Kombat finished");
        }
        return allHeroesDead;
    }

    public static String toHeal() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }

    public static void setHeroesHealth() {
        Random random = new Random();
        int newHealth = random.nextInt(9) + 2;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] < 100) {
                heroesHealth = heroesHealth[i] + newHealth;

            }
        }
    }

    public static void heroesHits() {
        Random random = new Random();
        int coeff = random.nextInt(9) + 2;

        for (int i = 0; i < heroesStrike.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0)


                if (superStrike == heroesNames[i]) {
                    bossHealth = bossHealth - heroesStrike[i] * coeff;
                    System.out.println("Super damage " +
                            (heroesStrike[i] * coeff));
                } else {
                    bossHealth = bossHealth - heroesStrike[i];

                }
            if (bossHealth < 0) {
                bossHealth = 0;
            }

        }
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                heroesHealth[i] = heroesHealth[i] - bossStrike;
            }
            if (heroesHealth[i] < 0) {
                heroesHealth[i] = 0;

            }

        }
    }

    public static String getSuperStrikeHero() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }

    public static void printStatistics() {
        System.out.println(bossName + "=" + bossHealth + " " + "strike [" + bossStrike + "]");
        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + "=" + heroesHealth[i] + " " + "strike [" +
                    heroesStrike[i] + "]");

        }
    }

}






