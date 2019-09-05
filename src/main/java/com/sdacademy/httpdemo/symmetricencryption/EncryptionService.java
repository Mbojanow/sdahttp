package com.sdacademy.httpdemo.symmetricencryption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionService {

  public void process(final String inputFile, final String outputFile, final int mode, final long seed) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    // czytanie danych z pliku
    final byte[] inputData = Files.readAllBytes(Paths.get(inputFile));

    // tworzenie WARTOŚCI klucza do enkrypcji symetrycznej
    final byte[] keyValue = new byte[32];
    new Random(seed).nextBytes(keyValue);
    // tworzenie obiektu KLUCZA, za pomocą WARTOŚCI, jest to klucz do ENCYRPCJI/DEKRYPCJI  algorytmu AES
    // klucz ma dlugosc 256 bit - co definiuje standard
    final SecretKeySpec key = new SecretKeySpec(keyValue, "AES");

    // tworze obiekt ktory wykorzysta moj klucz i algorytm AES
    final Cipher cipher = Cipher.getInstance("AES");

    // INITICJALIZACJA obiektu kluczem
    cipher.init(mode, key);

    // wykonanie operacji za pomoca klucze - encrypcja (mode == 1), dekrypcka (mode == 2)
    final byte[] output = cipher.doFinal(inputData);

    // zapisanie zaenkryptowanych danych / zdekryptowanych do pliku
    Files.write(Paths.get(outputFile), output, StandardOpenOption.CREATE_NEW);
  }
}
