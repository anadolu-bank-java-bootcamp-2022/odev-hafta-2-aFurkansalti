package com.gokhantamkoc.javabootcamp.odevhafta2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayWorldOfMagic implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(PlayWorldOfMagic.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int maxNumOfAttacksAllowed = 9;
		String[] magicianSpells = createSpellNameRepository();
		float[] spellDamageInfo = createSpellDamageRepository();
		String[] bossNames = createBossNameRepository();
		float[] bossHps = createBossHPRepository();
		
		int minNumberSpellsUsed = resolveBattle(
				magicianSpells, 
				spellDamageInfo, 
				bossNames, 
				bossHps);
		
		if (minNumberSpellsUsed > maxNumOfAttacksAllowed) {
			System.out.println("Magician died!");
		} else if (minNumberSpellsUsed > 0 && minNumberSpellsUsed <= maxNumOfAttacksAllowed) {
			System.out.println("Magician won the battle!");
		} else {
			System.out.println("Result is not correct!");
		}
	}
	
	public static int resolveBattle(
			String[] magicianSpells,
			float[] spellDamageInfo,
			String[] bossNames,
			float[] bossHPs
			) {
		
		int spellsUsed = 0;
		// ______ BASLANGIC _______ Kodunuz buradan baslamali
		
		float health0 = bossHPs[0];
		while (true) {
			String randomMagicianSpells = " ";                          // Değerler koşulda atandığı için ilk değer olarak boşluk atadım.
			float randomSpellDamageInfo = 0;

			double randomValue = Math.random() * 100;					// Diğer büyülere de küçük bir şans vermek istedim.
			if ((randomValue >= 0) && (randomValue <= 90)) {
				randomMagicianSpells = magicianSpells[0];
				randomSpellDamageInfo = spellDamageInfo[0];
			} else if ((randomValue > 90) && (randomValue <= 97)) {
				randomMagicianSpells = magicianSpells[1];
				randomSpellDamageInfo = spellDamageInfo[1];
			} else if ((randomValue > 97) && (randomValue <= 100)) {
				randomMagicianSpells = magicianSpells[2];
				randomSpellDamageInfo = spellDamageInfo[2];
			}

			health0 -= randomSpellDamageInfo;							// Random olarak gelen büyü kadar haar vermiş olduğumuz satır.

			System.out.println(randomSpellDamageInfo + " damage done to the " + bossNames[0] + " by " + randomMagicianSpells + ".");

			if (health0 <= 0) {											// Sıfırdan küçükse (-) değerlere inmemesi içi bir koşul.
				System.out.println(bossNames[0] + "'s health is " + 0 + ".");
			} else {
				System.out.println(bossNames[0] + "'s health is " + health0 + ".");
			}

			spellsUsed++;

			if (health0 <= 0.0f) {										// Boss öldüğü zaman döngüden çıktığımız koşul.
				System.out.println(bossNames[0] + " killed!");
				break;
			}
		}

		System.out.println("**************************************");	// Geri kalan kısım yukarıdakiler ile aynı.

		float health1 = bossHPs[1];
		while (true) {
			String randomMagicianSpells = " ";
			float randomSpellDamageInfo = 0;

			double randomValue = Math.random() * 100;
			if ((randomValue >= 0) && (randomValue <= 90)) {
				randomMagicianSpells = magicianSpells[0];
				randomSpellDamageInfo = spellDamageInfo[0];
			} else if ((randomValue > 90) && (randomValue <= 97)) {
				randomMagicianSpells = magicianSpells[1];
				randomSpellDamageInfo = spellDamageInfo[1];
			} else if ((randomValue > 97) && (randomValue <= 100)) {
				randomMagicianSpells = magicianSpells[2];
				randomSpellDamageInfo = spellDamageInfo[2];
			}

			health1 -= randomSpellDamageInfo;

			System.out.println(randomSpellDamageInfo + " damage done to the " + bossNames[1] + " by " + randomMagicianSpells + ".");
			if (health1 <= 0) {
				System.out.println(bossNames[1] + "'s health is " + 0 + ".");
			} else {
				System.out.println(bossNames[1] + "'s health is " + health1 + ".");
			}

			spellsUsed++;

			if (health1 <= 0.0f) {
				System.out.println(bossNames[1] + " killed!");
				break;
			}
		}

		System.out.println("**************************************");

		float health2 = bossHPs[2];
		while (true) {
			String randomMagicianSpells = " ";
			float randomSpellDamageInfo = 0;

			double randomValue = Math.random() * 100;
			if ((randomValue >= 0) && (randomValue <= 90)) {
				randomMagicianSpells = magicianSpells[0];
				randomSpellDamageInfo = spellDamageInfo[0];
			} else if ((randomValue > 90) && (randomValue <= 97)) {
				randomMagicianSpells = magicianSpells[1];
				randomSpellDamageInfo = spellDamageInfo[1];
			} else if ((randomValue > 97) && (randomValue <= 100)) {
				randomMagicianSpells = magicianSpells[2];
				randomSpellDamageInfo = spellDamageInfo[2];
			}

			health2 -= randomSpellDamageInfo;

			System.out.println(randomSpellDamageInfo + " damage done to the " + bossNames[2] + " by " + randomMagicianSpells + ".");

			if (health2 <= 0) {
				System.out.println(bossNames[2] + "'s health is " + 0 + ".");
			} else {
				System.out.println(bossNames[2] + "'s health is " + health2 + ".");
			}

			spellsUsed++;

			if (health2 <= 0.0f) {
				System.out.println(bossNames[2] + " killed!");
				break;
			}
		}

		System.out.println("**************************************");

		System.out.println("Number of spells used: " + spellsUsed);

		System.out.println("**************************************");

		// ______ SON _______ Kodunuz burada bitmeli
		/* NOT: ______ BASLANGIC _______ ve ______ SON _______ 
		 * arasina istediginiz kadar sayida satir ekleyebilirsiniz.
		 */
		return spellsUsed;
	}
	
	public static String[] createSpellNameRepository() {
		return new String[]{"Ice Storm", "Chain Lightning", "Magic Missile"};
	}
	
	public static float[] createSpellDamageRepository() {
		return new float[]{40.0f, 30.0f, 5.0f};
	}
	
	public static String[] createBossNameRepository() {
		return new String[]{"Dire Rat", "Skeleton Knight", "Undead King"};
	}
	
	public static float[] createBossHPRepository() {
		return new float[]{15.0f, 45.0f, 60.0f};
	}
}
